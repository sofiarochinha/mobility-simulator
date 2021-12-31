package register;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * If it's the first time of user do a tour, he needs register in the system
 */

public class Register {

    private ArrayList<User> dataBase = new ArrayList<>();

    /**
     * Create a new user in application
     * @param name
     */
    public void createUser(String name){

        if(dataBase.size() == 300){
            System.out.println("Can't add more visitors.");
            return;
        }

        //radom value for each user
        int id = (int) Math.random();

        //checks to see if there is an equal number
        Iterator iterator = dataBase.iterator();

        while(iterator.hasNext()){
            User user = (User) iterator.next();
            if(user.getId() == id) id = (int) Math.random();
        }

        //create a new user and add a "database"
        User user = new User(name, id);
        dataBase.add(user);
        System.out.println("It's been successfully registered.");

    }



}
