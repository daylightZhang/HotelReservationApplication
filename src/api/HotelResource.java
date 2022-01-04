package api;

import model.Customer;
import model.IRoom;
import model.Reservation;
import service.CustomerService;
import service.ReservationService;

import java.util.Collection;
import java.util.Date;

public class HotelResource {
    public static Customer getCustomer(String email) {
        return CustomerService.getCusService().getCustomer(email);
    }

    public static void createACustomer(String email, String firstName, String lastName) {
        CustomerService.getCusService().addCustomer(email,firstName,lastName);
    }

    public static IRoom getRoom(String roomNumber) {
        return ReservationService.getResService().getARoom(roomNumber);
    }

    public static Reservation bookARoom(String customerEmail, IRoom room, Date checkInDate, Date checkOutDate) {
        Customer customer = CustomerService.getCusService().getCustomer(customerEmail);
        if (customer == null)
            throw new NullPointerException();

        return ReservationService.getResService().reserveARoom(customer,room,checkInDate,checkOutDate);
    }

    public static Collection<Reservation> getCustomersReservations(String customerEmail) {
        Customer customer = CustomerService.getCusService().getCustomer(customerEmail);
        return ReservationService.getResService().getCustomerReservation(customer);
    }
    public static Collection<IRoom> findARoom(Date checkIn, Date checkOut) {
        return ReservationService.getResService().findRooms(checkIn,checkOut);
    }
}
