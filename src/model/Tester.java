package model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
        Date d1 = sf.parse("2020-10-25");
        Date d2 = sf.parse("2020-10-25");
        int result = d1.compareTo(d2);
        System.out.println(result);
    }
}
