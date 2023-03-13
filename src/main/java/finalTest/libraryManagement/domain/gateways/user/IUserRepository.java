package finalTest.libraryManagement.domain.gateways.user;

import java.util.List;

import finalTest.libraryManagement.domain.models.user.User;

public interface IUserRepository {

    List<User> findAllUsers();

    User findUserById(Integer userId);

    User saveUser(User user);

    User updateUser(User user);

    void deleteUserById(Integer userId);
}
