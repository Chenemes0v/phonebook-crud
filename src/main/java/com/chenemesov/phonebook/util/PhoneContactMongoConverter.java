package com.chenemesov.phonebook.util;
import com.chenemesov.phonebook.dto.PhoneContactMongoDTO;
import com.chenemesov.phonebook.model.PhoneContactMongo;

public class PhoneContactMongoConverter {

    public static PhoneContactMongoDTO toDTO(PhoneContactMongo contact) {
        PhoneContactMongoDTO dto = new PhoneContactMongoDTO();
        dto.setId(contact.getId());
        dto.setName(contact.getName());
        dto.setBirthDate(contact.getBirthDate());
        dto.setPhoneNumber(contact.getPhoneNumber());
        dto.setSecondaryPhoneNumber(contact.getSecondaryPhoneNumber());
        dto.setCreationDate(contact.getCreationDate());
        return dto;
    }

    public static PhoneContactMongo toEntity(PhoneContactMongoDTO dto) {
        PhoneContactMongo contact = new PhoneContactMongo();
        contact.setId(dto.getId());
        contact.setName(dto.getName());
        contact.setBirthDate(dto.getBirthDate());
        contact.setPhoneNumber(dto.getPhoneNumber());
        contact.setSecondaryPhoneNumber(dto.getSecondaryPhoneNumber());
        contact.setCreationDate(dto.getCreationDate());
        return contact;
    }
}
