package finalTest.libraryManagement.infrastructure.entrypoints.book;

import java.util.List;

import finalTest.libraryManagement.domain.UseCases.book.BookUseCase;
import finalTest.libraryManagement.domain.models.book.Book;
import finalTest.libraryManagement.infrastructure.entrypoints.DTOs.bookDTO.BookDTO;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/book")
@AllArgsConstructor
public class BooksEntryPoint {

    private final BookUseCase bookUseCase;

    @GetMapping
    public ResponseEntity<?> findAllBooks() {
        List<BookDTO> bookDTOList = bookUseCase
                .findAllBooks()
                .stream()
                .map(BookDTO::fromDomain)
                .toList();
        if (bookDTOList.isEmpty()) {
            return new ResponseEntity<>("The book list is empty", HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(bookDTOList, HttpStatus.FOUND);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findBookById(@PathVariable(name = "id") Integer bookId) {
        try {
            BookDTO bookDTO = BookDTO.fromDomain(bookUseCase.findBookById(bookId));
            return new ResponseEntity<>(bookDTO, HttpStatus.FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<?> saveBook(@RequestBody @Valid BookDTO bookDTO) {
        Book book = BookDTO.toDomain(bookDTO);
        BookDTO bookDTO1 = BookDTO.fromDomain(bookUseCase.saveBook(book));
        return new ResponseEntity<>(bookDTO1, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<?> updateBook(@RequestBody BookDTO bookDTO) {
        try {
            Book book = BookDTO.toDomain(bookDTO);
            BookDTO bookUpdated = BookDTO.fromDomain(bookUseCase.updateBook(book));
            return new ResponseEntity<>(bookUpdated, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public void deleteBookById(@PathVariable(name = "id") Integer bookId) {
        bookUseCase.deleteBookById(bookId);
    }


}
