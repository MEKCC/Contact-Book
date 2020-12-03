package com.example.contactbook.controller;

import com.example.contactbook.domain.ContactBook;
import com.example.contactbook.repos.ContactBookRepo;
import com.example.contactbook.sevice.ContactBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller("/")
public class ContactBookController {

    @Autowired
    private ContactBookRepo contactRepo;

    @Autowired
    private ContactBookService contactBookService;

    @GetMapping
    public String mainPageWithContacts(Map<String, Object> model) {
        model.put("contacts", contactBookService.mainPageWithContacts());

        return "main";
    }

    @PostMapping
    public String createContact(@RequestParam String fullName, @RequestParam String firstName, @RequestParam String lastName,
                                @RequestParam String phoneNumber, @RequestParam String cellPhoneNumber, @RequestParam String address,
                                Map<String, Object> model) {

        contactBookService.createContact(fullName,firstName, lastName, phoneNumber, cellPhoneNumber, address, model);
//        model = contactBookService.createContact(fullName,firstName, lastName, phoneNumber, cellPhoneNumber, address, model);

//        String message;
//        if (contactRepo.findByFullName(fullName) != null) {
//            message = "user is already exist, please choose another name";
//            model.put("message", message);
//            return "main";
//        }
//
//        ContactBook contact = ContactBook.builder()
//                .fullName(fullName)
//                .firstName(firstName)
//                .lastName(lastName)
//                .phoneNumber(phoneNumber)
//                .cellPhoneNumber(cellPhoneNumber)
//                .address(address)
//                .build();
//
//        contactRepo.save(contact);
//
//        Iterable<ContactBook> contactFromDB = contactRepo.findAll();
//        model.put("contacts", contactFromDB);

        return "main";
    }

    @GetMapping("/findContact")
    public String findContact(@RequestParam String fullName, Map<String, Object> model) {
        model = contactBookService.findContact(fullName, model);

//        ContactBook contactByFullName = contactRepo.findByFullName(fullName);
//
//        model.put("contacts", contactByFullName);

        return "main";
    }

    @GetMapping("/update/{fullName}")
    public String updateContact(@PathVariable("fullName") String fullName, Model model) {
        ContactBook updateContact = contactRepo.findByFullName(fullName);
        model.addAttribute("updateContact", updateContact);

        return "editContact";
    }

    @PostMapping("/updateContact")
    public String updateFilm(@ModelAttribute("contact") ContactBook contact, Model model) {
        System.out.println("FULLNAME ------->" + contact.getFullName());

        String message;
        if (contactRepo.findByFullName(contact.getFullName()) != null) {
            message = "this name is already exist, please choose another name!!!";
            model.addAttribute("message", message);
            model.addAttribute("updateContact", contact);
            return "editContact";
        }

        contactRepo.save(contact);
        return "redirect:/";
    }

    @GetMapping("/delete/{fullName}")
    public String deleteContact(@PathVariable("fullName") String fullName) {
        contactRepo.deleteByFullName(fullName);
        return "redirect:/";
    }

//    @GetMapping("/delete/{id}")
//    public String deleteByIdContact(@PathVariable("id") String id) {
//        contactRepo.deleteById(id);
//        return "redirect:/";
//    }
}
