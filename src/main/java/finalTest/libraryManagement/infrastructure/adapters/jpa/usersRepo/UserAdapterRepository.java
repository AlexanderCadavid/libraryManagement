package finalTest.libraryManagement.infrastructure.adapters.jpa.usersRepo;

import java.util.List;
import java.util.Optional;

import finalTest.libraryManagement.domain.gateways.users.IUsersRepository;
import finalTest.libraryManagement.domain.models.users.Users;
import finalTest.libraryManagement.infrastructure.adapters.DBOs.usersDBO.UsersDBO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
@Getter
@Setter
public class UserAdapterRepository implements IUsersRepository {

    private final IUserAdapterRepository iUserAdapterRepository;

    @Override
    public List<Users> findAllUsers() {
        return iUserAdapterRepository
                .findAll()
                .stream()
                .map(UsersDBO::toDomain)
                .toList();
    }

    @Override
    public Users findUserById(Integer userId) {
        Optional<UsersDBO> user = iUserAdapterRepository.findById(userId);
        if (user.isEmpty()) {
            throw new NullPointerException("The user with the id [" + userId + "] does not exists!");
        } else {
            return UsersDBO.toDomain(user.get());
        }
    }

    @Override
    public Users saveUser(Users users) {
        UsersDBO usersDBO = UsersDBO.fromDomain(users);
        return UsersDBO.toDomain(iUserAdapterRepository.save(usersDBO));
    }

    @Override
    public Users updateUser(Users users) {
        UsersDBO usersDBO = UsersDBO.fromDomain(users);
        UsersDBO userUpdated = iUserAdapterRepository.save(usersDBO);
        return UsersDBO.toDomain(userUpdated);
    }

    @Override
    public void deleteUserById(Integer userId) {
        Optional<UsersDBO> user = iUserAdapterRepository.findById(userId);
        if (user.isEmpty()) {
            throw new NullPointerException("The user with the id [" + userId + "] does not exists!");
        } else {
            iUserAdapterRepository.deleteById(userId);
        }
    }
}
