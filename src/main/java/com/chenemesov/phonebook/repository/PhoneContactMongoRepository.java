package com.chenemesov.phonebook.repository;
import com.chenemesov.phonebook.model.PhoneContactMongo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.Optional;

public interface PhoneContactMongoRepository extends MongoRepository<PhoneContactMongo, String> {
    Optional<PhoneContactMongo> findByPhoneNumber(String phoneNumber);
    void deleteByPhoneNumber(String phoneNumber);
    boolean existsByPhoneNumber(String phoneNumber);
    Page<PhoneContactMongo> findAll(Pageable pageable);
}
