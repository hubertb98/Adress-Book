package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AddressBookTests {

    @Test
    public void testAddContact() {
        //Given
        AddressBook addressBook = new AddressBook();
        Contact person1 = new Contact("Brad", "Kowalsky", "brad.kowalsky@gmail.com", "987654321");
        Contact person2 = new Contact("Amy", "Smith", "amy.smith@gmail.com", "123456789");

        //When
        addressBook.addContact(person1);
        addressBook.addContact(person2);

        //Then
        assertTrue(addressBook.getContacts().contains(person1));
        assertTrue(addressBook.getContacts().contains(person2));
    }

    @Test
    public void testRemoveContact() {
        //Given
        AddressBook addressBook = new AddressBook();
        Contact person1 = new Contact("Brad", "Kowalsky", "brad.kowalsky@gmail.com", "987654321");
        Contact person2 = new Contact("Amy", "Smith", "amy.smith@gmail.com", "123456789");

        //When
        addressBook.addContact(person1);
        addressBook.addContact(person2);
        System.out.println(addressBook.getContacts());
        addressBook.removePerson(person1);

        //Then
        assertFalse(addressBook.getContacts().contains(person1));
        assertTrue(addressBook.getContacts().contains(person2));
    }


}
