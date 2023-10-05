package com.chenemesov.phonebook.controller;
import com.chenemesov.phonebook.dto.PhoneContactMongoDTO;
import com.chenemesov.phonebook.model.PhoneContactMongo;
import com.chenemesov.phonebook.service.PhoneContactMongoService;
import com.chenemesov.phonebook.util.PhoneContactMongoConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/mongo-contacts")
public class PhoneContactMongoController {
    @Autowired
    private PhoneContactMongoService service;

    @GetMapping("/phone/{phoneNumber}")
    public PhoneContactMongoDTO getByPhoneNumber(@PathVariable String phoneNumber) {
        PhoneContactMongo contact = service.getByPhoneNumber(phoneNumber);
        return PhoneContactMongoConverter.toDTO(contact);
    }

    @GetMapping("/{id}")
    public PhoneContactMongoDTO getById(@PathVariable String id) {
        PhoneContactMongo contact = service.getById(id);
        return PhoneContactMongoConverter.toDTO(contact);
    }
}
