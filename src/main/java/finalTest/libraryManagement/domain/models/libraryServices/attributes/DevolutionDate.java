package finalTest.libraryManagement.domain.models.libraryServices.attributes;

import java.time.LocalDate;

public class DevolutionDate {

    private final LocalDate devolutionDate;

    public DevolutionDate(LocalDate devolutionDate) {
        this.devolutionDate = devolutionDate;
    }

    public LocalDate getDevolutionDate() {
        return devolutionDate;
    }

}
