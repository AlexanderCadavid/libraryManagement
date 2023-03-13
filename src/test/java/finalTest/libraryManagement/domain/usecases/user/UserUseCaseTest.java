package finalTest.libraryManagement.domain.usecases.user;

import java.util.List;

import finalTest.libraryManagement.domain.UseCases.user.UserUseCase;
import finalTest.libraryManagement.domain.gateways.user.IUserRepository;
import finalTest.libraryManagement.domain.models.user.User;
import finalTest.libraryManagement.infrastructure.entrypoints.DTOs.userDTO.UserDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
public class UserUseCaseTest {

    @InjectMocks
    private UserUseCase userUseCase;

    @Mock
    private IUserRepository iUserRepository;

    @Test
    @DisplayName("Save user test")
    void saveUser() {
        UserDTO userDTO = new UserDTO(1, "usernametest", "userlastnametest");
        User user = UserDTO.toDomain(userDTO);
        when(iUserRepository.saveUser(any(User.class))).thenReturn(user);
        UserDTO userTest = UserDTO.fromDomain(iUserRepository.saveUser(user));
        assertNotNull(userTest);
        assertEquals(userTest.getUserLastName(), userDTO.getUserLastName());
    }

    @Test
    @DisplayName("Update user")
    void updateUser() {
        UserDTO userDTO = new UserDTO(1, "usernametest", "userlastnametest");
        User user = UserDTO.toDomain(userDTO);
        when(iUserRepository.saveUser(any(User.class))).thenReturn(user);
        UserDTO userUpdated = new UserDTO(1, "usernameupdate", "userlastname");
        User userTest = UserDTO.toDomain(userUpdated);
        assertEquals("usernameupdate", userTest
                .getUserName()
                .getUserName());
    }

    @Test
    @DisplayName("Find all users")
    void findAllUsers() {
        List<User> users = userUseCase.findAllUsers();
        when(iUserRepository.findAllUsers()).thenReturn(users);
        List<User> usersTest = userUseCase.findAllUsers();
        assertNotNull(usersTest);
        assertEquals(users, usersTest);
    }


}
