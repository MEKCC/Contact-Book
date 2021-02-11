package com.example.contactbook.repos;

import com.example.contactbook.domain.Contact;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ContactBookRepo extends MongoRepository<Contact, String> {

    Contact findByFullName(String fullName);
    void deleteByFullName(String fullName);
    Optional<Contact> findById(String id);
}
