package finalTest.libraryManagement.infrastructure.adapters.jpa.libraryServicesRepo;

import finalTest.libraryManagement.domain.gateways.libraryServices.ILibraryServicesRepository;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
@Getter
@Setter
public class LibraryServiceAdapterRepository implements ILibraryServicesRepository {
}
