package finalTest.libraryManagement.infrastructure.adapters.books;

import finalTest.libraryManagement.infrastructure.adapters.jpa.booksRepo.BookAdapterRepository;
import finalTest.libraryManagement.infrastructure.adapters.jpa.booksRepo.IBookAdapterRepository;
import org.junit.jupiter.api.BeforeAll;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;


@DataJpaTest
public class BookAdapterRepositoryTest {

    @InjectMocks
    private BookAdapterRepository bookAdapterRepository;

    @Autowired
    IBookAdapterRepository iBookAdapterRepository;

    @BeforeAll
    void init() {
        bookAdapterRepository = new BookAdapterRepository(iBookAdapterRepository);
    }


}
