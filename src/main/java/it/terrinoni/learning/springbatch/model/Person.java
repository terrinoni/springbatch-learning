package it.terrinoni.learning.springbatch.model;

import org.springframework.stereotype.Component;

/**
 * Person model class.
 *
 * @author Marco Terrinoni <marco.terrinoni@consoft.it>
 */
@Component
public class Person {

    private String firstName;
    private String lastName;

    public Person () {
    }

    public Person (String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName () {
        return firstName;
    }

    public void setFirstName (String firstName) {
        this.firstName = firstName;
    }

    public String getLastName () {
        return lastName;
    }

    public void setLastName (String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString () {
        return "Person{" + "firstName=" + firstName + ", lastName=" + lastName + '}';
    }

}
