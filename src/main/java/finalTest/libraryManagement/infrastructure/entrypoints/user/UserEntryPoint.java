package finalTest.libraryManagement.infrastructure.entrypoints.user;

import java.util.List;

import finalTest.libraryManagement.domain.UseCases.user.UserUseCase;
import finalTest.libraryManagement.domain.models.user.User;
import finalTest.libraryManagement.infrastructure.entrypoints.DTOs.userDTO.UserDTO;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@AllArgsConstructor
public class UserEntryPoint {

    private final UserUseCase userUseCase;

    @GetMapping
    public ResponseEntity<?> findAllUsers() {
        List<UserDTO> userDTOList = userUseCase
                .findAllUsers()
                .stream()
                .map(UserDTO::fromDomain)
                .toList();
        if (userDTOList.isEmpty()) {
            return new ResponseEntity<>("The user list is empty", HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(userDTOList, HttpStatus.FOUND);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findUserById(@PathVariable(name = "id") Integer userId) {
        try {
            UserDTO userDTO = UserDTO.fromDomain(userUseCase.findUserById(userId));
            return new ResponseEntity<>(userDTO, HttpStatus.FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<?> saveUser(@RequestBody @Valid UserDTO usersDTO) {
        User user = UserDTO.toDomain(usersDTO);
        UserDTO userDTO = UserDTO.fromDomain(userUseCase.saveUser(user));
        return new ResponseEntity<>(userDTO, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<?> updateUser(@RequestBody UserDTO userDTO) {
        try {
            User user = UserDTO.toDomain(userDTO);
            UserDTO userUpdated = UserDTO.fromDomain(userUseCase.updateUser(user));
            return new ResponseEntity<>(userUpdated, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public void deleteUserById(@PathVariable(name = "id") Integer userId) {
        userUseCase.deleteUserById(userId);
    }
}
