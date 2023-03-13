package finalTest.libraryManagement.infrastructure.adapters.DBOs.bookDBO;

import finalTest.libraryManagement.domain.models.book.Book;
import finalTest.libraryManagement.domain.models.book.attributes.Author;
import finalTest.libraryManagement.domain.models.book.attributes.Available;
import finalTest.libraryManagement.domain.models.book.attributes.BookId;
import finalTest.libraryManagement.domain.models.book.attributes.BookName;
import finalTest.libraryManagement.domain.models.book.attributes.Category;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "book")
public class BookDBO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer bookId;

    private String bookName;

    private String author;

    private String category;

    private Boolean available;


    public static Book toDomain(BookDBO bookDBO) {
        return new Book(
                new BookId(bookDBO.getBookId()),
                new BookName(bookDBO.getBookName()),
                new Author(bookDBO.getAuthor()),
                new Category(bookDBO.getCategory()),
                new Available(bookDBO.getAvailable())
        );
    }

    public static BookDBO fromDomain(Book book) {
        return new BookDBO(
                book
                        .getBookId()
                        .getBookId(),
                book
                        .getBookName()
                        .getBookName(),
                book
                        .getAuthor()
                        .getAuthor(),
                book
                        .getCategory()
                        .getCategory(),
                book
                        .getAvailable()
                        .getAvailable()
        );
    }
}
