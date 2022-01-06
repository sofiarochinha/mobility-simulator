package Manager;

import java.util.Timer;
import java.util.TimerTask;

public class GuideCounter extends Thread{

    private final Timer temporizer;
    private int time;
    private Guide guide;

    public GuideCounter(Guide guide){
        this.time = (int) (Math.random() * 100); // random time for the travel
        temporizer = new Timer("Timer");
        this.guide = guide;
    }

    @Override
    public void run() {
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                time--;
                GuideCounter.this.run();
            }
        };

        if (time > 0) {
            //long delay = 1000*3600; //1 minute
            int delay = 1000; // 1 second
            temporizer.schedule(task, delay);
        }

        if(time == 0){
            time = (int) (Math.random() * 10);
            guide.available();
        }

    }
}
