package finalTest.libraryManagement.domain.UseCases.book;

import java.util.List;

import finalTest.libraryManagement.domain.gateways.book.IBookRepository;
import finalTest.libraryManagement.domain.models.book.Book;
import finalTest.libraryManagement.domain.models.book.attributes.Author;
import finalTest.libraryManagement.domain.models.book.attributes.Available;
import finalTest.libraryManagement.domain.models.book.attributes.BookId;
import finalTest.libraryManagement.domain.models.book.attributes.BookName;
import finalTest.libraryManagement.domain.models.book.attributes.Category;

public class BookUseCase {

    private final IBookRepository iBookRepository;

    public BookUseCase(IBookRepository iBookRepository) {
        this.iBookRepository = iBookRepository;
    }

    public List<Book> findAllBooks() {
        return iBookRepository.findAllBooks();
    }

    public Book findBookById(Integer bookId) throws Exception {
        Book book = iBookRepository.findBookById(bookId);
        if (book == null) {
            throw new Exception("The book with id [" + bookId + "] does not exists!");
        } else {
            return book;
        }
    }

    public Book saveBook(Book book) {
        return iBookRepository.saveBook(book);
    }

    public Book updateBook(Book books) {
        Book book = iBookRepository.findBookById(books
                                                         .getBookId()
                                                         .getBookId());
        Book bookUpdated = new Book(new BookId(book
                                                       .getBookId()
                                                       .getBookId()),
                                    new BookName(books
                                                         .getBookName()
                                                         .getBookName()),
                                    new Author(books
                                                       .getAuthor()
                                                       .getAuthor()),
                                    new Category(books
                                                         .getCategory()
                                                         .getCategory()),
                                    new Available(books
                                                          .getAvailable()
                                                          .getAvailable()));
        return iBookRepository.updateBook(bookUpdated);
    }

    public void deleteBookById(Integer bookId) {
        iBookRepository.deleteBookById(bookId);
    }
}
