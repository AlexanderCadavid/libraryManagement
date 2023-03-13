package finalTest.libraryManagement.infrastructure.adapters.jpa.libraryServicesRepo;

import finalTest.libraryManagement.infrastructure.adapters.DBOs.libraryServicesDBO.LibraryServicesDBO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ILibraryServiceAdapterRepository extends JpaRepository<LibraryServicesDBO, Integer> {
}
