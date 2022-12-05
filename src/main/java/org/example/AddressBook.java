package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class AddressBook {
    private List<Contact> contacts;

    public AddressBook() {
        this.contacts = new ArrayList<>();
    }

    public void addContact(Contact contact) {
        contacts.add(contact);
    }

    public void removePerson(Contact contact) {
        contacts.remove(contact);
    }

    public void editContact(Contact oldContact, Contact newContact) {
        int index = contacts.indexOf(oldContact);
        if (index >= 0) {
            contacts.set(index, newContact);
        }
    }

    public List<Contact> findContactByName(String name) {
        return contacts.stream()
                .filter(c -> c.getName().equals(name))
                .collect(Collectors.toList());
    }

    public List<Contact> findContactByLastname(String lastname) {
        return contacts.stream()
                .filter(c -> c.getLastname().equals(lastname))
                .collect(Collectors.toList());
    }

    public List<Contact> findContactByPhoneNumber(String phoneNumber) {
        return contacts.stream()
                .filter(c -> c.getPhoneNumber().equals(phoneNumber))
                .collect(Collectors.toList());
    }

    public List<Contact> findContactByEmail(String email) {
        return contacts.stream()
                .filter(c -> c.getEmail().equals(email))
                .collect(Collectors.toList());
    }

    public List<Contact> getContacts() {
        return contacts;
    }

    public void setContacts(List<Contact> contacts) {
        this.contacts = contacts;
    }
}