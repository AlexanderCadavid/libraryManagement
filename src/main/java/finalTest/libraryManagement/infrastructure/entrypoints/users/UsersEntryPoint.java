package finalTest.libraryManagement.infrastructure.entrypoints.users;

import java.util.List;

import finalTest.libraryManagement.domain.UseCases.users.UsersUseCase;
import finalTest.libraryManagement.domain.models.users.Users;
import finalTest.libraryManagement.infrastructure.entrypoints.DTOs.usersDTO.UsersDTO;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class UsersEntryPoint {

    private final UsersUseCase usersUseCase;

    @GetMapping
    public ResponseEntity<?> findAllUsers() {
        List<Users> users = usersUseCase.findAllUsers();
        if (users.isEmpty()) {
            return new ResponseEntity<>(users, HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(users, HttpStatus.FOUND);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findUserById(@PathVariable(name = "id") Integer userId) {
        try {
            UsersDTO userDTO = UsersDTO.fromDomain(usersUseCase.findUserById(userId));
            return new ResponseEntity<>(userDTO, HttpStatus.FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<?> saveUser(@RequestBody @Valid UsersDTO usersDTO) {
        Users user = UsersDTO.toDomain(usersDTO);
        UsersDTO userDTO = UsersDTO.fromDomain(usersUseCase.saveBook(user));
        return new ResponseEntity<>(userDTO, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<?> updateUser(@RequestBody UsersDTO usersDTO) {
        try {
            Users user = UsersDTO.toDomain(usersDTO);
            UsersDTO userUpdated = UsersDTO.fromDomain(usersUseCase.updateUser(user));
            return new ResponseEntity<>(userUpdated, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public void deleteUserById(@PathVariable(name = "id") Integer userId) {
        usersUseCase.deleteUserById(userId);
    }
}
