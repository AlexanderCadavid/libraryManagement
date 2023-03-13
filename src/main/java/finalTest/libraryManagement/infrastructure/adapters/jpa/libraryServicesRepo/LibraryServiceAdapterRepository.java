package finalTest.libraryManagement.infrastructure.adapters.jpa.libraryServicesRepo;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import finalTest.libraryManagement.domain.gateways.libraryServices.ILibraryServicesRepository;
import finalTest.libraryManagement.domain.models.libraryServices.LibraryServices;
import finalTest.libraryManagement.infrastructure.adapters.DBOs.libraryServicesDBO.LibraryServicesDBO;
import finalTest.libraryManagement.infrastructure.adapters.jpa.booksRepo.IBookAdapterRepository;
import finalTest.libraryManagement.infrastructure.adapters.jpa.userRepo.IUserAdapterRepository;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
@Getter
@Setter
public class LibraryServiceAdapterRepository implements ILibraryServicesRepository {

    private final IUserAdapterRepository iUserAdapterRepository;

    private final IBookAdapterRepository iBookAdapterRepository;

    private final ILibraryServiceAdapterRepository iLibraryServiceAdapterRepository;

    @Override
    public LibraryServices saveService(LibraryServices libraryServices) {
        LibraryServicesDBO libraryServicesDBO = LibraryServicesDBO.fromDomain(libraryServices);
        return LibraryServicesDBO.toDomain(iLibraryServiceAdapterRepository.save(libraryServicesDBO));
    }

    @Override
    public List<LibraryServices> findLoans() {
        return iLibraryServiceAdapterRepository
                .findAll()
                .stream()
                .map(LibraryServicesDBO::toDomain)
                .toList();
    }

    @Override
    public LibraryServices findServiceById(Integer serviceId) {
        Optional<LibraryServicesDBO> serviceFounded = iLibraryServiceAdapterRepository.findById(serviceId);
        if (serviceFounded.isEmpty()) {
            throw new NullPointerException("The book with the id [" + serviceFounded + "] does not exist!!");
        } else {
            return LibraryServicesDBO.toDomain(serviceFounded.get());
        }
    }

    @Override
    public List<LibraryServices> penaltyList() {
        return (iLibraryServiceAdapterRepository
                                                 .findAll()
                                                 .stream()
                                                 .map(LibraryServicesDBO::toDomain)
                                                 .toList());
    }
}
