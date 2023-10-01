package com.chenemesov.phonebook.service;
import com.chenemesov.phonebook.repository.PhoneContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PhoneContactService {
    @Autowired
    private PhoneContactRepository repository;
}
