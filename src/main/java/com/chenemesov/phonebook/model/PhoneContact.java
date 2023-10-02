package com.chenemesov.phonebook.model;
import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;
@Entity
@Data
@Table(name = "phone_contact")
public class PhoneContact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "birth_date")
    private LocalDate birthDate;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "secondary_phone_number")
    private String secondaryPhoneNumber;

    @Column(name = "creation_date")
    private LocalDate creationDate;
}
