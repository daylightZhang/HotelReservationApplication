package api;

import model.Customer;
import model.IRoom;
import model.Reservation;
import model.RoomType;

import java.util.Collection;
import java.util.Iterator;
import java.util.Scanner;

public class AdminMenu extends MainMenu {
    private static Scanner keyboardReader = new Scanner(System.in);
    public AdminMenu(){
        super();
    }
    /**
     * this method displays the admin menu, extends to the MainMenu
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

    public void optionProcess(int option) {
        switch (option){
            case 1: seeAllCustomers();        break;
            case 2: seeAllRooms();            break;
            case 3: seeAllReservations();     break;
            case 4: addARoom();               break;
            case 5: this.setRunning(false);   break;             // exit the admin menu
        }
    }

    public static void seeAllCustomers() {
        Collection<Customer> allCustomers = AdminResource.getAllCustomer();
        Iterator<Customer> it = allCustomers.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }

    public static void seeAllRooms() {
        Collection<IRoom> allRooms = AdminResource.getAllRooms();
        Iterator<IRoom> it = allRooms.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }

    public static void seeAllReservations() {
        AdminResource.displayAllReservations();
    }

    public static void addARoom() {
        System.out.println("Enter room number:");
        String roomNo = keyboardReader.next();
        System.out.println("Enter the price:");
        double price = keyboardReader.nextDouble();
        System.out.println("Enter the room type (single or double):");
        String roomTypeString = keyboardReader.next();
        RoomType roomType = roomTypeString == "single" ? RoomType.SINGLE : RoomType.DOUBLE;
        AdminResource.addRoom(roomNo,price,roomType);
    }
}
