package com.example.contactbook.controller;

import com.example.contactbook.domain.Contact;
import com.example.contactbook.sevice.ContactBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("contacts")
public class ContactBookController {

    @Autowired
    private ContactBookService contactBookService;

    @GetMapping
    public List<Contact> allContacts() {
        return contactBookService.getAllContacts();
    }

    @PostMapping("/add")
    public void createContact(@RequestBody Contact contact) {
        contactBookService.createContact(contact.getFullName(), contact.getFirstName(), contact.getLastName(), contact.getPhoneNumber(), contact.getCellPhoneNumber(), contact.getAddress());
    }

    @PostMapping("/findContact")
    public Contact findContactByFullName(@RequestBody Contact contact) {
        return contactBookService.findContactByFullName(contact.getFullName());
    }

    @PostMapping("/delete/{fullName}")
    public void deleteContactByFullName(@PathVariable("fullName") String fullName) {
        contactBookService.deleteContactByFullName(fullName);
    }

    @PostMapping("/update")
    public void updateContact(@RequestBody Contact contact) {
        contactBookService.updateContact(contact);
    }
}
