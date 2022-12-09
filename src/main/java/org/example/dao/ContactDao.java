package org.example.dao;

import org.example.Contact;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Repository
public interface ContactDao extends CrudRepository<Contact, Integer> {
    List<Contact> findByName(String name);
    List<Contact> findByLastname(String lastname);
    List<Contact> findContactByPhoneNumber(String PhoneNumber);
    List<Contact> findByEmail(String Email);
}
