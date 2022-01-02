package model;

import java.util.regex.Pattern;

public class Tester {
    public static void main(String[] args) {
        Customer customer1 = new Customer("Jingkai","Zhang","jz544@cornell.com");
        System.out.println(customer1);

        // regular expression for email
        Customer customer2 = new Customer("first","second","email@something");

        String emailRegex = "^(.+)@(.+).(.+)$";
        Pattern pattern = Pattern.compile(emailRegex);
        String email = "jeff@gmailcom";

        System.out.println(pattern.matcher(email).matches());
    }
}
