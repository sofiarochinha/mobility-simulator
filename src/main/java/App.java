import register.Register;
import register.User;

import java.util.Scanner;


/**
 * Run the aplication
 */
public class App {

    Scanner keyboard = new Scanner(System.in);


    private void menu(){
        System.out.println("###############");
        System.out.println("Manager: Welcome to the airport. You need help?");
        System.out.println("1 - Yes, I want to register.");
        System.out.println("2 - Yes, I want to travel");
        System.out.println("###############");
        System.out.print("Your answer: ");

        int choose = keyboard.nextInt();
        keyboard.nextLine();

        switch (choose){
            case 1: registerUser();
                    break;

        }
    }


    public void registerUser(){
        System.out.println("###############");
        System.out.print("What's your name?: ");

        String name = keyboard.nextLine();

        Register register = new Register();
        register.createUser(name);


    }

    public static void main(String[] args) {
        App app = new App();
        app.menu();
    }

}
