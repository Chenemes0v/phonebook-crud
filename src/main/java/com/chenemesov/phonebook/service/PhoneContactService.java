package com.chenemesov.phonebook.service;
import com.chenemesov.phonebook.model.PhoneContact;
import com.chenemesov.phonebook.repository.PhoneContactRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PhoneContactService {
    @Autowired
    private PhoneContactRepository repository;

    public PhoneContact getByPhoneNumber(String phoneNumber) {
        return repository.findByPhoneNumber(phoneNumber)
                .orElseThrow(() -> new EntityNotFoundException("PhoneContact not found with phone number: " + phoneNumber));
    }

    public PhoneContact getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("PhoneContact not found with id: " + id));
    }

}
