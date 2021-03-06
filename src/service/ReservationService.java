package service;

import model.Customer;
import model.IRoom;
import model.Reservation;
import model.Room;

import java.util.*;

public class ReservationService {
    private static Collection<IRoom> roomDatabase = new ArrayList<>();
    private static Collection<Reservation> reservationDatabase = new ArrayList<>();

    public ReservationService() {}

    /**
     * This method returns all the room data.
     * @return roomDatabase
     */
    public static Collection<IRoom> getRoomDatabase() {
        return roomDatabase;
    }

    /**
     * This method returns all the reservation data.
     * @return reservationDatabase
     */
    public static Collection<Reservation> getReservationDatabase() {
        return reservationDatabase;
    }

    /**
     * This method adds a new room, and store it in the array list.
     * @param room IRoom type
     */
    public static void addRoom(IRoom room) {
        roomDatabase.add(room);
    }

    /**
     * This method query a room according to room number
     * @param roomID String type
     * @return null if not found, IRoom if found
     */
    public static IRoom getARoom(String roomID) {
        IRoom temp;
        Iterator<IRoom> it = roomDatabase.iterator();
        while (it.hasNext()) {
            temp = it.next();
            if (temp.getRoomNumber().equals(roomID))
                return temp;
        }
        return null;   // return null if the roomID is not found in the database
    }

    /**
     * This method encapsulates the reservation function.
     * First, the method will find the time interval that the reservation belong.
     * For example, the reservation interval (21.10.15-21.10.18) belongs to
     * (21.10.10-21.10.30), the available time interval will change to
     * (21.10.10-21.10.14) and (21.10.19-21.10.30)
     * @param customer
     * @param room
     * @param checkInDate
     * @param checkOutDate
     * @return reservation information
     */
    public static Reservation reserveARoom(Customer customer, IRoom room, Date checkInDate, Date checkOutDate) {
        Date checkInDateCopy = new Date();
        Date checkOutDateCopy = new Date();
        Room bookedRoom = (Room)room;
        ArrayList<Date> beginTime = (ArrayList<Date>) bookedRoom.getBeginTime();
        ArrayList<Date> endTime = (ArrayList<Date>) bookedRoom.getEndTime();
        for (int i = 0; i < beginTime.size(); i++) {
            if (checkInDate.after(beginTime.get(i)) && checkOutDate.before(endTime.get(i))) {
                beginTime.add(beginTime.get(i));
                checkInDateCopy.setTime(checkInDate.getTime() - 24 * 60 * 60 * 1000);
                endTime.add(checkInDateCopy);
                checkOutDateCopy.setTime(checkOutDate.getTime() + 24 * 60 * 60 * 1000);
                beginTime.add(checkOutDateCopy);
                endTime.add(endTime.get(i));
                beginTime.remove(i);
                endTime.remove(i);
                bookedRoom.setBeginTime(beginTime); // update the database
                bookedRoom.setEndTime(endTime);     // update the database
            }
        }
        Reservation r = new Reservation(customer,room,checkInDate,checkOutDate);
        reservationDatabase.add(r);
        return r;
    }

    /**
     * This method finds the room according to the check in / check out date.
     * It will compare the check in / check date with the available slots,
     * if the check in / out date is the subset of available slot, this room
     * will be selected. For example, check in / out date are 2020-10-11 and
     * 2020-10-13, the available slot is 2020-10-9 to 2020-11.30, so this room
     * is available.
     * @param checkInDate
     * @param checkOutDate
     * @return result of finding
     */
    public static Collection<IRoom> findRooms(Date checkInDate, Date checkOutDate) {
        Collection<IRoom> rooms = new ArrayList<>();  // store the filtering result
        Iterator<IRoom> it = roomDatabase.iterator();
        Room r;
        while (it.hasNext()) {
            r = (Room)it.next();
            if (!r.isBookable(checkInDate,checkOutDate))
                continue;
            else
                rooms.add(r);
        }
        if (!rooms.isEmpty())
            return rooms;
        else
            return null;
    }

    /**
     * This method will return all the reservations of the customer
     * @param customer, Customer type
     * @return null if no reservations found, otherwise return Collection<Reservation> type
     */
    public static Collection<Reservation> getCustomerReservation(Customer customer) {
        Collection<Reservation> customerReservations = new ArrayList<>();
        Iterator<Reservation> it = reservationDatabase.iterator();
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
     * This method will print all the reservation information
     */
    public static void printAllReservation() {
        if (reservationDatabase.isEmpty()) {
            System.out.println("No Reservation found!");
            return;
        }
        Iterator<Reservation> it = reservationDatabase.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }
}
