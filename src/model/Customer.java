package model;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Customer {
    private String firstName;
    private String lastName;
    private String email;

    public Customer(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        if (regex(email) == false) {
            System.out.println("The email address is invalid, fail to create an account.");
            throw new IllegalArgumentException();
        } else {
            this.email = email;
        }
    }

    public Customer() {
        this.firstName = "None";
        this.lastName = "None";
        this.email = "None";
    }

    final public String getFirstName() {
        return firstName;
    }

    final public String getLastName() {
        return lastName;
    }

    final public String getEmail() {
        return email;
    }

    final public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    final public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    final public void setEmail(String email) {
        this.email = email;
    }

    final public boolean regex(String email) {
        // check if the input email is valid
        // the email should have the following format: name@domain.com
        String emailRegex = "^(.+)@(.+)[.](.+)$";
        Pattern pattern = Pattern.compile(emailRegex);
        return pattern.matcher(email).matches();
    }

    @Override
    final public String toString() {
        return "Name:" + firstName + " " + lastName + "\n" +
                "Email:" + email + "\n";
    }

    @Override
    final public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return Objects.equals(email, customer.email);
    }

}
