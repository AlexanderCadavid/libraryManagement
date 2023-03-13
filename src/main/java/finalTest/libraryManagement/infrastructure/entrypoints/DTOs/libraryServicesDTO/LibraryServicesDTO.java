package finalTest.libraryManagement.infrastructure.entrypoints.DTOs.libraryServicesDTO;

import java.time.LocalDate;

import finalTest.libraryManagement.domain.models.libraryServices.LibraryServices;
import finalTest.libraryManagement.domain.models.libraryServices.attributes.DevolutionDate;
import finalTest.libraryManagement.domain.models.libraryServices.attributes.LoanDate;
import finalTest.libraryManagement.domain.models.libraryServices.attributes.PenaltyPrice;
import finalTest.libraryManagement.domain.models.user.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class LibraryServicesDTO {

    private LocalDate devolutionDate;

    private LocalDate loanDate;

    private Double penaltyPrice;

    private User user;

    private finalTest.libraryManagement.domain.models.book.Book book;


    public static LibraryServices toDomain(LibraryServicesDTO libraryServicesDTO) {
        return new LibraryServices(
                new DevolutionDate(libraryServicesDTO.getDevolutionDate()),
                new LoanDate(libraryServicesDTO.getLoanDate()),
                new PenaltyPrice(libraryServicesDTO.getPenaltyPrice()),
                libraryServicesDTO.getUser(),
                libraryServicesDTO.getBook()

        );
    }

    public static LibraryServicesDTO fromDomain(LibraryServices libraryServices) {
        return new LibraryServicesDTO(
                libraryServices
                        .getDevolutionDate()
                        .getDevolutionDate(),
                libraryServices
                        .getLoanDate()
                        .getLoanDate(),
                libraryServices
                        .getPenaltyPrice()
                        .getPenaltyPrice(),
                libraryServices
                        .getUser(),
                libraryServices
                        .getBook()

        );
    }
}
