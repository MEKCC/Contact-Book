package com.example.contactbook.controller;

import com.example.contactbook.domain.ContactBook;
import com.example.contactbook.repos.ContactBookRepo;
import com.example.contactbook.sevice.ContactBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller("/")
public class ContactBookController {

    @Autowired
    private ContactBookRepo contactRepo;

    @Autowired
    private ContactBookService contactBookService;

    @GetMapping
    public String mainPageWithContacts(Model model) {

        contactBookService.mainPageWithContacts(model);
        return "main";
    }

    @PostMapping
    public String createContact(@RequestParam String fullName, @RequestParam String firstName, @RequestParam String lastName,
                                @RequestParam String phoneNumber, @RequestParam String cellPhoneNumber, @RequestParam String address,
                                Model model) {

        contactBookService.createContact(fullName, firstName, lastName, phoneNumber, cellPhoneNumber, address, model);
        return "main";
    }

    @GetMapping("/findContact")
    public String findContact(@RequestParam String fullName, Model model) {

        contactBookService.findContact(fullName, model);
        return "main";
    }

    @GetMapping("/update/{fullName}")
    public String updateContact(@PathVariable("fullName") String fullName, Model model) {

        contactBookService.updateContact(fullName, model);
        return "editContact";
    }

    @PostMapping("/updateContact")
    public String updateFilm(@ModelAttribute("contact") ContactBook contact, Model model) {

        contactBookService.updateFilm(contact, model);
        return "editContact";
    }

    @GetMapping("/delete/{fullName}")
    public String deleteContact(@PathVariable("fullName") String fullName) {
        contactRepo.deleteByFullName(fullName);
        return "redirect:/";
    }

//    @GetMapping("/delete/{id}")
//    public String deleteContact(@PathVariable("id") String id) {
//        contactRepo.deleteById(id);
//        return "redirect:/";
//    }
}
