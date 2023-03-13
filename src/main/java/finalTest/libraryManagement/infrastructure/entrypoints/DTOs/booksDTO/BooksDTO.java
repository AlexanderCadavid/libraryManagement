package finalTest.libraryManagement.infrastructure.entrypoints.DTOs.booksDTO;

import finalTest.libraryManagement.domain.models.books.Books;
import finalTest.libraryManagement.domain.models.books.attributes.Author;
import finalTest.libraryManagement.domain.models.books.attributes.Available;
import finalTest.libraryManagement.domain.models.books.attributes.BookId;
import finalTest.libraryManagement.domain.models.books.attributes.BookName;
import finalTest.libraryManagement.domain.models.books.attributes.Category;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BooksDTO {

    private Integer bookId;

    private String bookName;

    private String author;

    private String category;

    private Boolean available;


    public static Books toDomain(BooksDTO booksDTO) {
        return new Books(
                new BookId(booksDTO.getBookId()),
                new BookName(booksDTO.getBookName()),
                new Author(booksDTO.getAuthor()),
                new Category(booksDTO.getCategory()),
                new Available(booksDTO.getAvailable())
        );
    }

    public static BooksDTO fromDomain(Books books) {
        return new BooksDTO(
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
