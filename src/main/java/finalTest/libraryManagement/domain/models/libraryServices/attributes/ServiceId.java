package finalTest.libraryManagement.domain.models.libraryServices.attributes;

import org.springframework.util.Assert;

public class ServiceId {

    private final Integer serviceId;

    public ServiceId(Integer serviceId) {
        this.serviceId = serviceId;
    }

    public Integer getServiceId() {
        return serviceId;
    }
}
