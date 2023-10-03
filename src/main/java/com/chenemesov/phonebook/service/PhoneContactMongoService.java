package com.chenemesov.phonebook.service;
import com.chenemesov.phonebook.repository.PhoneContactMongoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PhoneContactMongoService {
    @Autowired
    private PhoneContactMongoRepository repository;
}
