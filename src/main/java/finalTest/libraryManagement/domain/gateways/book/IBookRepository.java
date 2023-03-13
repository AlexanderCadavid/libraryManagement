package finalTest.libraryManagement.domain.gateways.book;


import java.util.List;

import finalTest.libraryManagement.domain.models.book.Book;

public interface IBookRepository {

    List<Book> findAllBooks();

    Book findBookById(Integer bookId);

    Book saveBook(Book book);

    Book updateBook(Book book);

    void deleteBookById(Integer bookId);
}
