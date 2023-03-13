package finalTest.libraryManagement.infrastructure.entrypoints.users;

import finalTest.libraryManagement.domain.UseCases.users.UsersUseCase;
import finalTest.libraryManagement.domain.models.users.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(Users.class)
public class UsersEntryPointTest {

    @MockBean
    private UsersUseCase usersUseCase;

    @Autowired
    private MockMvc mockMvc;
}
