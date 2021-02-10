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

//
//    @GetMapping("/update/{fullName}")
//    public String updateContact(@PathVariable("fullName") String fullName, Model model) {
//
//        contactBookService.updateContact(fullName, model);
//        return "editContact";
//    }
//
//    @PostMapping("/updateContact")
//    public String updateFilm(@ModelAttribute("contact") Contact contact, Model model) {
//
//        contactBookService.updateFilm(contact, model);
//        return "editContact";
//    }
//
//    @GetMapping("/delete/{fullName}")
//    public String deleteContactByFullName(@PathVariable("fullName") String fullName) {
//        contactBookService.deleteContactByFullName(fullName);
//        return "redirect:/";
//    }

//    @GetMapping("/delete/{id}")
//    public String deleteContact(@PathVariable("id") String id) {
//        contactRepo.deleteById(id);
//        return "redirect:/";
//    }
}
