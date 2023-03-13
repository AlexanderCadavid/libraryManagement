package finalTest.libraryManagement.domain.models.libraryServices.attributes;

import java.time.LocalDate;

public class LoanDate {

    private final LocalDate loanDate;

    public LoanDate(LocalDate loanDate) {
        this.loanDate = loanDate;
    }

    public LocalDate getLoanDate() {
        return loanDate;
    }
}
