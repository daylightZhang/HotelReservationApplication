package model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.regex.Pattern;

public class Tester {
    public static void main(String[] args) throws ParseException{
        Customer customer1 = new Customer("Jingkai","Zhang","jz544@cornell.com");
//        System.out.println(customer1);
//
//        // regular expression for email
        Customer customer2 = new Customer("first","second","jz544@cornell.com");
//        System.out.println(customer2);
//        String emailRegex = "^(.+)@(.+)\\.(.+)$";
//        Pattern pattern = Pattern.compile(emailRegex);
//        String email = "jeff@gmailcom";
//
//        System.out.println(pattern.matcher(email).matches());
//
//        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
//        String d = "2021-10-31";
//        System.out.println(d);
//        try {
//            Date d_ = sf.parse(d);
//            System.out.println(d_);
//        } catch (ParseException e) {
//
//        }
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
        Date d1 = sf.parse("2020-10-10");
        Date d2 = sf.parse("2020-10-10");
        Date d3 = sf.parse("2020-11-20");
//        d1.setTime(d1.getTime() + 7*24*60*60*1000);
        System.out.println(d1.equals(d2));
//        ArrayList<Date> dates = new ArrayList<>();
//        dates.add(d1);
//        dates.add(d2);
////        dates.add(d3);
//        System.out.println(dates);
//        boolean contain = dates.contains(d3);
//        System.out.println(contain);
//        dates.remove(d3);
//        System.out.println(dates);
//        int result = d1.compareTo(d2);
//        System.out.println(result);
//
//        Room r1 = new Room("123",200.0,RoomType.DOUBLE,d1,d3);
//        Room r2 = new Room("1201",290.0,RoomType.DOUBLE,d1,d3);
//        System.out.println(r1.isAvailable());
//        ArrayList<IRoom> db = new ArrayList<>();
//        db.add(r1);
//        db.add(r2);
//        Room r;
//        System.out.println(db.get(0));
//        Iterator<IRoom> it = db.iterator();
//        while (it.hasNext()) {
//            r = (Room)it.next();
//            System.out.println(r);
//        }

    }
}
