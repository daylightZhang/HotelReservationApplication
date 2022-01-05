package model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Reservation {
    private Customer customer;
    private IRoom room;
    private Date checkInDate;
    private Date checkOutDate;

    public Reservation(Customer customer, IRoom room, Date checkInDate, Date checkOutDate) {
        this.customer = customer;
        this.room = room;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
    }

    public Reservation() {}

    final public Customer getCustomer() {
        return customer;
    }

    final public IRoom getRoom() {
        return room;
    }

    final public Date getCheckInDate() {
        return checkInDate;
    }

    final public Date getCheckOutDate() {
        return checkOutDate;
    }

    final public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    final public void setRoom(IRoom room) {
        this.room = room;
    }

    final public void setCheckInDate(Date checkInDate) {
        this.checkInDate = checkInDate;
    }

    final public void setCheckOutDate(Date checkOutDate) {
        this.checkOutDate = checkOutDate;
    }

    @Override
    public String toString() {
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
        return "Reservation Information:" + "\n" +
                "customer " + customer.toString() + "\n" +
                "room=" + room + "\n" +
                "checkInDate=" + sf.format(checkInDate) + "\n" +
                "checkOutDate=" + sf.format(checkOutDate) + "\n";
    }
}
