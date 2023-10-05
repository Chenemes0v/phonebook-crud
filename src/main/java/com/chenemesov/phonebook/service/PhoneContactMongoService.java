package com.chenemesov.phonebook.service;
import com.chenemesov.phonebook.dto.Filter;
import com.chenemesov.phonebook.model.PhoneContactMongo;
import com.chenemesov.phonebook.repository.PhoneContactMongoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.List;

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
    public void deleteByPhoneNumber(String phoneNumber) {
        if (!repository.existsByPhoneNumber(phoneNumber)) {
            throw new EntityNotFoundException("Contact with phone number " + phoneNumber + " not found.");
        }
        repository.deleteByPhoneNumber(phoneNumber);
    }

    public void deleteById(String id) {
        if (!repository.existsById(id)) {
            throw new EntityNotFoundException("Contact with ID " + id + " not found.");
        }
        repository.deleteById(id);
    }
    public List<PhoneContactMongo> getAllContacts(Filter filter) {
        Pageable pageable = PageRequest.of(filter.getOffset(), filter.getLimit());
        return repository.findAll(pageable).getContent();
    }
}
