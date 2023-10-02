package com.chenemesov.phonebook.util;
import com.chenemesov.phonebook.dto.PhoneContactDTO;
import com.chenemesov.phonebook.model.PhoneContact;

public class PhoneContactConverter {

    public static PhoneContactDTO toDTO(PhoneContact contact) {
        PhoneContactDTO dto = new PhoneContactDTO();
        dto.setId(contact.getId());
        dto.setName(contact.getName());
        dto.setBirthDate(contact.getBirthDate());
        dto.setPhoneNumber(contact.getPhoneNumber());
        dto.setSecondaryPhoneNumber(contact.getSecondaryPhoneNumber());
        dto.setCreationDate(contact.getCreationDate());
        return dto;
    }

    public static PhoneContact toEntity(PhoneContactDTO dto) {
        PhoneContact contact = new PhoneContact();
        contact.setId(dto.getId());
        contact.setName(dto.getName());
        contact.setBirthDate(dto.getBirthDate());
        contact.setPhoneNumber(dto.getPhoneNumber());
        contact.setSecondaryPhoneNumber(dto.getSecondaryPhoneNumber());
        contact.setCreationDate(dto.getCreationDate());
        return contact;
    }
}
