package service;

import model.Customer;
import model.IRoom;
import model.Reservation;

import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class ReservationService {

    private Map reservationDatebase;

    public ReservationService() {
        this.reservationDatebase = new HashMap();
    }

    public static void addRoom(IRoom room) {

    }

    public static IRoom getARoom(String roomID) {

    }

    public static Reservation reserveARoom(Customer customer, IRoom room, Date checkInDate, Date checkOutDate) {

    }

    public static Collection<IRoom> findRooms(Date checkInDate, Date checkOutDate) {

    }
    public static Collection<Reservation> getCustomerReservation(Customer customer) {

    }

    public static void printAllReservation() {
        return;
    }
}
