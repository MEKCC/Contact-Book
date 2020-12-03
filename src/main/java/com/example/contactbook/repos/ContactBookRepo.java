package com.example.contactbook.repos;

import com.example.contactbook.domain.ContactBook;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ContactBookRepo extends MongoRepository<ContactBook, String> {

    ContactBook findByFullName(String fullName);
    void deleteByFullName(String fullName);

    void deleteById(String id);
}
