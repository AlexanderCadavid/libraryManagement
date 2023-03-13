package finalTest.libraryManagement.domain.usecases.books;

import finalTest.libraryManagement.domain.UseCases.books.BooksUseCase;
import finalTest.libraryManagement.domain.gateways.books.IBooksRepository;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BooksUseCaseTest {

    @InjectMocks
    private BooksUseCase booksUseCase;

    @Mock
    private IBooksRepository iBooksRepository;
}
