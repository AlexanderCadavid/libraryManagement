package finalTest.libraryManagement.infrastructure.adapters.users;

import finalTest.libraryManagement.infrastructure.adapters.jpa.usersRepo.IUserAdapterRepository;
import finalTest.libraryManagement.infrastructure.adapters.jpa.usersRepo.UserAdapterRepository;
import org.junit.jupiter.api.BeforeAll;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class UserAdapterRepositoryTest {

    @InjectMocks
    private UserAdapterRepository userAdapterRepository;

    @Autowired
    IUserAdapterRepository iUserAdapterRepository;

    @BeforeAll
    void init() {
        userAdapterRepository = new UserAdapterRepository(iUserAdapterRepository);
    }

}
