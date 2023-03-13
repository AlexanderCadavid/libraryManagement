package finalTest.libraryManagement.config;

import finalTest.libraryManagement.domain.UseCases.books.BooksUseCase;
import finalTest.libraryManagement.domain.UseCases.libraryServices.LibraryServicesUseCase;
import finalTest.libraryManagement.domain.UseCases.users.UsersUseCase;
import finalTest.libraryManagement.domain.gateways.books.IBooksRepository;
import finalTest.libraryManagement.domain.gateways.libraryServices.ILibraryServicesRepository;
import finalTest.libraryManagement.domain.gateways.users.IUsersRepository;
import finalTest.libraryManagement.infrastructure.adapters.jpa.booksRepo.IBookAdapterRepository;
import finalTest.libraryManagement.infrastructure.adapters.jpa.libraryServicesRepo.ILibraryServiceAdapterRepository;
import finalTest.libraryManagement.infrastructure.adapters.jpa.usersRepo.IUserAdapterRepository;
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

    @Bean (name = "Books")
    public BooksUseCase booksUseCase(IBooksRepository iBooksRepository){
        return new BooksUseCase(iBooksRepository);
    }

    @Bean(name = "libraryServices")
    public LibraryServicesUseCase libraryServicesUseCase (ILibraryServicesRepository iLibraryServicesRepository){
        return new LibraryServicesUseCase(iLibraryServicesRepository);
    }

    @Bean (name = "users")
    public UsersUseCase usersUseCase (IUsersRepository iUsersRepository){
        return new UsersUseCase(iUsersRepository);
    }
}
