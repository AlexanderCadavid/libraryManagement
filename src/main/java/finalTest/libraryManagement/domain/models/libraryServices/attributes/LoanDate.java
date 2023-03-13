package finalTest.libraryManagement.domain.models.libraryServices.attributes;

import java.time.LocalDate;

import org.springframework.util.Assert;

public class LoanDate {

    private final LocalDate loanDate;

    public LoanDate(LocalDate loanDate) {
        Assert.notNull(loanDate, "The loan date cannot be null");
        this.loanDate = loanDate;
    }

    public LocalDate getLoanDate() {
        return loanDate;
    }
}
