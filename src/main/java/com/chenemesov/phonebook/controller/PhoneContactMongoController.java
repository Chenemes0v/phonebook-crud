package com.chenemesov.phonebook.controller;
import com.chenemesov.phonebook.dto.PhoneContactMongoDTO;
import com.chenemesov.phonebook.model.PhoneContactMongo;
import com.chenemesov.phonebook.service.PhoneContactMongoService;
import com.chenemesov.phonebook.util.PhoneContactMongoConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    @DeleteMapping("/phone/{phoneNumber}")
    public ResponseEntity<Void> deleteByPhoneNumber(@PathVariable String phoneNumber) {
        service.deleteByPhoneNumber(phoneNumber);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable String id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
