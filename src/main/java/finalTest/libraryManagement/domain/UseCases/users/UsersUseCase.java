package finalTest.libraryManagement.domain.UseCases.users;

import java.util.List;

import finalTest.libraryManagement.domain.gateways.users.IUsersRepository;
import finalTest.libraryManagement.domain.models.users.Users;
import finalTest.libraryManagement.domain.models.users.attributes.PenaltyFee;
import finalTest.libraryManagement.domain.models.users.attributes.UserId;
import finalTest.libraryManagement.domain.models.users.attributes.UserLastName;
import finalTest.libraryManagement.domain.models.users.attributes.UserName;

public class UsersUseCase {

    private final IUsersRepository iUsersRepository;

    public UsersUseCase(IUsersRepository iUsersRepository) {
        this.iUsersRepository = iUsersRepository;
    }

    public List<Users> findAllUsers() {
        return iUsersRepository.findAllUsers();
    }

    public Users findUserById(Integer userId) throws Exception {
        Users user = iUsersRepository.findUserById(userId);
        if (user == null) {
            throw new Exception("The user with id [" + userId + "] does not exists!");
        } else {
            return user;
        }
    }

    public Users saveBook(Users users) {
        return iUsersRepository.saveUser(users);
    }

    public Users updateUser(Users users) {
        Users user = iUsersRepository.findUserById(users
                                                           .getUserId()
                                                           .getUserId());
        Users userUpdated = new Users(new UserId(user
                                                         .getUserId()
                                                         .getUserId()),
                                      new UserName(users
                                                           .getUserName()
                                                           .getUserName()),
                                      new UserLastName(users
                                                               .getUserLastName()
                                                               .getUserLastName()),
                                      new PenaltyFee(users
                                                             .getPenaltyFee()
                                                             .getPenaltyFee()));

        return iUsersRepository.updateUser(userUpdated);
    }

    public void deleteUserById(Integer userId) {
        iUsersRepository.deleteUserById(userId);
    }

}
