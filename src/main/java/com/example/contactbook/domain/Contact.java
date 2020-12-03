package com.example.contactbook.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder(toBuilder = true)
@AllArgsConstructor
@Document(collection = "contact")
public class Contact {

    @Id
    private String id;

    private String fullName;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String cellPhoneNumber;
    private String address;

}
