package finalTest.libraryManagement.domain.UseCases.user;

import java.util.List;

import finalTest.libraryManagement.domain.gateways.user.IUserRepository;
import finalTest.libraryManagement.domain.models.user.User;
import finalTest.libraryManagement.domain.models.user.attributes.UserId;
import finalTest.libraryManagement.domain.models.user.attributes.UserLastName;
import finalTest.libraryManagement.domain.models.user.attributes.UserName;

public class UserUseCase {

    private final IUserRepository iUserRepository;

    public UserUseCase(IUserRepository iUserRepository) {
        this.iUserRepository = iUserRepository;
    }

    public List<User> findAllUsers() {
        return iUserRepository.findAllUsers();
    }

    public User findUserById(Integer userId) throws Exception {
        User user = iUserRepository.findUserById(userId);
        if (user == null) {
            throw new Exception("The user with id [" + userId + "] does not exists!");
        } else {
            return user;
        }
    }

    public User saveUser(User user) {
        return iUserRepository.saveUser(user);
    }

    public User updateUser(User users) {
        User user = iUserRepository.findUserById(users
                                                          .getUserId()
                                                          .getUserId()
        );
        User userUpdated = new User(new UserId(user
                                                       .getUserId()
                                                       .getUserId()),
                                    new UserName(users
                                                         .getUserName()
                                                         .getUserName()),
                                    new UserLastName(users
                                                             .getUserLastName()
                                                             .getUserLastName())
        );

        return iUserRepository.updateUser(userUpdated);
    }

    public void deleteUserById(Integer userId) {
       iUserRepository.deleteUserById(userId);
    }

}
