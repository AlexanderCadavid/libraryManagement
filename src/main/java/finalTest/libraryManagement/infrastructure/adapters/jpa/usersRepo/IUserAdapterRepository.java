package finalTest.libraryManagement.infrastructure.adapters.jpa.usersRepo;

import finalTest.libraryManagement.infrastructure.adapters.DBOs.usersDBO.UsersDBO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserAdapterRepository extends JpaRepository <UsersDBO, Integer> {
}
