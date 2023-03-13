package finalTest.libraryManagement.config;

import finalTest.libraryManagement.domain.UseCases.book.BookUseCase;
import finalTest.libraryManagement.domain.UseCases.libraryServices.LibraryServicesUseCase;
import finalTest.libraryManagement.domain.UseCases.user.UserUseCase;
import finalTest.libraryManagement.domain.gateways.book.IBookRepository;
import finalTest.libraryManagement.domain.gateways.libraryServices.ILibraryServicesRepository;
import finalTest.libraryManagement.domain.gateways.user.IUserRepository;
import finalTest.libraryManagement.infrastructure.adapters.jpa.booksRepo.IBookAdapterRepository;
import finalTest.libraryManagement.infrastructure.adapters.jpa.libraryServicesRepo.ILibraryServiceAdapterRepository;
import finalTest.libraryManagement.infrastructure.adapters.jpa.userRepo.IUserAdapterRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Beans {

    private final IBookAdapterRepository iBookAdapterRepository;

    private final ILibraryServiceAdapterRepository iLibraryServiceAdapterRepository;

    private final IUserAdapterRepository iUserAdapterRepository;

    public Beans(IBookAdapterRepository iBookAdapterRepository,
                 ILibraryServiceAdapterRepository iLibraryServiceAdapterRepository,
                 IUserAdapterRepository iUserAdapterRepository) {
        this.iBookAdapterRepository = iBookAdapterRepository;
        this.iLibraryServiceAdapterRepository = iLibraryServiceAdapterRepository;
        this.iUserAdapterRepository = iUserAdapterRepository;
    }

    @Bean(name = "User")
    public BookUseCase booksUseCase(IBookRepository iBookRepository) {
        return new BookUseCase(iBookRepository);
    }

    @Bean(name = "libraryServices")
    public LibraryServicesUseCase libraryServicesUseCase(ILibraryServicesRepository iLibraryServicesRepository,
                                                         IBookRepository iBookRepository,
                                                         IUserRepository iUserRepository) {
        return new LibraryServicesUseCase(iLibraryServicesRepository, iBookRepository, iUserRepository);
    }

    @Bean(name = "user")
    public UserUseCase usersUseCase(IUserRepository iUserRepository) {
        return new UserUseCase(iUserRepository);
    }
}
