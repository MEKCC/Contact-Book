package util;

import com.example.contactbook.domain.Contact;

import java.util.ArrayList;
import java.util.List;

public class InitContactData {

    public static List<Contact> getContactList() {
        List<Contact> contacts = new ArrayList<>();
        contacts.add(new Contact("911", "Maksym", "Max", "Petrychuk", "123", "456", "random street"));

        return contacts;
    }

    public static Contact getOneContact() {
        return new Contact("911", "Maksym", "Max", "Petrychuk", "123", "456", "random street");
    }
}
