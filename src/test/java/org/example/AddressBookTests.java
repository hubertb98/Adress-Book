package org.example;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class AddressBookTests {

    @Test
    public void testAddContact() {
        //Given
        AddressBook addressBook = new AddressBook();
        Contact person1 = new Contact("Brad", "Kowalsky", "brad.kowalsky@gmail.com", "123456789");
        Contact person2 = new Contact("Amy", "Smith", "amy.smith@gmail.com", "987654321");

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
        Contact person1 = new Contact("Brad", "Kowalsky", "brad.kowalsky@gmail.com", "123456789");
        Contact person2 = new Contact("Amy", "Smith", "amy.smith@gmail.com", "987654321");

        //When
        addressBook.addContact(person1);
        addressBook.addContact(person2);

        System.out.println(addressBook.getContacts());
        addressBook.removePerson(person1);

        //Then
        assertFalse(addressBook.getContacts().contains(person1));
        assertTrue(addressBook.getContacts().contains(person2));
    }

    @Test
    public void testEditContact() {
        //Given
        AddressBook original = new AddressBook();
        AddressBook edited = new AddressBook();

        Contact person1 = new Contact("Brad", "Kowalsky", "brad.kowalsky@gmail.com", "123456789");
        Contact person2 = new Contact("Amy", "Smith", "amy.smith@gmail.com", "987654321");

        original.addContact(person1);
        original.addContact(person2);
        edited.addContact(person1);
        edited.addContact(person2);

        //When

        edited.editContact(person1, new Contact("Edward", "Adams", "edward.adams@gmail.com", "456789132"));

        //Then
        assertNotEquals(original.getContacts().get(0), edited.getContacts().get(0));
        assertEquals(original.getContacts().get(1), edited.getContacts().get(1));
    }

    @Test
    public void testFindContactByName() {
        //Given
        AddressBook addressBook = new AddressBook();

        Contact person1 = new Contact("Brad", "Kowalsky", "bkowalsky@gmail.com", "123456789");
        Contact person2 = new Contact("Anna", "Smith", "asmith@gmail.com", "987654321");
        Contact person3 = new Contact("Jan", "Kowalski", "jkowalski@example.com", "123456789");
        Contact person4 = new Contact("Anna", "Nowak", "anowak@example.com", "987654321");
        Contact person5 = new Contact("Piotr", "Wiśniewski", "pwisniewski@example.com", "111222333");
        Contact person6 = new Contact("Agata", "Zielińska", "azielinska@example.com", "444555666");
        Contact person7 = new Contact("Janusz", "Nowakowski", "jnowakowski@example.com", "777888999");

        addressBook.addContact(person1);
        addressBook.addContact(person2);
        addressBook.addContact(person3);
        addressBook.addContact(person4);
        addressBook.addContact(person5);
        addressBook.addContact(person6);
        addressBook.addContact(person7);

        //When
        List<Contact> resultsAnna = addressBook.findContactByName("Anna");
        List<Contact> resultsJan = addressBook.findContactByName("Jan");
        List<Contact> resultsPiotr = addressBook.findContactByName("Piotr");
        List<Contact> resultsAgata = addressBook.findContactByName("Agata");

        //Then
        assertEquals(resultsAnna.size(), 2);
        assertEquals(resultsJan.size(), 1);
        assertEquals(resultsPiotr.size(), 1);
        assertEquals(resultsAgata.size(), 1);
    }

    @Test
    public void testFindContactByLastname() {
        //Given
        AddressBook addressBook = new AddressBook();

        Contact person1 = new Contact("Brad", "Kowalski", "bkowalski@gmail.com", "123456789");
        Contact person2 = new Contact("Anna", "Nowak", "anowak@gmail.com", "789631245");
        Contact person3 = new Contact("Jan", "Kowalski", "jkowalski@example.com", "159357456");
        Contact person4 = new Contact("Sandra", "Nowak", "snowak@example.com", "895648665");
        Contact person5 = new Contact("Piotr", "Wiśniewski", "pwisniewski@example.com", "111222333");
        Contact person6 = new Contact("Agata", "Zielińska", "azielinska@example.com", "444555666");
        Contact person7 = new Contact("Janusz", "Nowakowski", "jnowakowski@example.com", "777888999");

        addressBook.addContact(person1);
        addressBook.addContact(person2);
        addressBook.addContact(person3);
        addressBook.addContact(person4);
        addressBook.addContact(person5);
        addressBook.addContact(person6);
        addressBook.addContact(person7);

        //When
        List<Contact> resultsKowalski = addressBook.findContactByLastname("Kowalski");
        List<Contact> resultsNowak = addressBook.findContactByLastname("Nowak");
        List<Contact> resultsNowakowski = addressBook.findContactByLastname("Nowakowski");

        //Then
        assertEquals(resultsKowalski.size(), 2);
        assertEquals(resultsNowak.size(), 2);
        assertEquals(resultsNowakowski.size(), 1);
    }

    @Test
    public void testFindContactByPhoneNumber() {
        //Given
        AddressBook addressBook = new AddressBook();

        Contact person1 = new Contact("Brad", "Kowalski", "bkowalski@gmail.com", "123456789");
        Contact person2 = new Contact("Anna", "Nowak", "anowak@gmail.com", "789631245");
        Contact person3 = new Contact("Jan", "Kowalski", "jkowalski@example.com", "159357456");
        Contact person4 = new Contact("Sandra", "Nowak", "snowak@example.com", "895648665");
        Contact person5 = new Contact("Piotr", "Wiśniewski", "pwisniewski@example.com", "111222333");
        Contact person6 = new Contact("Agata", "Zielińska", "azielinska@example.com", "444555666");
        Contact person7 = new Contact("Janusz", "Nowakowski", "jnowakowski@example.com", "777888999");

        addressBook.addContact(person1);
        addressBook.addContact(person2);
        addressBook.addContact(person3);
        addressBook.addContact(person4);
        addressBook.addContact(person5);
        addressBook.addContact(person6);
        addressBook.addContact(person7);

        //When
        List<Contact> firstResults = addressBook.findContactByPhoneNumber("123456789");
        List<Contact> secondResults = addressBook.findContactByPhoneNumber("789631245");
        List<Contact> thirdResults = addressBook.findContactByPhoneNumber("159357456");

        //Then
        assertEquals(firstResults.size(), 1);
        assertEquals(secondResults.size(), 1);
        assertEquals(thirdResults.size(), 1);

    }

    @Test
    public void testFindContactByEmail() {
        //Given
        AddressBook addressBook = new AddressBook();

        Contact person1 = new Contact("Brad", "Kowalski", "bkowalski@gmail.com", "123456789");
        Contact person2 = new Contact("Anna", "Nowak", "anowak@gmail.com", "789631245");
        Contact person3 = new Contact("Jan", "Kowalski", "jkowalski@example.com", "159357456");
        Contact person4 = new Contact("Sandra", "Nowak", "snowak@example.com", "895648665");
        Contact person5 = new Contact("Piotr", "Wiśniewski", "pwisniewski@example.com", "111222333");
        Contact person6 = new Contact("Agata", "Zielińska", "azielinska@example.com", "444555666");
        Contact person7 = new Contact("Janusz", "Nowakowski", "jnowakowski@example.com", "777888999");

        addressBook.addContact(person1);
        addressBook.addContact(person2);
        addressBook.addContact(person3);
        addressBook.addContact(person4);
        addressBook.addContact(person5);
        addressBook.addContact(person6);
        addressBook.addContact(person7);

        //When
        List<Contact> firstResults = addressBook.findContactByEmail("bkowalski@gmail.com");
        List<Contact> secondResults = addressBook.findContactByEmail("jkowalski@example.com");
        List<Contact> thirdResults = addressBook.findContactByEmail("pwisniewski@example.com");


        //Then
        assertEquals(firstResults.size(), 1);
        assertEquals(secondResults.size(), 1);
        assertEquals(thirdResults.size(), 1);
    }
}