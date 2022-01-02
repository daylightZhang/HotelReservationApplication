package service;

import model.Customer;
import model.IRoom;
import model.Reservation;
import model.Room;

import java.util.*;

public class ReservationService {
    private static Collection<IRoom> roomDatabase = new ArrayList<>();
    private static Collection<Reservation> reservationDatebase = new ArrayList<>();

    public ReservationService() {}

    public static Collection<IRoom> getRoomDatabase() {
        return roomDatabase;
    }

    public static Collection<Reservation> getReservationDatebase() {
        return reservationDatebase;
    }

    public static void addRoom(IRoom room) {
        roomDatabase.add(room);
    }

    public static IRoom getARoom(String roomID) {
        IRoom temp;
        Iterator<IRoom> it = roomDatabase.iterator();
        while (it.hasNext()) {
            temp = it.next();
            if (temp.getRoomNumber() == roomID)
                return temp;
        }
        return null;   // return null if the roomID is not found in the database
    }

    public static Reservation reserveARoom(Customer customer, IRoom room, Date checkInDate, Date checkOutDate) {
        Reservation r = new Reservation(customer,room,checkInDate,checkOutDate);
        reservationDatebase.add(r);
        return r;
    }

    public static Collection<IRoom> findRooms(Date checkInDate, Date checkOutDate) {
//        Collection<IRoom> rooms = new ArrayList<>();  // store the filtering result
//        Iterator<IRoom> it = roomDatabase.iterator();
//        IRoom r;
//        while (it.hasNext()) {
//            r = it.next();
//        }
        return roomDatabase;
    }

    /**
     * This methods will return all the reservations of the customer
     * @param customer, Customer type
     * @return null if no reservations found, otherwise return Collection<Reservation> type
     */
    public static Collection<Reservation> getCustomerReservation(Customer customer) {
        Collection<Reservation> customerReservations = new ArrayList<>();
        Iterator<Reservation> it = reservationDatebase.iterator();
        Reservation temp;
        while (it.hasNext()) {
            temp = it.next();
            if(temp.getCustomer().equals(customer)) {
                customerReservations.add(temp);
            }
        }
        if (customerReservations.isEmpty()) {  // return null if no reservations found
            return null;
        } else
        return customerReservations;
    }

    /**
     * This methods will print all the reservation information
     */
    public static void printAllReservation() {
        if (reservationDatebase.isEmpty()) {
            System.out.println("No Reservation found!");
            return;
        }
        Iterator<Reservation> it = reservationDatebase.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }
}
