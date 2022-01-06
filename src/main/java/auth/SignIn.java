package auth;

import java.util.Scanner;

public class SignIn {

    private Scanner keyboard = new Scanner(System.in);
    private Register register;

    public SignIn(Register register){
        this.register = register;
    }
    /**
     * Login with phone number
     */
    public User signIn(){

        System.out.println("###############");
        System.out.print("What's your phone number: ");
        int phoneNumber = keyboard.nextInt();


        while(register.getUser(phoneNumber) == null){
            System.out.println("The phone number doesn't exist.");
            System.out.println("Want write again?");
            System.out.println("1 - yes");
            System.out.println("2 - no");

            int choose = keyboard.nextInt();

            if(choose == 1) {
                System.out.println("Insert a new one: ");
                phoneNumber = keyboard.nextInt();
            } else return null;
        }

        System.out.println("###############");

        return register.getUser(phoneNumber);
    }
}
