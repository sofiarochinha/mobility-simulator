import java.util.concurrent.Semaphore;

public class Visitante implements Runnable{

    private int tempo, visitantes, ciclos;
    private Guia guia;
    private ContadorGuia contadorGuia;
    private Semaphore sem;

    public Visitante(int ciclos){
        this.tempo = 15;
        visitantes = 0;
        this.guia = new Guia();
        this.contadorGuia = new ContadorGuia(guia, tempo);
        this.ciclos = ciclos;
        this.sem = new Semaphore(1);
    }

    @Override
    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if(tempo > 0) {
            tempo = tempo - 1;
            run();
        } else if(tempo == 0){

            sem.tryAcquire();

             if(visitantes == 0){
                try {
                    sem.acquire();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            ciclos = ciclos - 1;
            comecaViagem();
        }
    }

    public void comecaViagem() {

        if(visitantes >= 60){
            System.out.println("A viagem irá começar com 60 visitantes e um guia que levará os passageiros de metro");
            visitantes = visitantes - 60;

        }else if(visitantes < 60 && visitantes >= 30){
            System.out.println("A viagem irá começar com 30 visitantes e um guia que levará os passageiros de autocarro");
            visitantes = visitantes - 30;

        } else if(visitantes >=4 && visitantes < 30  ){
            System.out.println("A viagem irá começar com 4 visitantes e um guia que levará os passageiros de taxi");
            visitantes = visitantes - 4;

        } else {
            System.out.println("A viagem irá começar com " + visitantes + " visitantes e um guia que levará os passageiros de uber");
            visitantes = 0;
        }

        guia.setGuias(guia.getGuias()-1);
        
        Thread thread = new Thread(contadorGuia);
        thread.start();
        
        tempo = 15;

    }

    public int getVisitantes() {
        return visitantes;
    }

    public void setVisitantes(int visitantes) {
        this.visitantes = visitantes;
    }

    public void setTempo(int tempo) {
        this.tempo = tempo;
    }

    public int getCilos(){
        return ciclos;
    }
}
