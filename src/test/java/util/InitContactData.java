package util;

import com.example.contactbook.domain.Contact;

import java.util.ArrayList;
import java.util.List;

public class InitContactData {

    public static List<Contact> getContactList() {
        List<Contact> contacts = new ArrayList<>();
        Contact contact = Contact.builder()
                .fullName("random")
                .build();
        contacts.add(contact);

        return contacts;
    }

    public static Contact getOneContact() {
        return Contact.builder()
                .fullName("Maksym")
                .firstName("Max")
                .lastName("Petrychuk")
                .phoneNumber("123")
                .cellPhoneNumber("456")
                .address("random street")
                .build();
    }
}
