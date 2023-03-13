package finalTest.libraryManagement.domain.models.book;

import finalTest.libraryManagement.domain.models.book.attributes.Author;
import finalTest.libraryManagement.domain.models.book.attributes.Available;
import finalTest.libraryManagement.domain.models.book.attributes.BookId;
import finalTest.libraryManagement.domain.models.book.attributes.BookName;
import finalTest.libraryManagement.domain.models.book.attributes.Category;

public class Book {

    private final BookId bookId;

    private final BookName bookName;

    private final Author author;

    private final Category category;

    private final Available available;

    public Book(BookId bookId, BookName bookName, Author author, Category category, Available available) {
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
