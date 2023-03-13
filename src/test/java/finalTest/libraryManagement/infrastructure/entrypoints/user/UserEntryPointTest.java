package finalTest.libraryManagement.infrastructure.entrypoints.user;

import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import finalTest.libraryManagement.domain.UseCases.user.UserUseCase;
import finalTest.libraryManagement.domain.models.book.Book;
import finalTest.libraryManagement.domain.models.user.User;
import finalTest.libraryManagement.infrastructure.entrypoints.DTOs.userDTO.UserDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(UserEntryPoint.class)
public class UserEntryPointTest {

    @MockBean
    private UserUseCase userUseCase;

    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("Save user  test")
    void saveUser() throws Exception {
        UserDTO userDTO = new UserDTO(1, "username", "userlastname");
        User user = UserDTO.toDomain(userDTO);
        when(userUseCase.saveUser((any(User.class)))).thenReturn(user);
        ObjectMapper mapper = new ObjectMapper();
        mapper.findAndRegisterModules();
        mockMvc
                .perform(MockMvcRequestBuilders
                                 .post("/user")
                                 .contentType(MediaType.APPLICATION_JSON)
                                 .content(mapper.writeValueAsString(userDTO)))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isCreated());
    }

}
