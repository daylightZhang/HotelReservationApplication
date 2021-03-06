package api;

import model.Customer;
import model.IRoom;
import model.RoomType;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;

public class AdminMenu extends MainMenu {
    public AdminMenu(){
        super();
    }
    /**
     * This method displays the admin menu, extends to the MainMenu
     */
    public void display() {
        System.out.println("==========Admin Menu==========");
        System.out.println("1. See all Customers");
        System.out.println("2. See all Rooms");
        System.out.println("3. See all reservations");
        System.out.println("4. Add a Room");
        System.out.println("5. Back to Main Menu");
        System.out.println("==============================");
        System.out.println("Enter your option:");
    }

    /**
     * This method process the option from user input
     * @param option, int type, from user's input to command line, could be 1 to 5
     */
    public void optionProcess(int option) {
        switch (option){
            case 1: seeAllCustomers();        break;
            case 2: seeAllRooms();            break;
            case 3: seeAllReservations();     break;
            case 4: addARoom();               break;
            case 5: this.setRunning(false);   break;             // exit the admin menu
        }
    }

    /**
     * This method can check all the registered customer
     */
    public void seeAllCustomers() {
        Collection<Customer> allCustomers = AdminResource.getAllCustomer();
        Iterator<Customer> it = allCustomers.iterator();
        int customerCounter = 1;
        System.out.println("=========Customer Info========");
        while (it.hasNext()) {
            System.out.println("Customer No." + customerCounter);
            customerCounter++;
            System.out.println(it.next());
        }
        System.out.println("==============================");
    }

    /**
     * This method can see all the rooms of the hotel
     */
    public void seeAllRooms() {
        Collection<IRoom> allRooms = AdminResource.getAllRooms();
        Iterator<IRoom> it = allRooms.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }

    /**
     * This method can show all the reservations
     */
    public void seeAllReservations() {
        AdminResource.displayAllReservations();
    }

    /**
     * This method allows user to add a room
     */
    public void addARoom() {
        System.out.println("Enter room number:");
        String roomNo = this.keyboardReader.next();
        System.out.println("Enter the price:");
        double price = this.keyboardReader.nextDouble();
        System.out.println("Enter the room type (1 for single, 2 for double):");
        int roomTypeInt = this.keyboardReader.nextInt();
        RoomType roomType = roomTypeInt == 1 ? RoomType.SINGLE : RoomType.DOUBLE;
        System.out.println("Enter the available begin time(yyyy-MM-dd):");
        String availBegin = this.keyboardReader.next();
        System.out.println("Enter the available end time(yyyy-MM-dd):");
        String availEnd = this.keyboardReader.next();
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date begin = sf.parse(availBegin);
            Date end = sf.parse(availEnd);
            AdminResource.addRoom(roomNo,price,roomType,begin,end);
            System.out.println("The added room's information:");
            System.out.println("Room No." + roomNo);
            System.out.println("Price per night:" + price + "$");
            System.out.println("Room type:" + roomType);
        } catch (ParseException e) {
            System.out.println("The data you input is invalid! Try again!");
            return;
        }
    }
}
