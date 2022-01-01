package api;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Class MainMenu is the access of the Hotel Reservation Application.
 */
public class MainMenu {
    private boolean running;

    public MainMenu(){
        this.running = true;
    }

    public boolean isRunning() {
        return running;
    }

    public void setRunning(boolean running) {
        this.running = running;
    }

    /**
     * Main of Hotel Reservation Application
     * @param args
     */
    public static void main(String[] args) {

        Scanner keyboardReader = new Scanner(System.in);
        MainMenu mainMenu = new MainMenu();
        int option;

        while (mainMenu.isRunning()) {
            mainMenu.display();                                        // display the menu
            option = mainMenu.getOptionFromKeyboard(keyboardReader);   // get valid option
            mainMenu.optionProcess(option);                            // process the option
        }
    }

    /**
     * this method displays the main menu of Hotel Reservation Application.
     */
    public void display() {
        System.out.println("1. Find and reserve a room");
        System.out.println("2. See my reservations");
        System.out.println("3. Create an account");
        System.out.println("4. Admin");
        System.out.println("5. Exit");
        System.out.println("Enter your option:");
    }

    /**
     * This methods get the valid option from user.
     * It will not return until the user gives the valid input.
     * @param keyboardReader Scanner that can read input from keyboard.
     * @return the method will return the valid option from user.
     */
    public int getOptionFromKeyboard(Scanner keyboardReader) {
        int option;
        while (true){
            try {
                option = keyboardReader.nextInt();                    // get the option from user
                if (option < 1 || option > 5) {
                    System.out.println("Your option is invalid, try to input from 1 to 5.");
                } else
                    return option;                                    // return the option for processing
            } catch (InputMismatchException e) {                      // catch exception when input is not int type
                /*
                    clear current 'option' in the memory, otherwise user
                    cannot input for second time.
                 */
                keyboardReader.next();                                // clear the buffer in Scanner
                System.out.println("Invalid option, please try again!");
            }
        }
    }

    public void optionProcess(int option) {
        switch (option){
            case 1:

                break;
            case 2:

                break;
            case 3:

                break;

            case 4:
                break;

            case 5:
                this.setRunning(false);
                break;

                default: // this branch will not be used.

                    break;
        }
    }
}
