package com.chenemesov.phonebook.repository;
import com.chenemesov.phonebook.model.PhoneContact;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface PhoneContactRepository extends JpaRepository<PhoneContact, Long> {
    Optional<PhoneContact> findByPhoneNumber(String phoneNumber);
    Optional<PhoneContact> findById(Long id);
    void deleteById(Long id);
}
