package service;

import model.Customer;

import java.util.*;

public class CustomerService {

    private static Collection<Customer> customersDatabase = new ArrayList<>();  // container

    public static Collection<Customer> getCustomersDatabase() {
        return customersDatabase;
    }

    /**
     * This methods add the new customer and store it in the ArrayList
     * @param email String type, the email address of the customer
     * @param firstName String type, first name of the customer
     * @param lastName String type, last name of the customer
     */
    public static void addCustomer(String email, String firstName, String lastName) {
        Customer c = new Customer(firstName,lastName,email);
        customersDatabase.add(c);
    }

    /**
     * This methods get the customer according to his/her email
     * @param customerEmail String type, email of the customer
     * @return Customer type
     */
    public static Customer getCustomer(String customerEmail) {
        Customer curCustomer;        // state a temp variable
        Iterator<Customer> it = customersDatabase.iterator();
        while (it.hasNext()) {
            /*
                Attention: when it.next() is execuated, the 'pointer' will update.
                So do not execuate it.next() twice or more in a traverse function.
             */
            curCustomer = it.next();
            if (customerEmail == curCustomer.getEmail())
                return curCustomer;
        }
        return null;   // means the customer does not exist
    }

    /**
     * This methods get all data about customer
     * @return Collection<Customer> type
     */
    public static Collection<Customer> getAllCustomer() {
        return customersDatabase;
    }
}
