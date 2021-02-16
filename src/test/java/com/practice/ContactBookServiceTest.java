package com.practice;

import com.example.contactbook.domain.Contact;
import com.example.contactbook.repos.ContactBookRepo;
import com.example.contactbook.sevice.ContactBookService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static util.InitContactData.getContactList;
import static util.InitContactData.getOneContact;

@SpringBootTest
@AutoConfigureMockMvc
@ContextConfiguration(classes = {
        ContactBookService.class
})
public class ContactBookServiceTest {

    private static List<Contact> contacts = getContactList();
    private static Contact contact = getOneContact();

    @MockBean
    private ContactBookRepo contactBookRepo;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ContactBookService contactBookService;

    @Test
    void getAllContactsTestCorrectData() {
        String fullName = "Maksym";
        String firstName = "Max";
        String lastName = "Petrychuk";
        String phoneNumber = "123";
        String cellPhoneNumber = "456";
        String address = "random street";

        Contact contact = Contact.builder()
                .fullName(fullName)
                .firstName(firstName)
                .lastName(lastName)
                .phoneNumber(phoneNumber)
                .cellPhoneNumber(cellPhoneNumber)
                .address(address)
                .build();

        contactBookService.createContact(fullName, firstName, lastName, phoneNumber, cellPhoneNumber, address);
        verify(contactBookRepo, times(1)).save(contact);

    }

    @Test
    void getAllContactsTestWrongData() throws Exception {
        when(contactBookRepo.findByFullName(anyString())).thenReturn(contact);

        this.mockMvc.perform(get("/add"))
                .andExpect(status().is4xxClientError());

        verify(contactBookRepo, times(0)).save(contact);

    }
}
