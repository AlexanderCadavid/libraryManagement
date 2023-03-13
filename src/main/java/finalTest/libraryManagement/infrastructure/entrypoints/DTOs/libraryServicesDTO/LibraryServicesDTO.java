package finalTest.libraryManagement.infrastructure.entrypoints.DTOs.libraryServicesDTO;

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
import finalTest.libraryManagement.infrastructure.entrypoints.DTOs.booksDTO.BooksDTO;
import finalTest.libraryManagement.infrastructure.entrypoints.DTOs.usersDTO.UsersDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class LibraryServicesDTO {

    private Integer servicesId;

    private LocalDate devolutionDate;

    private LocalDate loanDate;

    private Double penaltyPrice;

    private UsersDTO usersDTO;

    private BooksDTO booksDTO;


    public static LibraryServices toDomain(LibraryServicesDTO libraryServicesDTO) {
        return new LibraryServices(new ServiceId(libraryServicesDTO.getServicesId()),
                                   new DevolutionDate(libraryServicesDTO.getDevolutionDate()),
                                   new LoanDate(libraryServicesDTO.getLoanDate()),
                                   new PenaltyPrice(libraryServicesDTO.getPenaltyPrice()),
                                   new Users(new UserId(libraryServicesDTO
                                                                .getUsersDTO()
                                                                .getUserId()),
                                             new UserName(libraryServicesDTO
                                                                  .getUsersDTO()
                                                                  .getUserName()),
                                             new UserLastName(libraryServicesDTO
                                                                      .getUsersDTO()
                                                                      .getUserLastName()),
                                             new PenaltyFee(libraryServicesDTO
                                                                    .getUsersDTO()
                                                                    .getPenaltyFee())),


                                   new Books(
                                           new BookId(libraryServicesDTO
                                                              .getBooksDTO()
                                                              .getBookId()),
                                           new BookName(libraryServicesDTO
                                                                .getBooksDTO()
                                                                .getBookName()),
                                           new Author(libraryServicesDTO
                                                              .getBooksDTO()
                                                              .getAuthor()),
                                           new Category(libraryServicesDTO
                                                                .getBooksDTO()
                                                                .getCategory()),
                                           new Available(libraryServicesDTO
                                                                 .getBooksDTO()
                                                                 .getAvailable())
                                   ));
    }

    public static LibraryServicesDTO fromDomain(LibraryServices libraryServices) {
        return new LibraryServicesDTO(
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
                new UsersDTO(libraryServices
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
                new BooksDTO(libraryServices
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
                                     .getAvailable())
        );
    }
}
