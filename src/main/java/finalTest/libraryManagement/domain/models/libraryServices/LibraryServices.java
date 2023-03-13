package finalTest.libraryManagement.domain.models.libraryServices;

import finalTest.libraryManagement.domain.models.books.Books;
import finalTest.libraryManagement.domain.models.libraryServices.attributes.DevolutionDate;
import finalTest.libraryManagement.domain.models.libraryServices.attributes.LoanDate;
import finalTest.libraryManagement.domain.models.libraryServices.attributes.PenaltyPrice;
import finalTest.libraryManagement.domain.models.libraryServices.attributes.ServiceId;
import finalTest.libraryManagement.domain.models.users.Users;

public class LibraryServices {

    private final ServiceId serviceId;

    private final DevolutionDate devolutionDate;

    private final LoanDate loanDate;

    private final PenaltyPrice penaltyPrice;

    private final Users users;

    private final Books books;

    public LibraryServices(ServiceId serviceId, DevolutionDate devolutionDate, LoanDate loanDate,
                           PenaltyPrice penaltyPrice, Users users,
                           Books books) {
        this.serviceId = serviceId;
        this.devolutionDate = devolutionDate;
        this.loanDate = loanDate;
        this.penaltyPrice = penaltyPrice;
        this.users = users;
        this.books = books;
    }

    public ServiceId getServiceId() {
        return serviceId;
    }

    public DevolutionDate getDevolutionDate() {
        return devolutionDate;
    }

    public LoanDate getLoanDate() {
        return loanDate;
    }

    public Users getUsers() {
        return users;
    }

    public Books getBooks() {
        return books;
    }

    public PenaltyPrice getPenaltyPrice() {
        return penaltyPrice;
    }
}
