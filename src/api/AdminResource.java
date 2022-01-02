package api;

import model.*;
import service.CustomerService;
import service.ReservationService;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class AdminResource {
    public static Customer getCustomer(String email) {
        return CustomerService.getCustomer(email);
    }

    public static void addRoom(ArrayList<IRoom> rooms) {
        Iterator<IRoom> it = rooms.iterator();
        while (it.hasNext()) {
            ReservationService.addRoom(it.next());
        }
    }

    public static void addRoom(String roomNumber, Double price, RoomType enumeration) {
        IRoom r = new Room(roomNumber, price, enumeration);
        ReservationService.addRoom(r);
    }

    public static Collection<IRoom> getAllRooms() {
        return ReservationService.getRoomDatabase();
    }

    public static Collection<Customer> getAllCustomer() {
        return CustomerService.getCustomersDatabase();
    }

    public static void displayAllReservations() {
        ReservationService.printAllReservation();
    }
}
