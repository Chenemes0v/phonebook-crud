package com.chenemesov.phonebook.test;
import com.chenemesov.phonebook.model.PhoneContact;
import com.chenemesov.phonebook.repository.PhoneContactRepository;
import com.chenemesov.phonebook.service.PhoneContactService;
import org.mockito.Mockito;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.util.Optional;
import static org.mockito.Mockito.when;
import static org.testng.Assert.assertEquals;

public class PhoneContactServiceTest {
    private PhoneContactService phoneContactService;
    private PhoneContactRepository phoneContactRepository;

    @BeforeTest
    public void setUp() {
        phoneContactRepository = Mockito.mock(PhoneContactRepository.class);
        phoneContactService = new PhoneContactService(phoneContactRepository);
        PhoneContact mockContact = new PhoneContact();
        mockContact.setId(1L);
        mockContact.setName("Test");
        when(phoneContactRepository.findById(1L)).thenReturn(Optional.of(mockContact));
    }

    @Test
    public void testGetById() {
        PhoneContact result = phoneContactService.getById(1L);
        assertEquals(result.getName(), "Test");
    }
}
