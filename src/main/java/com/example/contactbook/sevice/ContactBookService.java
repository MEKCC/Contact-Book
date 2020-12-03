package com.example.contactbook.sevice;

import com.example.contactbook.domain.ContactBook;
import com.example.contactbook.repos.ContactBookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ContactBookService {

    @Autowired
    ContactBookRepo contactRepo;

    public List<ContactBook> mainPageWithContacts() {
        return contactRepo.findAll();
    }

    public Map<String, Object> createContact(String fullName, String firstName, String lastName,
                                             String phoneNumber, String cellPhoneNumber, String address,
                                             Map<String, Object> model) {

        String message;
        if (contactRepo.findByFullName(fullName) != null) {
            message = "user is already exist, please choose another name";
            model.put("message", message);
            return model;
        }

        ContactBook contact = ContactBook.builder()
                .fullName(fullName)
                .firstName(firstName)
                .lastName(lastName)
                .phoneNumber(phoneNumber)
                .cellPhoneNumber(cellPhoneNumber)
                .address(address)
                .build();

        contactRepo.save(contact);

        Iterable<ContactBook> contactFromDB = contactRepo.findAll();
        model.put("contacts", contactFromDB);

        return model;
    }

    public Map<String, Object> findContact(String fullName, Map<String, Object> model) {
        ContactBook contactByFullName = contactRepo.findByFullName(fullName);
        model.put("contacts", contactByFullName);
        return model;
    }
}
