import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Destino destinos = new Destino();
        RegistoViagem registoViagem = new RegistoViagem(destinos);

        System.out.println("Quantos ciclos quer que o programa percorra?");
        int ciclos = sc.nextInt();
        sc.nextLine();

        if(ciclos == 0) return;

        while(ciclos < 0){
            System.out.println("Tem de adicionar um número inteiro positivo");
            ciclos = sc.nextInt();
            sc.nextLine();
        }

        Visitante visitante = new Visitante(ciclos);

        System.out.println("Gestor: quais são os pontos turísticos que a empresa oferece?");
        System.out.println("Sair - caso não queira adicionar mais nenhum");

        String destino = sc.nextLine();
        if(destino.equals("Sair")) System.out.println("Tem de adicionar pelo menos um ponto turístico");
        else destinos.adicionar(destino.trim());

        do{
            destino = sc.nextLine();
            destinos.adicionar(destino);
        }while(!destino.equals("Sair"));

        while(visitante.getCilos() > 0) {

            System.out.println("---------------");
            System.out.println("No aeroporto: Quais são os destinos para onde queres viajar?");

            if(registoViagem.registar() != "Sair") {
                System.out.println("Quanto tempo quer viajar?");
                int tempo = sc.nextInt();
                sc.nextLine();

                visitante.setTempo(tempo);
                visitante.setVisitantes(visitante.getVisitantes()+1);

            }

            Thread thread = new Thread(visitante);

            if(visitante.getCilos() > 0)
                thread.start();

        }

        System.out.println("O número de ciclos acabou e por isso nenhum grupo de visitantes será criado.");

    }

}
