package api;

import model.Customer;
import model.IRoom;
import model.Reservation;

import java.util.Collection;

public class AdminMenu extends MainMenu {

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

    }

    public static void seeAllRooms() {
        Collection<IRoom> allRooms = AdminResource.getAllRooms();
    }

    public static void seeAllReservations() {
        AdminResource.displayAllReservations();
    }

    public static void addARoom() {
        AdminResource.addRoom();
    }
}
