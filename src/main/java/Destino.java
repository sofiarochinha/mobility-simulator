import java.util.ArrayList;

public class Destino {

    private ArrayList<String> destinoArray;

    public Destino(){
        destinoArray = new ArrayList<>();
    }

    public void adicionar(String name){
        if(name.equals("Sair") || name.equals("sair")) return;
        destinoArray.add(name);
        System.out.println("Adicionado com sucesso");
    }

    public void mostrarDestino(){

        for(int x = 0; x<destinoArray.size(); x++){
            System.out.println(destinoArray.get(x));
        }
    }

    public ArrayList<String> getTravelList(){
        return destinoArray;
    }


}
