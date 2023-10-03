package com.chenemesov.phonebook.controller;
import com.chenemesov.phonebook.service.PhoneContactMongoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/mongo-contacts")
public class PhoneContactMongoController {
    @Autowired
    private PhoneContactMongoService service;
}
