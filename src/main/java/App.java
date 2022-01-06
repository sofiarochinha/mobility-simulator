
import Manager.Counter;
import auth.Register;
import auth.SignIn;
import auth.User;
import travel.RegisterTravel;
import java.util.Scanner;

/**
 * Run the aplication
 */
public class App {

    private Scanner keyboard;
    private Register register;
    private SignIn signIn;
    private RegisterTravel travel;
    private Counter counter;

    public App(){
        keyboard = new Scanner(System.in);
        register = new Register();
        signIn = new SignIn(register);
        travel = new RegisterTravel();
    }

    /**
     * Show the menu
     */
    private void menu(){
        System.out.println("###############");
        System.out.print("Number of cycles will run the program: ");

        counter = new Counter(keyboard.nextInt());
        keyboard.nextLine();
        boolean isRunning = true;

        while(isRunning) {

            System.out.println("###############");
            System.out.println("Manager: Welcome to the airport. You need help?");
            System.out.println("1 - Yes, I want to register.");
            System.out.println("2 - Yes, I want to travel");
            System.out.println("###############");
            System.out.print("Your answer: ");

            int choose = keyboard.nextInt();
            keyboard.nextLine();

            switch (choose) {
                case 1:
                    travel.registerTravel(register.registerUser());
                    counter.addWaitingVisitors();
                    break;
                case 2:
                    User user = signIn.signIn();
                    if(user != null){
                        travel.registerTravel(user.getId());
                        counter.addWaitingVisitors();
                    }
                    break;

            }

            counter.run();
            //end the program
           if(!counter.isInterrupted()) isRunning = false;
        }

    }

    /**
     * Run the program
     * @param args
     */
    public static void main(String[] args) {
        App app = new App();
        app.menu();



    }

}
