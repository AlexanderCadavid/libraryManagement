package finalTest.libraryManagement.domain.models.libraryServices.loan;

import finalTest.libraryManagement.domain.models.book.attributes.BookId;
import finalTest.libraryManagement.domain.models.libraryServices.attributes.LoanDate;
import finalTest.libraryManagement.domain.models.user.attributes.UserId;

public class Loan {

    private UserId userId;

    private BookId bookId;

    private LoanDate loanDate;

    public Loan(UserId userId, BookId bookId, LoanDate loanDate) {
        this.userId = userId;
        this.bookId = bookId;
        this.loanDate = loanDate;
    }

    public UserId getUserId() {
        return userId;
    }

    public BookId getBookId() {
        return bookId;
    }

    public LoanDate getLoanDate() {
        return loanDate;
    }
}
