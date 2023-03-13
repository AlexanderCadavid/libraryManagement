package finalTest.libraryManagement.domain.models.books;

import finalTest.libraryManagement.domain.models.books.attributes.Author;
import finalTest.libraryManagement.domain.models.books.attributes.Available;
import finalTest.libraryManagement.domain.models.books.attributes.BookId;
import finalTest.libraryManagement.domain.models.books.attributes.BookName;
import finalTest.libraryManagement.domain.models.books.attributes.Category;

public class Books {

    private final BookId bookId;

    private final BookName bookName;

    private final Author author;


    private final Category category;

    private final Available available;

    public Books(BookId bookId, BookName bookName, Author author, Category category, Available available) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.author = author;
        this.category = category;
        this.available = available;
    }

    public BookId getBookId() {
        return bookId;
    }


    public BookName getBookName() {
        return bookName;
    }

    public Author getAuthor() {
        return author;
    }

    public Category getCategory() {
        return category;
    }

    public Available getAvailable() {
        return available;
    }
}
