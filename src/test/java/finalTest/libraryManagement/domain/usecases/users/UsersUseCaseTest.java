package finalTest.libraryManagement.domain.usecases.users;

import finalTest.libraryManagement.domain.UseCases.users.UsersUseCase;
import finalTest.libraryManagement.domain.gateways.users.IUsersRepository;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UsersUseCaseTest {

    @InjectMocks
    private UsersUseCase usersUseCase;

    @Mock
    private IUsersRepository iUsersRepository;
}
