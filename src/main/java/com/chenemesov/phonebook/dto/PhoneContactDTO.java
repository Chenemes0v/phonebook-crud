package com.chenemesov.phonebook.dto;
import lombok.Data;
import java.time.LocalDate;

@Data
public class PhoneContactDTO {
    private Long id;
    private String name;
    private LocalDate birthDate;
    private String phoneNumber;
    private String secondaryPhoneNumber;
    private LocalDate creationDate;
}
