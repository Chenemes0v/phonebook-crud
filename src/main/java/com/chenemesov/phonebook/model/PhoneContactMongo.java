package com.chenemesov.phonebook.model;
import jakarta.persistence.Id;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDate;

@Data
@Document(collection = "phone_contact_mongo")
public class PhoneContactMongo {
    @Id
    private String id;
    private String name;
    private LocalDate birthDate;
    private String phoneNumber;
    private String secondaryPhoneNumber;
    private LocalDate creationDate;
}
