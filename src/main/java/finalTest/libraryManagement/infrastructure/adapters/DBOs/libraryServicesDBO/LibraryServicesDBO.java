package finalTest.libraryManagement.infrastructure.adapters.DBOs.libraryServicesDBO;

import java.time.LocalDate;

import finalTest.libraryManagement.domain.models.book.attributes.Author;
import finalTest.libraryManagement.domain.models.book.attributes.Available;
import finalTest.libraryManagement.domain.models.book.attributes.BookId;
import finalTest.libraryManagement.domain.models.book.attributes.BookName;
import finalTest.libraryManagement.domain.models.book.attributes.Category;
import finalTest.libraryManagement.domain.models.libraryServices.LibraryServices;
import finalTest.libraryManagement.domain.models.libraryServices.attributes.DevolutionDate;
import finalTest.libraryManagement.domain.models.libraryServices.attributes.LoanDate;
import finalTest.libraryManagement.domain.models.libraryServices.attributes.PenaltyPrice;
import finalTest.libraryManagement.domain.models.user.User;
import finalTest.libraryManagement.domain.models.user.attributes.UserId;
import finalTest.libraryManagement.domain.models.user.attributes.UserLastName;
import finalTest.libraryManagement.domain.models.user.attributes.UserName;
import finalTest.libraryManagement.infrastructure.adapters.DBOs.bookDBO.BookDBO;
import finalTest.libraryManagement.infrastructure.adapters.DBOs.userDBO.UserDBO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "library-services")
public class LibraryServicesDBO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer servicesId;

    private LocalDate devolutionDate;

    private LocalDate loanDate;

    private Double penaltyPrice;

    @OneToOne
    @JoinColumn(name = "userId")
    private UserDBO userDBO;

    @OneToOne
    @JoinColumn(name = "bookId")
    private BookDBO bookDBO;

    public LibraryServicesDBO(LocalDate devolutionDate, LocalDate loanDate, Double penaltyPrice, UserDBO userDBO,
                              BookDBO bookDBO) {
        this.devolutionDate = devolutionDate;
        this.loanDate = loanDate;
        this.penaltyPrice = penaltyPrice;
        this.userDBO = userDBO;
        this.bookDBO = bookDBO;
    }

    public static LibraryServices toDomain(LibraryServicesDBO libraryServicesDBO) {
        return new LibraryServices(
                new DevolutionDate(libraryServicesDBO.getDevolutionDate()),
                new LoanDate(libraryServicesDBO.getLoanDate()),
                new PenaltyPrice(libraryServicesDBO.getPenaltyPrice()),
                new User(new UserId(libraryServicesDBO
                                            .getUserDBO()
                                            .getUserId()),
                         new UserName(libraryServicesDBO
                                              .getUserDBO()
                                              .getUserName()),
                         new UserLastName(libraryServicesDBO
                                                  .getUserDBO()
                                                  .getUserLastName())),
                new finalTest.libraryManagement.domain.models.book.Book(new BookId(libraryServicesDBO
                                            .getBookDBO()
                                            .getBookId()),
                                                                        new BookName(libraryServicesDBO
                                              .getBookDBO()
                                              .getBookName()),
                                                                        new Author(libraryServicesDBO
                                            .getBookDBO()
                                            .getAuthor()),
                                                                        new Category(libraryServicesDBO
                                              .getBookDBO()
                                              .getCategory()),
                                                                        new Available(libraryServicesDBO
                                               .getBookDBO()
                                               .getAvailable()))
        );

    }

    public static LibraryServicesDBO fromDomain(LibraryServices libraryServices) {
        return new LibraryServicesDBO(
                libraryServices
                        .getDevolutionDate()
                        .getDevolutionDate(),
                libraryServices
                        .getLoanDate()
                        .getLoanDate(),
                libraryServices
                        .getPenaltyPrice()
                        .getPenaltyPrice(),
                new UserDBO(libraryServices
                                    .getUser()
                                    .getUserId()
                                    .getUserId(),
                            libraryServices
                                    .getUser()
                                    .getUserName()
                                    .getUserName(),
                            libraryServices
                                    .getUser()
                                    .getUserLastName()
                                    .getUserLastName()),
                new BookDBO(libraryServices
                                    .getBook()
                                    .getBookId()
                                    .getBookId(),
                            libraryServices
                                    .getBook()
                                    .getBookName()
                                    .getBookName(),
                            libraryServices
                                    .getBook()
                                    .getAuthor()
                                    .getAuthor(),
                            libraryServices
                                    .getBook()
                                    .getCategory()
                                    .getCategory(),
                            libraryServices
                                    .getBook()
                                    .getAvailable()
                                    .getAvailable())
        );
    }
}
