package finalTest.libraryManagement.infrastructure.entrypoints.books;

import finalTest.libraryManagement.domain.UseCases.books.BooksUseCase;
import finalTest.libraryManagement.domain.models.books.Books;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(Books.class)
public class BooksEntryPointTest {

    @MockBean
    private BooksUseCase booksUseCase;

    @Autowired
    private MockMvc mockMvc;

}
