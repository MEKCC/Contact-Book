package com.example.contactbook.sevice;

import com.example.contactbook.domain.Contact;
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

        Contact contact = Contact.builder()
                .fullName(fullName)
                .firstName(firstName)
                .lastName(lastName)
                .phoneNumber(phoneNumber)
                .cellPhoneNumber(cellPhoneNumber)
                .address(address)
                .build();

        contactRepo.save(contact);

        Iterable<Contact> contactFromDB = contactRepo.findAll();
        model.addAttribute("contacts", contactFromDB);

        return model;
    }

    public Model findContactByFullName(String fullName, Model model) {
        Contact contactByFullName = contactRepo.findByFullName(fullName);
        model.addAttribute("contacts", contactByFullName);
        return model;
    }

    public Model updateContact(String fullName, Model model) {
        Contact updateContact = contactRepo.findByFullName(fullName);
        model.addAttribute("updateContact", updateContact);
        return model;
    }

    public Model updateFilm(Contact contact, Model model) {
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

    public void deleteContactByFullName(String fullName) {
        contactRepo.deleteByFullName(fullName);
    }
}
