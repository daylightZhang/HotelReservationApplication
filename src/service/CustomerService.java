package service;

import model.Customer;
import java.util.Collection;
import java.util.HashSet;

public class CustomerService {
    public static void addCustomer(String email, String firstName, String lastName) {
        return;
    }

    public static Customer getCustomer(String customerEmail) {
        Customer c = new Customer();
        return c;
    }

    public static Collection<Customer> getAllCustomer() {
        Collection<Customer> c = new HashSet<>();
        return c;
    }
}
