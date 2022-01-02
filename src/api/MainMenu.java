package api;

import model.IRoom;
import model.Reservation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Class MainMenu is the access of the Hotel Reservation Application.
 */
public class MainMenu {
    public boolean running;
    public Scanner keyboardReader;

    public MainMenu(){
        this.keyboardReader = new Scanner(System.in);
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
     * @param args, String[] type
     */
    public static void main(String[] args) {
        MainMenu mainMenu = new MainMenu();
        mainMenu.run();
    }

    /**
     * Main loop of main menu
     */
    public void run() {
        int option;
        while (this.isRunning()) {
            this.display();                                        // display the menu
            option = this.getOptionFromKeyboard();   // get valid option
            this.optionProcess(option);                            // process the option
        }
    }

    /**
     * this method displays the main menu of Hotel Reservation Application.
     */
    public void display() {
        System.out.println("==========Main Menu==========");
        System.out.println("1. Find and reserve a room");
        System.out.println("2. See my reservations");
        System.out.println("3. Create an account");
        System.out.println("4. Admin");
        System.out.println("5. Exit");
        System.out.println("=============================");
        System.out.println("Enter your option:");
    }

    /**
     * This method get the valid option from user.
     * It will not return until the user gives the valid input.
     * @return int type, the method will return the valid option from user.
     */
    public int getOptionFromKeyboard() {
        int option;
        while (true){
            try {
                option = this.keyboardReader.nextInt();                    // get the option from user
                if (option < 1 || option > 5) {
                    System.out.println("Your option is invalid, try to input from 1 to 5.");
                } else
                    return option;                                    // return the option for processing
            } catch (InputMismatchException e) {                      // catch exception when input is not int type
                /*
                    clear current 'option' in the memory, otherwise user
                    cannot input for second time.
                 */
                this.keyboardReader.next();                                // clear the buffer in Scanner
                System.out.println("Invalid option, please try again!");
            }
        }
    }

    /**
     * This method process the option input from user
     * @param option, int type, from user's input to command line, could be 1 to 5
     */
    public void optionProcess(int option) {
        switch (option){
            case 1:
                this.findAndReserveARoom(); break;                    // find and reserve a room
            case 2:
                this.seeMyReservations();   break;                    // see the reservations
            case 3:
                this.createAccount();       break;                    // create an account
            case 4:
                this.runAdminMenu();        break;                    // run the admin menu
            case 5:
                this.setRunning(false);     break;                    // exit the main menu
        }
    }

    /**
     * This method encapsulate the process of finding and reserving a room
     */
    public void findAndReserveARoom() {
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
        String checkInDate, checkOutDate;
        Date checkIn = new Date();
        Date checkOut = new Date();
        boolean isInputFinished = false;
        while (!isInputFinished){
            System.out.println("Enter the check in date(yyyy-MM-dd):");
            checkInDate = this.keyboardReader.next();
            System.out.println("Enter the check out date(yyyy-MM-dd):");
            checkOutDate = this.keyboardReader.next();
            try {
                checkIn = sf.parse(checkInDate);
                checkOut = sf.parse(checkOutDate);
                isInputFinished = true;
            } catch (ParseException e) {
                System.out.println("The input is invalid, please do it again!");
            }
        }

        ArrayList<IRoom> roomsAvailable = (ArrayList<IRoom>) HotelResource.findARoom(checkIn,checkOut);
        for (IRoom room : roomsAvailable)
            System.out.println(room);
        System.out.println("Enter the room number that you want:");
        String roomNo = this.keyboardReader.next();
        IRoom roomChoosed = HotelResource.getRoom(roomNo);
        System.out.println("Enter your email(e.g. tom@something.com):");
        String customerEmail = this.keyboardReader.next();
        HotelResource.bookARoom(customerEmail,roomChoosed,checkIn,checkOut);
    }

    /**
     * This method encapsulate the process of viewing all reservations
     */
    public void seeMyReservations() {
        String email;
        System.out.println("Enter the email that you want to search:");
        email = this.keyboardReader.next();
        ArrayList<Reservation> result = (ArrayList<Reservation>) HotelResource.getCustomersReservations(email);
        if (result == null) {
            System.out.println("No reservation for user:" + email + " found!");
            return;
        }
        Iterator it = result.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }

    /**
     * This method encapsulate the process of creating an account
     */
    public void createAccount() {
        System.out.println("Enter your email:");
        String email = this.keyboardReader.next();
        System.out.println("Enter your first name:");
        String firstName = this.keyboardReader.next();
        System.out.println("Enter your last name");
        String lastName = this.keyboardReader.next();
        HotelResource.createACustomer(email,firstName,lastName);
    }

    /**
     * This method encapsulate the access to admin menu
     */
    public void runAdminMenu() {
        AdminMenu adminMenu = new AdminMenu();
        adminMenu.run();
    }
}
