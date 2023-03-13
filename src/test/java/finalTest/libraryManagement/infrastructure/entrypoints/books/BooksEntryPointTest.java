package finalTest.libraryManagement.infrastructure.entrypoints.books;

import finalTest.libraryManagement.domain.models.books.Books;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

@WebMvcTest(Books.class)
public class BooksEntryPointTest {
}
