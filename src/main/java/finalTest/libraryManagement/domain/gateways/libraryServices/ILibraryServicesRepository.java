package finalTest.libraryManagement.domain.gateways.libraryServices;

import java.util.List;

import finalTest.libraryManagement.domain.models.libraryServices.LibraryServices;

public interface ILibraryServicesRepository {

    LibraryServices saveService(LibraryServices libraryServices);

    List<LibraryServices> findLoans();

    LibraryServices findServiceById(Integer serviceId);

    List<LibraryServices> penaltyList();

}

