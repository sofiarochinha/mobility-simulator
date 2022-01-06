package Manager;

import travel.Travel;

import java.util.ArrayList;

/**
 *
 */
public class TravelDestiny {

    private ArrayList<String> destiny;

    public TravelDestiny(){
        destiny = new ArrayList<>();
        destiny.add("A");
        destiny.add("B");
        destiny.add("C");
        destiny.add("D");
    }

    /**
     * Add a destiny with a name
     * @param name
     */
    public void addDestiny(String name){
        destiny.add(name);
    }

    /**
     * LIst all destinies
     */
    public void listDestiny(){

        destiny.forEach(name -> {
            System.out.println("Destiny: " + name.toString());
        });

    }
    public int getLengthDestiny(){
        return destiny.size();
    }

    public ArrayList<String> getTravelList(){
        return destiny;
    }


}
