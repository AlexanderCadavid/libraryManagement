package finalTest.libraryManagement.infrastructure.entrypoints.DTOs.libraryServicesDTO;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;
import finalTest.libraryManagement.domain.models.libraryServices.attributes.DevolutionDate;
import finalTest.libraryManagement.domain.models.libraryServices.attributes.ServiceId;
import finalTest.libraryManagement.domain.models.libraryServices.bookDevolution.BookDevolution;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BookDevolutionDTO {


    private Integer serviceId;

    private LocalDate devolutionDate;

    public static BookDevolution toDomain(BookDevolutionDTO bookDevolutionDTO) {
        return new BookDevolution(new ServiceId(bookDevolutionDTO.getServiceId()),
                                  new DevolutionDate(bookDevolutionDTO.getDevolutionDate()));
    }

}
