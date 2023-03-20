package finalTest.libraryManagement.infrastructure.entrypoints.DTOs.libraryServicesDTO;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;
import finalTest.libraryManagement.domain.models.book.attributes.BookId;
import finalTest.libraryManagement.domain.models.libraryServices.attributes.LoanDate;
import finalTest.libraryManagement.domain.models.libraryServices.loan.Loan;
import finalTest.libraryManagement.domain.models.user.attributes.UserId;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class LoanDTO {

    private Integer userId;

    private Integer bookId;

    private LocalDate loanDate;

    public static Loan toDomain(LoanDTO loanDTO) {
        return new Loan(new UserId(loanDTO
                                           .getUserId()),
                        new BookId(loanDTO
                                           .getBookId()),
                        new LoanDate(loanDTO
                                             .getLoanDate()));
    }

}
