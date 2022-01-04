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

    public Customer getCustomer() {
        return customer;
    }

    public IRoom getRoom() {
        return room;
    }

    public Date getCheckInDate() {
        return checkInDate;
    }

    public Date getCheckOutDate() {
        return checkOutDate;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void setRoom(IRoom room) {
        this.room = room;
    }

    public void setCheckInDate(Date checkInDate) {
        this.checkInDate = checkInDate;
    }

    public void setCheckOutDate(Date checkOutDate) {
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
