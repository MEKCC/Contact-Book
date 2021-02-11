package com.example.contactbook.sevice;

import com.example.contactbook.domain.Contact;
import com.example.contactbook.repos.ContactBookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class ContactBookService {

    @Autowired
    private ContactBookRepo contactRepo;

    public List<Contact> getAllContacts() {
        return contactRepo.findAll();
    }

    public void createContact(String fullName, String firstName, String lastName,
                              String phoneNumber, String cellPhoneNumber, String address) {

        if (contactRepo.findByFullName(fullName) != null) {
            String message = "user is already exist, please choose another full name";
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, message);
        }

        Contact contact = Contact.builder()
                .fullName(fullName)
                .firstName(firstName)
                .lastName(lastName)
                .phoneNumber(phoneNumber)
                .cellPhoneNumber(cellPhoneNumber)
                .address(address)
                .build();

        contactRepo.save(contact);
    }

    public Contact findContactByFullName(String fullName) {
        return contactRepo.findByFullName(fullName);
    }

    public void deleteContactByFullName(String fullName) {
        contactRepo.deleteByFullName(fullName);
    }

    public void updateContact(Contact contact) {

        if (contactRepo.findByFullName(contact.getFullName()) != null) {
            String message = "user is already exist, please choose another full name";
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, message);
        }

        contactRepo.save(contact);
    }
}
