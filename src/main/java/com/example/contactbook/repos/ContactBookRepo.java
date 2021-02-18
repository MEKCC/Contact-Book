package com.example.contactbook.repos;

import com.example.contactbook.domain.Contact;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContactBookRepo extends MongoRepository<Contact, String> {

    Contact findByFullName(String fullName);

    List<Contact> findByFullNameContainingIgnoreCase(String fullName);

    void deleteByFullName(String fullName);
}
