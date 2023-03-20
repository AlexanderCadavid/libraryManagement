package finalTest.libraryManagement.domain.models.libraryServices.bookDevolution;

import java.time.LocalDate;

import finalTest.libraryManagement.domain.models.libraryServices.attributes.DevolutionDate;
import finalTest.libraryManagement.domain.models.libraryServices.attributes.ServiceId;

public class BookDevolution {

    private final ServiceId serviceId;

    private final DevolutionDate devolutionDate;

    public BookDevolution(ServiceId serviceId, DevolutionDate devolutionDate) {
        this.serviceId = serviceId;
        this.devolutionDate = devolutionDate;
    }

    public ServiceId getServiceId() {
        return serviceId;
    }

    public DevolutionDate getDevolutionDate() {
        return devolutionDate;
    }
}
