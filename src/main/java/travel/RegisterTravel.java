package travel;

import Manager.TravelDestiny;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

/**
 * Register the travel
 */
public class RegisterTravel {

    private ArrayList<Travel> travelDatabase;
    private Scanner keyboard;
    private TravelDestiny travelDestiny;

    public RegisterTravel(){
        travelDatabase = new ArrayList<>();
        keyboard = new Scanner(System.in);
        travelDestiny = new TravelDestiny();
    }

    /**
     * Add a travel to a user with a specific id
     * @param id
     */
    public void registerTravel(int id){

        ArrayList<String> travelPlan = new ArrayList<>();

        while(true) {

            System.out.println("###############");
            System.out.println("Where you want to go?");
            travelDestiny.listDestiny();
            System.out.println("0 - I change my mind. I will travel later.");
            System.out.println("###############");

            //if travel plan is empty ask for the first destiny
            if(travelPlan.isEmpty())
                System.out.print("What's your first destiny?");

            String travel = keyboard.nextLine();

            //if the user want travel later
            if(travel.equals("0")) return;

            boolean added = addDestinyToTravel(travelPlan, travel);

            while(added || !travel.equals("0")){

                if(travelPlan.size() == travelDestiny.getLengthDestiny()) {
                    System.out.println("You already choose all the destinies");
                    return;
                }

                if(added){
                    System.out.println("###############");
                    travelDestiny.listDestiny();
                    System.out.println("0 - It's enough");
                    System.out.print("What's the next? ");
                }
                else System.out.print("Write again: ");

                travel = keyboard.nextLine();
                if(travel.equals("0")) return;
                added = addDestinyToTravel(travelPlan, travel);
            }

            //add a travel plan to a user
            travelDatabase.add(new Travel(id, travelPlan));
        }
    }

    /**
     * Check if the destiny is already added
     * @param travelPlan
     * @param travel
     * @return true if added or false if not added
     */
    public boolean checkIfAdded(ArrayList travelPlan, String travel){

        Iterator iterator = travelPlan.iterator();

        while (iterator.hasNext()){
            String destiny = (String) iterator.next();
            if(destiny.equals(travel)) {
                travelPlan.add(travel);
                System.out.println("The destiny is already added.");
                return true;
            }
        }
        return false;
    }

    /**
     * Add the destiny to the travel plan
     * @param travelPlan
     * @param travel
     * @return true if added or false if not added
     */
    public boolean addDestinyToTravel(ArrayList travelPlan, String travel){

        boolean exist = false;

        if(!checkIfAdded(travelPlan, travel)) {

            Iterator iterator = travelDestiny.getTravelList().iterator();

            while (iterator.hasNext()) {
                String destiny = (String) iterator.next();
                if (destiny.equals(travel)) {
                    travelPlan.add(travel);
                    exist = true;
                }
            }

            if(!exist)  System.out.println("The destiny wrote doesn't exist.");
        }
        return exist;
    }
}
