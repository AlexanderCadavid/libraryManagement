package finalTest.libraryManagement.infrastructure.adapters.jpa.userRepo;

import java.util.List;
import java.util.Optional;

import finalTest.libraryManagement.domain.gateways.user.IUserRepository;
import finalTest.libraryManagement.domain.models.user.User;
import finalTest.libraryManagement.infrastructure.adapters.DBOs.userDBO.UserDBO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
@Getter
@Setter
public class UserAdapterRepository implements IUserRepository {

    private final IUserAdapterRepository iUserAdapterRepository;

    @Override
    public List<User> findAllUsers() {
        return iUserAdapterRepository
                .findAll()
                .stream()
                .map(UserDBO::toDomain)
                .toList();
    }

    @Override
    public User findUserById(Integer userId) {
        Optional<UserDBO> user = iUserAdapterRepository.findById(userId);
        if (user.isEmpty()) {
            throw new NullPointerException("The user with the id [" + userId + "] does not exists!");
        } else {
            return UserDBO.toDomain(user.get());
        }
    }

    @Override
    public User saveUser(User user) {
        UserDBO userDBO = UserDBO.fromDomain(user);
        return UserDBO.toDomain(iUserAdapterRepository.save(userDBO));
    }

    @Override
    public User updateUser(User user) {
        UserDBO userDBO = UserDBO.fromDomain(user);
        UserDBO userUpdated = iUserAdapterRepository.save(userDBO);
        return UserDBO.toDomain(userUpdated);
    }

    @Override
    public void deleteUserById(Integer userId) {
        Optional<UserDBO> user = iUserAdapterRepository.findById(userId);
        if (user.isEmpty()) {
            throw new NullPointerException("The user with the id [" + userId + "] does not exists!");
        } else {
            iUserAdapterRepository.deleteById(userId);
        }
    }

}
