package Manager;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Counter extends Thread{

    private int time, waitingVisitor, cycle;
    private final Timer temporizer;
    private Guide guide;
    private GuideCounter guideCounter;
    private BlockingQueue blockingQueue;

    public Counter(int cycle){
        this.temporizer = new Timer("Timer");
        this.time = 5; // 15 minutes
        //this.time = 5; // 5 minutes
        this.waitingVisitor = 0;
        this.cycle = cycle;
        this.guide = new Guide();
        this.guideCounter = new GuideCounter(guide);
        blockingQueue = new ArrayBlockingQueue(300);
    }

    @Override
    public void run() {
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                time--;
                Counter.this.run();
            }
        };

        if (time > 0) {
            //long delay = 1000*3600; //1 minute
            int delay = 1000; // 1 second
            temporizer.schedule(task, delay);
        }

        if(time == 0 && cycle != 0){
            try {
                blockingQueue.put(getWaitingVisitors());
                doTourVisitors();
                cycle--;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

        //end the program
        if(cycle == 0){
            this.interrupt();
        }
    }

    /**
     * Choose what is the best option for the number of the visitors
     */
    public void doTourVisitors() throws InterruptedException {

        System.out.println("##############");
        System.out.println("Status: ");
        if(blockingQueue.peek() == null) System.out.println("WaitingVisitors: 0");
        else System.out.println("Waiting Visitors: " + blockingQueue.peek());
        System.out.println("Guides available: " + guide.getGuides());
        System.out.println("##############");

        if(blockingQueue.size() >= 60){
            System.out.println("The tour will start with a metro (60 visitors)");
            blockingQueue.remove();

        }else if(blockingQueue.size() < 60 && blockingQueue.size() >= 30){
            System.out.println("The tour will start with a bus (30 visitors)");
            blockingQueue.remove();

        } else if(blockingQueue.size() < 60 && blockingQueue.size()>=4){
            System.out.println("The tour will start with a taxi (4 visitors)");
            blockingQueue.remove();

        } else if(blockingQueue.size() > 0){
            System.out.println("The tour will start with a uber (" + blockingQueue.take() + " visitors)");

        }

        guide.unavailable();
        guideCounter.run();
        time = 15;
        run();

    }

    public int getWaitingVisitors(){
        return  waitingVisitor;
    }

    public void addWaitingVisitors(){
        waitingVisitor++;
    }

}
