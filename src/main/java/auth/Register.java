package auth;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

/**
 * If it's the first time of user do a tour, he needs register in the system
 */

public class Register {

    private ArrayList<User> dataBase;
    private Scanner keyboard;

    public Register(){
        dataBase = new ArrayList<>();
        keyboard = new Scanner(System.in);
    }

    /**
     * Create a new user in application
     * @param name
     * @return id of the user
     */
    public Integer createUser(String name, int phoneNumber){

        if(dataBase.size() == 300){
            System.out.println("Can't add more visitors.");
            return null;
        }

        Iterator<User> iterator = dataBase.iterator();

        //random value between 0 and 100 for each user
        int id = (int) (Math.random()*100);

        //checks to see if there is an equal number
        while(iterator.hasNext()){
            User user = iterator.next();
            if(user.getId() == id) id = (int) (Math.random()*100);
            if(user.getPhoneNumber() == phoneNumber){
                System.out.println("There is already a user with this phone number.");
                System.out.println("Want insert a new one?");
                System.out.println("1 - Yes");
                System.out.println("2 - No");
                System.out.print("Your answer: ");

                Scanner keyboard = new Scanner(System.in);
                int choose = keyboard.nextInt();

                if(choose == 1){
                    System.out.print("New phone number: ");
                    phoneNumber = keyboard.nextInt();
                }else return null;
            }
        }

        //create a new user and add a "database"
        User user = new User(name, id, phoneNumber);

        dataBase.add(user);
        System.out.println("It's been successfully registered.");
        
        return user.getId();
    }

    /**
     * Get the data of a User
     * @param phoneNumber
     * @return User with that phone number
     */
    public User getUser(int phoneNumber){

        Iterator<User> iterator = dataBase.iterator();

        while (iterator.hasNext()){
            User user = iterator.next();
            System.out.println("");
            System.out.println("phonenumberiter: " + phoneNumber);
            System.out.println("user: " + user.getPhoneNumber());
            if(user.getPhoneNumber() == phoneNumber){
                return user;
            }
        }

        return null;

    }

    /**
     * Register de user in plataform with a name and a random id
     */
    public Integer registerUser(){
        System.out.println("###############");
        System.out.print("What's your name?: ");

        String name = keyboard.nextLine();

        System.out.println("###############");
        System.out.print("What's your phone number?: ");
        String phoneNumber = keyboard.nextLine();

        while(!phoneNumber.matches("(9[1236]\\d) ?(\\d{3}) ?(\\d{3})")){
            System.out.print("The phone number is invalid. Please, write again: ");
            phoneNumber = keyboard.nextLine();
        }


        //create a new user
        Integer id = createUser(name, Integer.parseInt(phoneNumber));
        if(id == null) return null;

        return id;

    }




}
