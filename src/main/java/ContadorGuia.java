public class ContadorGuia extends Thread{

    private int tempo;
    private Guia guia;

    public ContadorGuia(Guia guia, int tempo){
        this.tempo = tempo;
        this.guia = guia;
    }

    @Override
    public void run() {
        if(tempo > 0){
            try {
                Thread.sleep(1000);
                run();

                if(tempo > 0) {
                    tempo = tempo - 1;
                } else if(tempo == 0){
                    guia.setGuias(guia.getGuias()+1);
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
