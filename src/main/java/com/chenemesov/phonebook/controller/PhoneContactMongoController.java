package com.chenemesov.phonebook.controller;
import com.chenemesov.phonebook.dto.Filter;
import com.chenemesov.phonebook.dto.PhoneContactMongoDTO;
import com.chenemesov.phonebook.model.PhoneContactMongo;
import com.chenemesov.phonebook.service.PhoneContactMongoService;
import com.chenemesov.phonebook.util.PhoneContactMongoConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;

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
    @GetMapping("/all")
    public List<PhoneContactMongoDTO> getAllContacts(@RequestBody Filter filter) {
        if (filter.getLimit() <= 0 || filter.getOffset() < 0) {
            throw new IllegalArgumentException("Invalid limit or offset values");
        }
        List<PhoneContactMongo> contacts = service.getAllContacts(filter);
        return contacts.stream().map(PhoneContactMongoConverter::toDTO).collect(Collectors.toList());
    }
    @PutMapping("/id/{id}")
    public PhoneContactMongoDTO updateById(@PathVariable String id, @RequestBody PhoneContactMongoDTO contactDTO) {
        PhoneContactMongo updatedContact = PhoneContactMongoConverter.toEntity(contactDTO);
        PhoneContactMongo savedContact = service.updateById(id, updatedContact);
        return PhoneContactMongoConverter.toDTO(savedContact);
    }

    @PutMapping("/phone/{phoneNumber}")
    public PhoneContactMongoDTO updateByPhoneNumber(@PathVariable String phoneNumber, @RequestBody PhoneContactMongoDTO contactDTO) {
        PhoneContactMongo updatedContact = PhoneContactMongoConverter.toEntity(contactDTO);
        PhoneContactMongo savedContact = service.updateByPhoneNumber(phoneNumber, updatedContact);
        return PhoneContactMongoConverter.toDTO(savedContact);
    }
}
