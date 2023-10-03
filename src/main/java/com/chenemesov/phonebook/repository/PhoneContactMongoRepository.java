package com.chenemesov.phonebook.repository;
import com.chenemesov.phonebook.model.PhoneContactMongo;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PhoneContactMongoRepository extends MongoRepository<PhoneContactMongo, String> {
}
