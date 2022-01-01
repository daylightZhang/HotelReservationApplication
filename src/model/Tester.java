package model;

public class Tester {
    public static void main(String[] args) {
        Customer customer1 = new Customer("Jingkai","Zhang","jz544@cornell.com");
        System.out.println(customer1);

        // regular expression for email
        Customer customer2 = new Customer("first","second","email");
    }
}
