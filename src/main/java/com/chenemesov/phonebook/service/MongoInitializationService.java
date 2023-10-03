package com.chenemesov.phonebook.service;
import com.chenemesov.phonebook.model.PhoneContactMongo;
import com.chenemesov.phonebook.repository.PhoneContactMongoRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;

@Service
public class MongoInitializationService {
    @Autowired
    private PhoneContactMongoRepository repository;

    @PostConstruct
    public void initData() {
        if (repository.count() == 0) {
            repository.save(new PhoneContactMongo(null, "Ерасыл", LocalDate.of(2000, 5, 1), "87004001478", "87005002424", LocalDate.now()));
            repository.save(new PhoneContactMongo(null, "Тима", LocalDate.of(2001, 1, 2), "87476597898", "87477002222", LocalDate.now()));
            repository.save(new PhoneContactMongo(null, "Магжан", LocalDate.of(2002, 4, 1), "87756254884", "87775554444", LocalDate.now()));
            repository.save(new PhoneContactMongo(null, "Асель", LocalDate.of(2003, 1, 7), "87056974477", "87776663929", LocalDate.now()));
            repository.save(new PhoneContactMongo(null, "Назерке", LocalDate.of(2004, 5, 1), "87754585225", "87471118855", LocalDate.now()));
            repository.save(new PhoneContactMongo(null, "Алия", LocalDate.of(1998, 8, 15), "87001234567", "87007654321", LocalDate.now()));
            repository.save(new PhoneContactMongo(null, "Ербол", LocalDate.of(1999, 9, 10), "87002345678", "87008654231", LocalDate.now()));
            repository.save(new PhoneContactMongo(null, "Айгерим", LocalDate.of(2000, 2, 20), "87003456789", "87009543216", LocalDate.now()));
            repository.save(new PhoneContactMongo(null, "Руслан", LocalDate.of(2002, 10, 11), "87004567890", "87001435267", LocalDate.now()));
            repository.save(new PhoneContactMongo(null, "Аяулым", LocalDate.of(1997, 12, 5), "87005678901", "87002316547", LocalDate.now()));
        }
    }
}
