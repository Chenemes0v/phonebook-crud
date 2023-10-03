package com.chenemesov.phonebook.controller;
import com.chenemesov.phonebook.dto.Filter;
import com.chenemesov.phonebook.dto.PhoneContactDTO;
import com.chenemesov.phonebook.model.PhoneContact;
import com.chenemesov.phonebook.service.PhoneContactService;
import com.chenemesov.phonebook.util.PhoneContactConverter;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;

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
    @DeleteMapping("/id/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
    @DeleteMapping("/phone/{phoneNumber}")
    public ResponseEntity<Void> deleteByPhoneNumber(@PathVariable String phoneNumber) {
        service.deleteByPhoneNumber(phoneNumber);
        return ResponseEntity.noContent().build();
    }
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<String> handleEntityNotFoundException(EntityNotFoundException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }
    @GetMapping("/all")
    public List<PhoneContactDTO> getAllContacts(@RequestBody Filter filter) {
        if (filter.getLimit() <= 0 || filter.getOffset() < 0) {
            throw new IllegalArgumentException("Invalid limit or offset values");
        }
        List<PhoneContact> contacts = service.getAllContacts(filter);
        return contacts.stream().map(PhoneContactConverter::toDTO).collect(Collectors.toList());
    }
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> handleIllegalArgumentException(IllegalArgumentException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }
}
