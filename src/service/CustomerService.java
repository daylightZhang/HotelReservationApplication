package service;

import model.Customer;

import java.util.*;

public class CustomerService {

    final private static Collection<Customer> customersDatabase = new ArrayList<>();  // container
    private static CustomerService singleInstance = null;

    public static CustomerService getCusService() {
        if (singleInstance == null)
            singleInstance = new CustomerService();
        return singleInstance;
    }

    public Collection<Customer> getCustomersDatabase() {
        return customersDatabase;
    }

    /**
     * This method add the new customer and store it in the ArrayList
     * @param email String type, the email address of the customer
     * @param firstName String type, first name of the customer
     * @param lastName String type, last name of the customer
     */
    public void addCustomer(String email, String firstName, String lastName) {
        Customer c = new Customer(firstName,lastName,email);
        customersDatabase.add(c);
    }

    /**
     * This method get the customer according to his/her email
     * @param customerEmail String type, email of the customer
     * @return Customer type
     */
    public Customer getCustomer(String customerEmail) {
        Customer curCustomer;        // state a temp variable
        Iterator<Customer> it = customersDatabase.iterator();
        while (it.hasNext()) {
            /*
                Attention: when it.next() is execuated, the 'pointer' will update.
                So do not execuate it.next() twice or more in a traverse function.
             */
            curCustomer = it.next();
            if (curCustomer.getEmail().equals(customerEmail))
                return curCustomer;
        }
        return null;   // means the customer does not exist
    }

    /**
     * This method get all data about customer
     * @return Collection<Customer> type
     */
    public Collection<Customer> getAllCustomer() {
        return customersDatabase;
    }
}
