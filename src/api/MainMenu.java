package api;

import model.IRoom;
import model.Reservation;
import model.Room;

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
//    public static void main(String[] args) {
//        MainMenu mainMenu = new MainMenu();
//        mainMenu.run();
//    }

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
        System.out.println("==========Main Menu===========");
        System.out.println("1. Find and reserve a room");
        System.out.println("2. See my reservations");
        System.out.println("3. Create an account");
        System.out.println("4. Admin");
        System.out.println("5. Exit");
        System.out.println("==============================");
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
        boolean recommendFlag = false;
        Date checkIn = new Date();
        Date checkOut = new Date();
        Date checkInRec = new Date();
        Date checkOutRec = new Date();
        boolean isInputFinished = false;
        ArrayList<String> availRooms = new ArrayList<>();
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
        if (roomsAvailable == null) { // get the recommended rooms
            checkInRec.setTime(checkIn.getTime() + 7*24*60*60*1000);     // plus  7 days
            checkOutRec.setTime(checkOut.getTime() + 7*24*60*60*1000);   // plus  7 days
            roomsAvailable = (ArrayList<IRoom>) HotelResource.findARoom(checkInRec,checkOutRec);
            if (roomsAvailable == null) {// still cannot find
                System.out.println("Sorry, there is no room available for your requirement.");
                return;
            }
            recommendFlag = true;
            System.out.println("Sorry, no room available for your requiremen.");
            System.out.println("Recommended check-in date:" + sf.format(checkInRec));
            System.out.println("Recommended check-out date:" + sf.format(checkOutRec));
            System.out.println("Would you consider the recommended date with the following room?");
        }
        System.out.println("========Room Available========");
        for (IRoom room : roomsAvailable) {
            Room roomAvail = (Room) room;
            availRooms.add(room.getRoomNumber());
            System.out.println(roomAvail);
        }

        System.out.println("==============================");
        isInputFinished = false;
        String roomNo = "";
        while (!isInputFinished) {
            System.out.println("Enter the room number that you want(enter \"no\" to skip):");
            roomNo = this.keyboardReader.next();
            if (roomNo.equals("no"))
                return;
            if (availRooms.contains(roomNo) == false) {
                System.out.println("The room you choose is not available!");
                continue;
            }
            isInputFinished = true;
        }
        IRoom roomChoosed = HotelResource.getRoom(roomNo);
        System.out.println("Enter your email(e.g. tom@something.com):");
        String customerEmail = this.keyboardReader.next();
        try {
            if (recommendFlag)
                HotelResource.bookARoom(customerEmail,roomChoosed,checkInRec,checkOutRec);
            else
                HotelResource.bookARoom(customerEmail,roomChoosed,checkIn,checkOut);
        } catch (NullPointerException e) {
            System.out.println("Email not found. Fail to reserve, please check again!");
            return;
        }

        System.out.println("Thank you for your reservation.");
        System.out.println("You have reserved Room No." + roomNo);
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
        boolean createFinished = false;
        while (!createFinished) {
            System.out.println("Enter your email:");
            String email = this.keyboardReader.next();
            System.out.println("Enter your first name:");
            String firstName = this.keyboardReader.next();
            System.out.println("Enter your last name");
            String lastName = this.keyboardReader.next();
            try {
                HotelResource.createACustomer(email,firstName,lastName);
                createFinished = true;
                System.out.println("Your account has been created.");
            } catch(IllegalArgumentException e) {
                System.out.println("Please try it again!");
            }
        }
    }

    /**
     * This method encapsulate the access to admin menu
     */
    public void runAdminMenu() {
        AdminMenu adminMenu = new AdminMenu();
        adminMenu.run();
    }
}
