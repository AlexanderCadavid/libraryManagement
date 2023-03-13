package finalTest.libraryManagement.domain.UseCases.libraryServices;

import java.util.List;

import finalTest.libraryManagement.domain.gateways.book.IBookRepository;
import finalTest.libraryManagement.domain.gateways.libraryServices.ILibraryServicesRepository;
import finalTest.libraryManagement.domain.gateways.user.IUserRepository;
import finalTest.libraryManagement.domain.models.book.attributes.Available;
import finalTest.libraryManagement.domain.models.libraryServices.LibraryServices;
import finalTest.libraryManagement.domain.models.libraryServices.attributes.DevolutionDate;
import finalTest.libraryManagement.domain.models.libraryServices.attributes.LoanDate;
import finalTest.libraryManagement.domain.models.libraryServices.attributes.PenaltyPrice;
import finalTest.libraryManagement.domain.models.libraryServices.bookDevolution.BookDevolution;
import finalTest.libraryManagement.domain.models.libraryServices.loan.Loan;
import finalTest.libraryManagement.domain.models.user.User;
import finalTest.libraryManagement.utilitys.functions.Functions;

public class LibraryServicesUseCase {

    private final ILibraryServicesRepository iLibraryServicesRepository;

    private final IBookRepository iBookRepository;

    private final IUserRepository iUserRepository;

    public LibraryServicesUseCase(ILibraryServicesRepository iLibraryServicesRepository,
                                  IBookRepository iBookRepository, IUserRepository iUserRepository) {
        this.iLibraryServicesRepository = iLibraryServicesRepository;
        this.iBookRepository = iBookRepository;
        this.iUserRepository = iUserRepository;
    }


    public LibraryServices saveService(Loan loan) {

        finalTest.libraryManagement.domain.models.book.Book bookFound = iBookRepository.findBookById(loan
                                                              .getBookId()
                                                              .getBookId());
        User userFound = iUserRepository.findUserById(loan
                                                              .getUserId()
                                                              .getUserId());

        LibraryServices newLoan = new LibraryServices(new DevolutionDate(null),
                                                      new LoanDate(loan
                                                                           .getLoanDate()
                                                                           .getLoanDate()),
                                                      new PenaltyPrice(0.0),
                                                      userFound,
                                                      new finalTest.libraryManagement.domain.models.book.Book(bookFound.getBookId(),
                                                                                                              bookFound.getBookName(),
                                                                                                              bookFound.getAuthor(),
                                                                                                              bookFound.getCategory(),
                                                                                                              new Available(Boolean.FALSE)));
        iBookRepository.saveBook(new finalTest.libraryManagement.domain.models.book.Book(bookFound.getBookId(),
                                                                                         bookFound.getBookName(),
                                                                                         bookFound.getAuthor(),
                                                                                         bookFound.getCategory(),
                                                                                         new Available(Boolean.FALSE)));

        return iLibraryServicesRepository.saveService(newLoan);

    }

    public List<LibraryServices> findLoans() {
        return iLibraryServicesRepository.findLoans();
    }

    public LibraryServices findServiceById(Integer serviceId) throws Exception {
        LibraryServices libraryServices = iLibraryServicesRepository.findServiceById(serviceId);
        if (libraryServices.getServiceId() == null) {
            throw new Exception("The service with id [" + libraryServices
                    .getServiceId()
                    .getServiceId() + "] does" +
                                " " +
                                "not exists!");
        } else {
            return libraryServices;
        }
    }

    public LibraryServices updateService(BookDevolution bookDevolution) {
        LibraryServices libraryServiceFound =
                iLibraryServicesRepository.findServiceById(bookDevolution
                                                                   .getServiceId()
                                                                   .getServiceId());

        LibraryServices devolutionService =
                new LibraryServices(new DevolutionDate(bookDevolution
                                                               .getDevolutionDate()
                                                               .getDevolutionDate()),
                                    libraryServiceFound.getLoanDate(),
                                    new PenaltyPrice(Functions.penaltyPrice(bookDevolution
                                                                                    .getDevolutionDate()
                                                                                    .getDevolutionDate(),
                                                                            libraryServiceFound
                                                                                    .getLoanDate()
                                                                                    .getLoanDate())),
                                    libraryServiceFound.getUser(),
                                    new finalTest.libraryManagement.domain.models.book.Book(libraryServiceFound
                                                     .getBook()
                                                     .getBookId(),
                                                                                            libraryServiceFound
                                                     .getBook()
                                                     .getBookName(),
                                                                                            libraryServiceFound
                                                     .getBook()
                                                     .getAuthor(),
                                                                                            libraryServiceFound
                                                     .getBook()
                                                     .getCategory(),
                                                                                            new Available(Boolean.TRUE)));

        return iLibraryServicesRepository.saveService(devolutionService);

    }

    public List<LibraryServices> penaltyList() {
        List<LibraryServices> list = iLibraryServicesRepository.penaltyList();
        return Functions.penaltyPriceList(list);
    }
}
