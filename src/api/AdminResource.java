package api;

import model.*;
import service.CustomerService;
import service.ReservationService;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;

public class AdminResource {
    public static Customer getCustomer(String email) {
        return CustomerService.getCusService().getCustomer(email);
    }

    public static void addRoom(ArrayList<IRoom> rooms) {
        Iterator<IRoom> it = rooms.iterator();
        while (it.hasNext()) {
            ReservationService.getResService().addRoom(it.next());
        }
    }

    public static boolean addRoom(String roomNumber, Double price, RoomType enumeration, Date availBegin, Date availEnd) {
        IRoom r = new Room(roomNumber, price, enumeration, availBegin, availEnd);
        return ReservationService.getResService().addRoom(r);
    }

    public static Collection<IRoom> getAllRooms() {
        return ReservationService.getResService().getRoomDatabase();
    }

    public static Collection<Customer> getAllCustomer() {
        return CustomerService.getCusService().getCustomersDatabase();
    }

    public static void displayAllReservations() {
        ReservationService.getResService().printAllReservation();
    }
}
