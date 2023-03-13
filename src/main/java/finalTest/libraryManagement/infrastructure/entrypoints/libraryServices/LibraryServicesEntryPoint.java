package finalTest.libraryManagement.infrastructure.entrypoints.libraryServices;

import java.util.List;

import finalTest.libraryManagement.domain.UseCases.libraryServices.LibraryServicesUseCase;
import finalTest.libraryManagement.domain.models.libraryServices.LibraryServices;
import finalTest.libraryManagement.domain.models.libraryServices.bookDevolution.BookDevolution;
import finalTest.libraryManagement.domain.models.libraryServices.loan.Loan;
import finalTest.libraryManagement.infrastructure.entrypoints.DTOs.libraryServicesDTO.BookDevolutionDTO;
import finalTest.libraryManagement.infrastructure.entrypoints.DTOs.libraryServicesDTO.LibraryServicesDTO;
import finalTest.libraryManagement.infrastructure.entrypoints.DTOs.libraryServicesDTO.LoanDTO;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/library-services")
@AllArgsConstructor
public class LibraryServicesEntryPoint {

    private final LibraryServicesUseCase libraryServicesUseCase;


    @PostMapping("/loan")
    public ResponseEntity<?> makeALoan(@RequestBody @Valid LoanDTO loanDTO) {

        Loan loan = LoanDTO.toDomain(loanDTO);
        LibraryServicesDTO libraryServicesDTO1 =
                LibraryServicesDTO.fromDomain(libraryServicesUseCase.saveService(loan));
        return new ResponseEntity<>(libraryServicesDTO1, HttpStatus.CREATED);
    }

    @GetMapping("/loans")
    public ResponseEntity<?> findLoans() {
        List<LibraryServicesDTO> loanList =
                libraryServicesUseCase
                        .findLoans()
                        .stream()
                        .map(LibraryServicesDTO::fromDomain)
                        .toList();
        if (loanList.isEmpty()) {
            return new ResponseEntity<>("The loan list is empty", HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(loanList, HttpStatus.FOUND);
        }
    }

    @PutMapping("/devolution")
    public ResponseEntity<?> bookDevolution(@RequestBody BookDevolutionDTO bookDevolutionDTO) {
        try {
            BookDevolution bookDevolution1 = BookDevolutionDTO.toDomain(bookDevolutionDTO);
            LibraryServicesDTO devolutionDTO =
                    LibraryServicesDTO.fromDomain(libraryServicesUseCase.updateService(bookDevolution1));
            return new ResponseEntity<>(devolutionDTO, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("The service with id [" + bookDevolutionDTO.getServiceId() + "] does not " +
                                        "exist! ", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findServiceById(@PathVariable(name = "id") Integer serviceId) {
        try {
            LibraryServicesDTO libraryServicesDTO =
                    LibraryServicesDTO.fromDomain(libraryServicesUseCase.findServiceById(serviceId));
            return new ResponseEntity<>(libraryServicesDTO, HttpStatus.FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/penalty-list")
    public ResponseEntity<?> penaltyList() {
        List<LibraryServices> penaltyListFound =
                libraryServicesUseCase
                        .penaltyList()
                        .stream()
                        .toList();
        if (penaltyListFound.isEmpty()) {
            return new ResponseEntity<>("The penalty list is empty", HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(penaltyListFound, HttpStatus.FOUND);
        }
    }

}
