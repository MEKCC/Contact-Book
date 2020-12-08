package com.example.contactbook.controller;

import com.example.contactbook.domain.Contact;
import com.example.contactbook.repos.ContactBookRepo;
import com.example.contactbook.sevice.ContactBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//@Controller("/")
@RestController
@RequestMapping("contacts")
public class ContactBookController {

    @Autowired
    private ContactBookService contactBookService;

    @Autowired
    private ContactBookRepo contactBookRepo;

//    @GetMapping
//    public String mainPageWithContacts(Model model) {
//
//        contactBookService.mainPageWithContacts(model);
//        return "main";
//    }


//    @GetMapping(produces = "application/json")
    @GetMapping
    public List<Contact> mainPageWithContacts() {
        return contactBookRepo.findAll();
    }


//    @PostMapping
//    public String createContact(@RequestParam String fullName, @RequestParam String firstName, @RequestParam String lastName,
//                                @RequestParam String phoneNumber, @RequestParam String cellPhoneNumber, @RequestParam String address,
//                                Model model) {
//
//        contactBookService.createContact(fullName, firstName, lastName, phoneNumber, cellPhoneNumber, address, model);
//        return "main";
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
