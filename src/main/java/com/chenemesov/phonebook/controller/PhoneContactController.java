package com.chenemesov.phonebook.controller;
import com.chenemesov.phonebook.service.PhoneContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/phone-contacts")
public class PhoneContactController {
    @Autowired
    private PhoneContactService service;
}
