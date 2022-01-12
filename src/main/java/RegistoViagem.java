import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class RegistoViagem {

    private Scanner sc;
    private Destino destino;

    public RegistoViagem(Destino destino){
        this.sc = new Scanner(System.in);
        this.destino = destino;
    }

    public String registar(){

        ArrayList<String> viagemArray = new ArrayList<>();

        while(true) {

            System.out.println("Para onde quer ir?");
            destino.mostrarDestino();
            System.out.println("Sair (não adiciona nenhum destino)");

            String viagemDestino = sc.nextLine();

            if(viagemDestino.equals("Sair")) return "Sair";

            boolean adicionar = adicionar(viagemArray, viagemDestino);

            while(adicionar){

                destino.mostrarDestino();
                System.out.println("Sair - não quero adicionar mais nenhuma");
                System.out.print("Qual é o seguinte?");

                viagemDestino = sc.nextLine();
                if(viagemDestino.equals("Sair")) return null;

                adicionar = adicionar(viagemArray, viagemDestino);
            }
        }
    }

    public boolean adicionar(ArrayList planoViagem, String travel){

        boolean existe = false;

        Iterator iterator = planoViagem.iterator();

        while (iterator.hasNext()){
            String destino = (String) iterator.next();
            if(destino.equals(travel)) {
                planoViagem.add(travel);
                System.out.println("O destino já foi adicionado");
                return true;
            }
        }

        iterator = destino.getTravelList().iterator();

        while (iterator.hasNext()) {
            String destino = (String) iterator.next();
            if (destino.equals(travel)) {
                planoViagem.add(travel);
                existe = true;
            }
        }

        if(!existe)  System.out.println("O destino escrito não existe.");

        return existe;
    }
}
