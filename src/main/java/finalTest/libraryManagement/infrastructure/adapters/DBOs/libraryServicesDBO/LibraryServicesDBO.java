package finalTest.libraryManagement.infrastructure.adapters.DBOs.libraryServicesDBO;

import java.time.LocalDate;

import finalTest.libraryManagement.domain.models.books.Books;
import finalTest.libraryManagement.domain.models.books.attributes.Author;
import finalTest.libraryManagement.domain.models.books.attributes.Available;
import finalTest.libraryManagement.domain.models.books.attributes.BookId;
import finalTest.libraryManagement.domain.models.books.attributes.BookName;
import finalTest.libraryManagement.domain.models.books.attributes.Category;
import finalTest.libraryManagement.domain.models.libraryServices.LibraryServices;
import finalTest.libraryManagement.domain.models.libraryServices.attributes.DevolutionDate;
import finalTest.libraryManagement.domain.models.libraryServices.attributes.LoanDate;
import finalTest.libraryManagement.domain.models.libraryServices.attributes.PenaltyPrice;
import finalTest.libraryManagement.domain.models.libraryServices.attributes.ServiceId;
import finalTest.libraryManagement.domain.models.users.Users;
import finalTest.libraryManagement.domain.models.users.attributes.PenaltyFee;
import finalTest.libraryManagement.domain.models.users.attributes.UserId;
import finalTest.libraryManagement.domain.models.users.attributes.UserLastName;
import finalTest.libraryManagement.domain.models.users.attributes.UserName;
import finalTest.libraryManagement.infrastructure.adapters.DBOs.booksDBO.BooksDBO;
import finalTest.libraryManagement.infrastructure.adapters.DBOs.usersDBO.UsersDBO;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class LibraryServicesDBO {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer servicesId;

    private LocalDate devolutionDate;

    private LocalDate loanDate;

    private Double penaltyPrice;

    @OneToOne
    @JoinColumn(name = "userId")
    private UsersDBO usersDBO;

    @OneToOne
    @JoinColumn(name = "bookId")
    private BooksDBO booksDBO;

    public static LibraryServices toDomain(LibraryServicesDBO libraryServicesDBO) {
        return new LibraryServices(new ServiceId(libraryServicesDBO.getServicesId()),
                                   new DevolutionDate(libraryServicesDBO.getDevolutionDate()),
                                   new LoanDate(libraryServicesDBO.getLoanDate()),
                                   new PenaltyPrice(libraryServicesDBO.getPenaltyPrice()),
                                   new Users(
                                           new UserId(libraryServicesDBO
                                                              .getUsersDBO()
                                                              .getUserId()),
                                           new UserName(libraryServicesDBO
                                                                .getUsersDBO()
                                                                .getUserName()),
                                           new UserLastName(libraryServicesDBO
                                                                    .getUsersDBO()
                                                                    .getUserLastName()),
                                           new PenaltyFee(libraryServicesDBO
                                                                  .getUsersDBO()
                                                                  .getPenaltyFee())
                                   ),
                                   new Books(
                                           new BookId(libraryServicesDBO
                                                              .getBooksDBO()
                                                              .getBookId()),
                                           new BookName(libraryServicesDBO
                                                                .getBooksDBO()
                                                                .getBookName()),
                                           new Author(libraryServicesDBO
                                                              .getBooksDBO()
                                                              .getAuthor()),
                                           new Category(libraryServicesDBO
                                                                .getBooksDBO()
                                                                .getCategory()),
                                           new Available(libraryServicesDBO
                                                                 .getBooksDBO()
                                                                 .getAvailable())
                                   ));
    }

    public static LibraryServicesDBO fromDomain(LibraryServices libraryServices) {
        return new LibraryServicesDBO(
                libraryServices
                        .getServiceId()
                        .getServiceId(),
                libraryServices
                        .getDevolutionDate()
                        .getDevolutionDate(),
                libraryServices
                        .getLoanDate()
                        .getLoanDate(),
                libraryServices
                        .getPenaltyPrice()
                        .getPenaltyPrice(),
                new UsersDBO(
                        libraryServices
                                .getUsers()
                                .getUserId()
                                .getUserId(),
                        libraryServices
                                .getUsers()
                                .getUserName()
                                .getUserName(),
                        libraryServices
                                .getUsers()
                                .getUserLastName()
                                .getUserLastName(),
                        libraryServices
                                .getUsers()
                                .getPenaltyFee()
                                .getPenaltyFee()),
                new BooksDBO(
                        libraryServices
                                .getBooks()
                                .getBookId()
                                .getBookId(),
                        libraryServices
                                .getBooks()
                                .getBookName()
                                .getBookName(),
                        libraryServices
                                .getBooks()
                                .getAuthor()
                                .getAuthor(),
                        libraryServices
                                .getBooks()
                                .getCategory()
                                .getCategory(),
                        libraryServices
                                .getBooks()
                                .getAvailable()
                                .getAvailable()
                ));


    }
}
