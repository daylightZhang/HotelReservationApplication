package model;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

public class Room implements IRoom{
    private String roomNumber;
    private Double price;
    private RoomType enumeration;
    private ArrayList<Date> beginTime;
    private ArrayList<Date> endTime;

    /**
     * Constructor for room
     * @param roomNumber String type, the room ID
     * @param price Double type, the price of the room
     * @param enumeration RoomType type, single or double room
     * @param beginAvail Date type, begin available time
     * @param endAvail Date type, end available time
     */
    public Room(String roomNumber, Double price, RoomType enumeration, Date beginAvail, Date endAvail) {
        this.roomNumber = roomNumber;
        this.price = price;
        this.enumeration = enumeration;
        this.beginTime = new ArrayList<>();
        this.endTime = new ArrayList<>();
        this.beginTime.add(beginAvail);
        this.endTime.add(endAvail);
    }

    public Room(){}

    /**
     * This method checks if the room has available dates
     * @return true if there are available date slot(s), false if there is no available date.
     */
    public boolean isAvailable() {
        return !this.beginTime.isEmpty();
    }

    public boolean isBookable(Date checkIn, Date checkOut) {
        Date availBegin, availEnd;
        for (int i = 0; i < this.beginTime.size(); i++){
            availBegin = this.beginTime.get(i);
            availEnd = this.endTime.get(i);
            if (availBegin.before(checkIn) && availEnd.after(checkOut))
                return true;
        }
        return false;
    }
    public Collection<Date> getBeginTime() {
        return this.beginTime;
    }

    public Collection<Date> getEndTime() {
        return this.endTime;
    }

    public void setBeginTime(Collection<Date> newBeginTime) {
        this.beginTime = (ArrayList<Date>) newBeginTime;
    }

    public void setEndTime(Collection<Date> newEndTime) {
        this.endTime = (ArrayList<Date>) newEndTime;
    }

    private String printAvailableTime() {
        String displayContent = "";
        String displayDate;
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
        if (this.isAvailable()) {
            displayContent = displayContent + "Available time slot:\n";
            for (int i = 0; i < this.beginTime.size(); i++) {
                displayDate = sf.format(beginTime.get(i)) + " to " + sf.format(endTime.get(i)) + "\n";
                displayContent = displayContent + displayDate;
            }
            return displayContent;
        } else
            return "All time slots had been booked. Sorry.";
    }

    /**
     * This method adds the begin available time in the array list.
     * For example, room 101 is available from 2020-10-12 to 2020-10-15;
     * begin time should be 2020-10-12, end time should be 2020-10-15.
     * @param newBeginTime Date type, begin available time of a room
     */
    private void addBeginTime(Date newBeginTime) {
        this.beginTime.add(newBeginTime);
    }

    /**
     * This method adds the end available time in the array list.
     * For example, room 101 is available from 2020-10-12 to 2020-10-15;
     * begin time should be 2020-10-12, end time should be 2020-10-15.
     * @param newEndTime Date type, end available time of a room
     */
    private void addEndTime(Date newEndTime) {
        this.endTime.add(newEndTime);
    }

    /**
     * This method remove the begin date from array list.
     * @param d Date type
     */
    private void removeBeginTime(Date d) {
        if (this.beginTime.contains(d)) {
            this.beginTime.remove(d);
        } else
            System.out.println("Remove failure: the date is not contained in beginTime.");
    }

    /**
     * This method remove the end date from array list.
     * @param d Date type
     */
    private void removeEndTime(Date d) {
        if (this.endTime.contains(d)) {
            this.endTime.remove(d);
        } else
            System.out.println("Remove failure: the date is not contained in endTime.");
    }

    @Override
    public String getRoomNumber() {
        return roomNumber;
    }

    @Override
    public Double getRoomPrice() {
        return price;
    }

    @Override
    public RoomType getRoomType() {
        return enumeration;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setEnumeration(RoomType enumeration) {
        this.enumeration = enumeration;
    }

    @Override
    public boolean isFree() {
        return false;
    }

    @Override
    public String toString() {
        return "Room No." + roomNumber + "\n" +
                "Price per night:" + price + "$\n" +
                "Room type:" + enumeration + "\n" +
                printAvailableTime();
    }
}
