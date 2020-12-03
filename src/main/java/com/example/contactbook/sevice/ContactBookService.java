package com.example.contactbook.sevice;

import com.example.contactbook.domain.ContactBook;
import com.example.contactbook.repos.ContactBookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

@Service
public class ContactBookService {

    @Autowired
    ContactBookRepo contactRepo;

    public Model mainPageWithContacts(Model model) {

        model.addAttribute("contacts", contactRepo.findAll());
        return model;
    }

    public Model createContact(String fullName, String firstName, String lastName,
                               String phoneNumber, String cellPhoneNumber, String address,
                               Model model) {

        String message;
        if (contactRepo.findByFullName(fullName) != null) {
            message = "user is already exist, please choose another name";
            model.addAttribute("message", message);
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
        model.addAttribute("contacts", contactFromDB);

        return model;
    }

    public Model findContact(String fullName, Model model) {
        ContactBook contactByFullName = contactRepo.findByFullName(fullName);
        model.addAttribute("contacts", contactByFullName);
        return model;
    }

    public Model updateContact(String fullName, Model model) {
        ContactBook updateContact = contactRepo.findByFullName(fullName);
        model.addAttribute("updateContact", updateContact);
        return model;
    }

    public Model updateFilm(ContactBook contact, Model model) {
        model.addAttribute("updateContact", contact);
        String message;
        if (contactRepo.findByFullName(contact.getFullName()) != null) {
            message = "this name is already exist, please choose another name!!!";
            model.addAttribute("message", message);
            return model;
        }

        contactRepo.save(contact);
        return model;
    }
}
