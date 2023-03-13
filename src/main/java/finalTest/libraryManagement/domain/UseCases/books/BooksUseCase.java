package finalTest.libraryManagement.domain.UseCases.books;

import java.util.List;

import finalTest.libraryManagement.domain.gateways.books.IBooksRepository;
import finalTest.libraryManagement.domain.models.books.Books;
import finalTest.libraryManagement.domain.models.books.attributes.Author;
import finalTest.libraryManagement.domain.models.books.attributes.Available;
import finalTest.libraryManagement.domain.models.books.attributes.BookId;
import finalTest.libraryManagement.domain.models.books.attributes.BookName;
import finalTest.libraryManagement.domain.models.books.attributes.Category;

public class BooksUseCase {

    private final IBooksRepository iBooksRepository;

    public BooksUseCase(IBooksRepository iBooksRepository) {
        this.iBooksRepository = iBooksRepository;
    }

    public List<Books> findAllBooks() {
        return iBooksRepository.findAllBooks();
    }

    public Books findBookById(Integer bookId) throws Exception {
        Books book = iBooksRepository.findBookById(bookId);
        if (book == null) {
            throw new Exception("The book with id [" + bookId + "] does not exists!");
        } else {
            return book;
        }
    }

    public Books saveBook(Books books) {
        return iBooksRepository.saveBook(books);
    }

    public Books updateBook(Books books) {
        Books book = iBooksRepository.findBookById(books
                                                           .getBookId()
                                                           .getBookId());
        Books bookUpdated = new Books(new BookId(book.getBookId().getBookId()),
                                      new BookName(books.getBookName().getBookName()),
                                      new Author(books.getAuthor().getAuthor()),
                                      new Category(books.getCategory().getCategory()),
                                      new Available(books.getAvailable().getAvailable()));
        return iBooksRepository.updateBook(bookUpdated);
    }

    public void deleteBookById (Integer bookId){
        iBooksRepository.deleteBookById(bookId);
    }
}
