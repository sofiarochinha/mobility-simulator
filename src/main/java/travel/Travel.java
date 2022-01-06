package travel;

import java.util.ArrayList;

public class Travel {

    private int userID;
    private ArrayList<String> travelTour;

    public Travel(int userID, ArrayList<String> travelTour) {
        this.userID = userID;
        this.travelTour = travelTour;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public ArrayList<String> getTravelTour() {
        return travelTour;
    }

    public void setTravelTour(ArrayList<String> travelTour) {
        this.travelTour = travelTour;
    }
}
