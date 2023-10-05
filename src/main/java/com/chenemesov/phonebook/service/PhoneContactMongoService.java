package com.chenemesov.phonebook.service;
import com.chenemesov.phonebook.model.PhoneContactMongo;
import com.chenemesov.phonebook.repository.PhoneContactMongoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PhoneContactMongoService {
    @Autowired
    private PhoneContactMongoRepository repository;

    public PhoneContactMongo getByPhoneNumber(String phoneNumber) {
        return repository.findByPhoneNumber(phoneNumber)
                .orElseThrow(() -> new EntityNotFoundException("PhoneContact not found with phone number: " + phoneNumber));
    }
    public PhoneContactMongo getById(String id) {
        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("PhoneContact not found with id: " + id));
    }
}
