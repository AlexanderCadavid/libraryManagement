package finalTest.libraryManagement.domain.gateways.users;

import java.util.List;

import finalTest.libraryManagement.domain.models.users.Users;

public interface IUsersRepository {

    List<Users> findAllUsers();

    Users findUserById(Integer userId);

    Users saveUser(Users users);

    Users updateUser(Users users);

    void deleteUserById(Integer userId);
}
