package com.chenemesov.phonebook.service;
import com.chenemesov.phonebook.dto.Filter;
import com.chenemesov.phonebook.model.PhoneContact;
import com.chenemesov.phonebook.repository.PhoneContactRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

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
    public void deleteById(Long id) {
        if (!repository.existsById(id)) {
            throw new EntityNotFoundException("Contact with ID " + id + " not found.");
        }
        repository.deleteById(id);
    }
    public void deleteByPhoneNumber(String phoneNumber) {
        Optional<PhoneContact> contactOptional = repository.findByPhoneNumber(phoneNumber);
        if (!contactOptional.isPresent()) {
            throw new EntityNotFoundException("Contact with phone number " + phoneNumber + " not found.");
        }
        PhoneContact contact = contactOptional.get();
        repository.delete(contact);
    }
    public List<PhoneContact> getAllContacts(Filter filter) {
        Pageable pageable = PageRequest.of(filter.getOffset(), filter.getLimit());
        return repository.findAll(pageable).getContent();
    }
}
