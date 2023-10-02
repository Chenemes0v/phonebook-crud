package com.chenemesov.phonebook.controller;
import com.chenemesov.phonebook.dto.PhoneContactDTO;
import com.chenemesov.phonebook.model.PhoneContact;
import com.chenemesov.phonebook.service.PhoneContactService;
import com.chenemesov.phonebook.util.PhoneContactConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/phone-contacts")
public class PhoneContactController {
    @Autowired
    private PhoneContactService service;

    @GetMapping("/phone/{phoneNumber}")
    public PhoneContactDTO getByPhoneNumber(@PathVariable String phoneNumber) {
        PhoneContact contact = service.getByPhoneNumber(phoneNumber);
        return PhoneContactConverter.toDTO(contact);
    }

    @GetMapping("/{id}")
    public PhoneContactDTO getById(@PathVariable Long id) {
        PhoneContact contact = service.getById(id);
        return PhoneContactConverter.toDTO(contact);
    }
}
