package finalTest.libraryManagement.infrastructure.adapters.DBOs.booksDBO;

import finalTest.libraryManagement.domain.models.books.Books;
import finalTest.libraryManagement.domain.models.books.attributes.Author;
import finalTest.libraryManagement.domain.models.books.attributes.Available;
import finalTest.libraryManagement.domain.models.books.attributes.BookId;
import finalTest.libraryManagement.domain.models.books.attributes.BookName;
import finalTest.libraryManagement.domain.models.books.attributes.Category;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BooksDBO {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer bookId;

    private String bookName;

    private String author;

    private String category;

    private Boolean available;


    public static Books toDomain(BooksDBO booksDBO) {
        return new Books(
                new BookId(booksDBO.getBookId()),
                new BookName(booksDBO.getBookName()),
                new Author(booksDBO.getAuthor()),
                new Category(booksDBO.getCategory()),
                new Available(booksDBO.getAvailable())
        );
    }

    public static BooksDBO fromDomain(Books books) {
        return new BooksDBO(
                books
                        .getBookId()
                        .getBookId(),
                books
                        .getBookName()
                        .getBookName(),
                books
                        .getAuthor()
                        .getAuthor(),
                books
                        .getCategory()
                        .getCategory(),
                books
                        .getAvailable()
                        .getAvailable()
        );
    }
}
