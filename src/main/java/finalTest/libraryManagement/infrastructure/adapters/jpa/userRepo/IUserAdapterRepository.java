package finalTest.libraryManagement.infrastructure.adapters.jpa.userRepo;

import finalTest.libraryManagement.infrastructure.adapters.DBOs.userDBO.UserDBO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserAdapterRepository extends JpaRepository<UserDBO, Integer> {
}
