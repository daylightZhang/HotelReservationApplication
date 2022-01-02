package api;

import model.Customer;
import model.IRoom;
import model.Reservation;
import model.RoomType;

import java.util.Collection;
import java.util.Iterator;
import java.util.Scanner;

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
        while (it.hasNext()) {
            System.out.println(it.next());
        }
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
        System.out.println("Enter the room type (single or double):");
        String roomTypeString = this.keyboardReader.next();
        RoomType roomType = roomTypeString == "single" ? RoomType.SINGLE : RoomType.DOUBLE;
        AdminResource.addRoom(roomNo,price,roomType);
    }
}
