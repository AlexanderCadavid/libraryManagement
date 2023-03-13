package finalTest.libraryManagement.infrastructure.entrypoints.DTOs.bookDTO;

import finalTest.libraryManagement.domain.models.book.Book;
import finalTest.libraryManagement.domain.models.book.attributes.Author;
import finalTest.libraryManagement.domain.models.book.attributes.Available;
import finalTest.libraryManagement.domain.models.book.attributes.BookId;
import finalTest.libraryManagement.domain.models.book.attributes.BookName;
import finalTest.libraryManagement.domain.models.book.attributes.Category;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BookDTO {

    private Integer bookId;

    @NotBlank
    @Size(max = 50,
          message = "The book name cannot contain more than 50 characters ")
    @Pattern(regexp = "^[A-z\\s]+(?<!\\s)$",
             message = "The book name cannot contain special characters")
    private String bookName;

    @NotBlank
    @Size(max = 30,
          message = "The book name cannot contain more than 30 characters ")
    @Pattern(regexp = "^[A-z\\s]+(?<!\\s)$",
             message = "The book name cannot contain special characters")
    private String author;

    @NotBlank
    @Size(max = 20,
          message = "The book name cannot contain more than 20 characters ")
    @Pattern(regexp = "^[A-z\\s]+(?<!\\s)$",
             message = "The book name cannot contain special characters")
    private String category;

    @NotNull
    private Boolean available;


    public static Book toDomain(BookDTO bookDTO) {
        return new Book(
                new BookId(bookDTO.getBookId()),
                new BookName(bookDTO.getBookName()),
                new Author(bookDTO.getAuthor()),
                new Category(bookDTO.getCategory()),
                new Available(bookDTO.getAvailable())
        );
    }

    public static BookDTO fromDomain(Book book) {
        return new BookDTO(
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
