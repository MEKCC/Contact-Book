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


//    @PostMapping("/add")
//    public void createContact(@RequestParam String fullName, @RequestParam String firstName, @RequestParam String lastName,
//                              @RequestParam String phoneNumber, @RequestParam String cellPhoneNumber, @RequestParam String address,
//                              Model model) {
//
//        contactBookService.createContact(fullName, firstName, lastName, phoneNumber, cellPhoneNumber, address, model);
//    }
//
//    @GetMapping("/findContact")
//    public String findContactByFullName(@RequestParam String fullName, Model model) {
//
//        contactBookService.findContactByFullName(fullName, model);
//        return "main";
//    }
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
