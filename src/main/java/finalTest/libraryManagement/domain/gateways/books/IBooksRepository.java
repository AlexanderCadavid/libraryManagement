package finalTest.libraryManagement.domain.gateways.books;


import java.util.List;

import finalTest.libraryManagement.domain.models.books.Books;

public interface IBooksRepository {

    List<Books> findAllBooks();

    Books findBookById(Integer bookId);

    Books saveBook(Books books);

    Books updateBook(Books books);

    void deleteBookById(Integer bookId);
}
