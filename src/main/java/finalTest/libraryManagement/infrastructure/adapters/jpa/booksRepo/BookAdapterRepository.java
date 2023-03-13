package finalTest.libraryManagement.infrastructure.adapters.jpa.booksRepo;

import java.util.List;
import java.util.Optional;

import finalTest.libraryManagement.domain.gateways.books.IBooksRepository;
import finalTest.libraryManagement.domain.models.books.Books;
import finalTest.libraryManagement.infrastructure.adapters.DBOs.booksDBO.BooksDBO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
@Getter
@Setter
public class BookAdapterRepository implements IBooksRepository {

    private final IBookAdapterRepository iBookAdapterRepository;


    @Override
    public List<Books> findAllBooks() {
        return iBookAdapterRepository
                .findAll()
                .stream()
                .map(BooksDBO::toDomain)
                .toList();
    }

    @Override
    public Books findBookById(Integer bookId) {
        Optional<BooksDBO> book = iBookAdapterRepository.findById(bookId);
        if (book.isEmpty()) {
            throw new NullPointerException("The book with the id [" + bookId + "] does not exist");
        } else {
            return BooksDBO.toDomain(book.get());
        }
    }

    @Override
    public Books saveBook(Books books) {
        BooksDBO booksDBO = BooksDBO.fromDomain(books);
        return BooksDBO.toDomain(iBookAdapterRepository.save(booksDBO));
    }

    @Override
    public Books updateBook(Books books) {
        BooksDBO booksDBO = BooksDBO.fromDomain(books);
        BooksDBO bookUpdated = iBookAdapterRepository.save(booksDBO);
        return BooksDBO.toDomain(bookUpdated);
    }

    @Override
    public void deleteBookById(Integer bookId) {
        Optional<BooksDBO> books = iBookAdapterRepository.findById(bookId);
        if (books.isEmpty()) {
            throw new NullPointerException("The book with id [" + bookId + "] does not exists!");
        } else {
            iBookAdapterRepository.deleteById(bookId);
        }
    }
}
