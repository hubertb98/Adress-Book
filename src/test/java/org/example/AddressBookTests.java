package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AddressBookTests {

    @Test
    public void testAddContact() {
        //Given
        AddressBook addressBook = new AddressBook();
        Contact person1 = new Contact("Hubert", "Burdzy", "hubertb.98.hb@gmail.com", "510622046");
        Contact person2 = new Contact("Sandra", "Kotlarek", "sandrakot168@gmail.com", "697225995");

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
        Contact person1 = new Contact("Hubert", "Burdzy", "hubertb.98.hb@gmail.com", "510622046");
        Contact person2 = new Contact("Sandra", "Kotlarek", "sandrakot168@gmail.com", "697225995");

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
