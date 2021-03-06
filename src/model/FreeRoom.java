package model;

import java.util.Date;

public class FreeRoom extends Room{
    public FreeRoom(String roomNumber, Double price, RoomType enumeration, Date checkIn, Date checkOut) {
        super(roomNumber, 0.0, enumeration, checkIn, checkOut);
    }

    @Override
    public boolean isFree() {return true;}
    @Override
    public String toString() {
        return "FreeRoom{}" + super.toString();
    }
}
