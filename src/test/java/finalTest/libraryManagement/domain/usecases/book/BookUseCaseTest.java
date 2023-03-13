package finalTest.libraryManagement.domain.usecases.book;


import java.util.List;

import finalTest.libraryManagement.domain.UseCases.book.BookUseCase;
import finalTest.libraryManagement.domain.gateways.book.IBookRepository;
import finalTest.libraryManagement.domain.models.book.Book;
import finalTest.libraryManagement.infrastructure.entrypoints.DTOs.bookDTO.BookDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
public class BookUseCaseTest {

    @InjectMocks
    private BookUseCase bookUseCase;

    @Mock
    private IBookRepository iBookRepository;

    @Test
    @DisplayName("Save book test")
    void saveBook() {
        BookDTO bookDTO = new BookDTO(1, "book", "author", "category", true);
        Book book = BookDTO.toDomain(bookDTO);
        when(iBookRepository.saveBook((any(Book.class)))).thenReturn(book);
        BookDTO bookTest = BookDTO.fromDomain(bookUseCase.saveBook(book));
        assertNotNull(bookTest);
        assertEquals(bookTest.getBookName(), bookDTO.getBookName());
    }

    @Test
    @DisplayName("Update book")
    void updateBook() {
        BookDTO bookDTO = new BookDTO(1, "book", "author", "category", true);
        Book book = BookDTO.toDomain(bookDTO);
        when(iBookRepository.saveBook((any(Book.class)))).thenReturn(book);
        BookDTO bookUpdated = new BookDTO(1, "book", "author", "category", false);
        Book bookTest = BookDTO.toDomain(bookUpdated);
        assertNotNull(bookTest);
        assertEquals(false, bookTest
                .getAvailable()
                .getAvailable());
    }

    @Test
    @DisplayName("Find all books")
    void findAllBooks() {
        List<Book> books = bookUseCase.findAllBooks();
        when(iBookRepository.findAllBooks()).thenReturn(books);
        List<Book> bookList = bookUseCase.findAllBooks();
        assertNotNull(bookList);
        assertEquals(books, bookList);
    }

}
