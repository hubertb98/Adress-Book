package org.example.dao;

import org.example.Contact;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringBootConfiguration.class)
class ContactDaoTest {
    @Autowired
    private ContactDao contactDao;

    @Test
    void findByName() {
        //Given
        Contact contact1 = new Contact("Will", "Smith", "wsmith@example.com", "596315975");

        //When
        contactDao.save(contact1);

        //Then
        List<Contact> results = contactDao.findByName("Will");
        Assertions.assertEquals(results.size(), 1);

    }

    @Test
    void findByLastname() {
        //Given
        //When
        //Then
    }

    @Test
    void findContactByPhoneNumber() {
        //Given
        //When
        //Then
    }

    @Test
    void findByEmail() {
        //Given
        //When
        //Then
    }
}