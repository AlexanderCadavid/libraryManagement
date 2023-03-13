package finalTest.libraryManagement.infrastructure.adapters.jpa.booksRepo;

import java.util.List;
import java.util.Optional;

import finalTest.libraryManagement.domain.gateways.book.IBookRepository;
import finalTest.libraryManagement.domain.models.book.Book;
import finalTest.libraryManagement.infrastructure.adapters.DBOs.bookDBO.BookDBO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
@Getter
@Setter
public class BookAdapterRepository implements IBookRepository {

    private final IBookAdapterRepository iBookAdapterRepository;


    @Override
    public List<Book> findAllBooks() {
        return iBookAdapterRepository
                .findAll()
                .stream()
                .map(BookDBO::toDomain)
                .toList();
    }

    @Override
    public Book findBookById(Integer bookId) {
        Optional<BookDBO> book = iBookAdapterRepository.findById(bookId);
        if (book.isEmpty()) {
            throw new NullPointerException("The book with the id [" + bookId + "] does not exist!!");
        } else {
            return BookDBO.toDomain(book.get());
        }
    }

    @Override
    public Book saveBook(Book book) {
        BookDBO bookDBO = BookDBO.fromDomain(book);
        return BookDBO.toDomain(iBookAdapterRepository.save(bookDBO));
    }

    @Override
    public Book updateBook(Book book) {
        BookDBO bookDBO = BookDBO.fromDomain(book);
        BookDBO bookUpdated = iBookAdapterRepository.save(bookDBO);
        return BookDBO.toDomain(bookUpdated);
    }

    @Override
    public void deleteBookById(Integer bookId) {
        Optional<BookDBO> books = iBookAdapterRepository.findById(bookId);
        if (books.isEmpty()) {
            throw new NullPointerException("The book with id [" + bookId + "] does not exists!");
        } else {
            iBookAdapterRepository.deleteById(bookId);
        }
    }
}
