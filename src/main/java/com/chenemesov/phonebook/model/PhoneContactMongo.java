package com.chenemesov.phonebook.model;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
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
