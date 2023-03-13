package finalTest.libraryManagement.domain.models.libraryServices;

import finalTest.libraryManagement.domain.models.libraryServices.attributes.DevolutionDate;
import finalTest.libraryManagement.domain.models.libraryServices.attributes.LoanDate;
import finalTest.libraryManagement.domain.models.libraryServices.attributes.PenaltyPrice;
import finalTest.libraryManagement.domain.models.libraryServices.attributes.ServiceId;
import finalTest.libraryManagement.domain.models.user.User;

public class LibraryServices {

    private ServiceId serviceId;

    private  DevolutionDate devolutionDate;

    private final LoanDate loanDate;

    private  PenaltyPrice penaltyPrice;

    private User user;

    private finalTest.libraryManagement.domain.models.book.Book book;

    public LibraryServices(DevolutionDate devolutionDate, LoanDate loanDate,
                           PenaltyPrice penaltyPrice, User user, finalTest.libraryManagement.domain.models.book.Book book) {
        this.devolutionDate = devolutionDate;
        this.loanDate = loanDate;
        this.penaltyPrice = penaltyPrice;
        this.user = user;
        this.book = book;
    }

    public LibraryServices(LoanDate loanDate, User user, finalTest.libraryManagement.domain.models.book.Book book) {
        this.loanDate = loanDate;
        this.user = user;
        this.book = book;
    }


    public DevolutionDate getDevolutionDate() {
        return devolutionDate;
    }

    public LoanDate getLoanDate() {
        return loanDate;
    }

    public PenaltyPrice getPenaltyPrice() {
        return penaltyPrice;
    }

    public User getUser() {
        return user;
    }

    public finalTest.libraryManagement.domain.models.book.Book getBook() {
        return book;
    }

    public ServiceId getServiceId() {
        return serviceId;
    }

}

