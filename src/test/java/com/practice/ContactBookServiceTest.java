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
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static util.InitContactData.getContactList;
import static util.InitContactData.getOneContact;

@SpringBootTest
@AutoConfigureMockMvc
@ContextConfiguration(classes = {
        ContactBookService.class
})
public class ContactBookServiceTest {

    private static final List<Contact> CONTACT_LIST = getContactList();
    private static final Contact CONTACT = getOneContact();

    private static final String FULL_NAME = getOneContact().getFullName();
    private static final String PHONE_NUMBER = getOneContact().getPhoneNumber();
    private static final String CELL_PHONE_NUMBER = getOneContact().getCellPhoneNumber();
    private static final String ADDRESS = getOneContact().getAddress();
    private static final String SEARCH_PARAMETER = "random parameter";

    @MockBean
    private ContactBookRepo contactBookRepo;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ContactBookService contactBookService;

    @Test
    void createContactTestCorrectData() {
        when(contactBookRepo.findByFullName(anyString())).thenReturn(null);
        contactBookService.createContact(FULL_NAME, PHONE_NUMBER, CELL_PHONE_NUMBER, ADDRESS);
        verify(contactBookRepo, times(1)).save(CONTACT);
    }

    @Test
    void createContactTestWrongData() throws Exception {
        when(contactBookRepo.findByFullName(anyString())).thenReturn(CONTACT);

        this.mockMvc.perform(post("contacts/add"))
                .andExpect(status().is4xxClientError());

        verify(contactBookRepo, times(0)).save(CONTACT);
    }

    @Test
    void findContactsByNameOrSurnameTest() {
        contactBookService.findByFullName(SEARCH_PARAMETER);
        when(contactBookRepo.findByFullNameContainingIgnoreCase(anyString())).thenReturn(CONTACT_LIST);
        verify(contactBookRepo, times(1)).findByFullNameContainingIgnoreCase(anyString());
    }

    @Test
    void deleteContactByFullNameTest() {
        contactBookService.deleteContactByFullName(FULL_NAME);
        verify(contactBookRepo, times(1)).deleteByFullName(anyString());
    }

    @Test
    void updateContactTest() {
        when(contactBookRepo.findByFullName(anyString())).thenReturn(null);
        contactBookService.updateContact(CONTACT);
        verify(contactBookRepo, times(1)).save(CONTACT);
    }
}
