package finalTest.libraryManagement.infrastructure.entrypoints.books;

import java.util.List;

import finalTest.libraryManagement.domain.UseCases.books.BooksUseCase;
import finalTest.libraryManagement.domain.models.books.Books;
import finalTest.libraryManagement.infrastructure.entrypoints.DTOs.booksDTO.BooksDTO;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/books")
@AllArgsConstructor
public class BooksEntryPoint {

    private final BooksUseCase booksUseCase;

    @GetMapping
    public ResponseEntity<?> findAllBooks() {
        List<Books> books = booksUseCase.findAllBooks();
        if (books.isEmpty()) {
            return new ResponseEntity<>(books, HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(books, HttpStatus.FOUND);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findBookById(@PathVariable(name = "id") Integer bookId) {
        try {
            BooksDTO booksDTO = BooksDTO.fromDomain(booksUseCase.findBookById(bookId));
            return new ResponseEntity<>(booksDTO, HttpStatus.FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<?> saveBook(@RequestBody @Valid BooksDTO booksDTO) {
        Books book = BooksDTO.toDomain(booksDTO);
        BooksDTO bookDTO1 = BooksDTO.fromDomain(booksUseCase.saveBook(book));
        return new ResponseEntity<>(bookDTO1, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<?> updateBook(@RequestBody BooksDTO booksDTO) {
        try {
            Books book = BooksDTO.toDomain(booksDTO);
            BooksDTO bookUpdated = BooksDTO.fromDomain(booksUseCase.updateBook(book));
            return new ResponseEntity<>(bookUpdated, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public void deleteBookById(@PathVariable(name = "id") Integer bookId) {
        booksUseCase.deleteBookById(bookId);
    }


}
