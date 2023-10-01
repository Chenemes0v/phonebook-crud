package com.chenemesov.phonebook.repository;
import com.chenemesov.phonebook.model.PhoneContact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhoneContactRepository extends JpaRepository<PhoneContact, Long> {
}
