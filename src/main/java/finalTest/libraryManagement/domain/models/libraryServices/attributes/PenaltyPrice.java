package finalTest.libraryManagement.domain.models.libraryServices.attributes;

import org.springframework.util.Assert;

public class PenaltyPrice {

    private final Double penaltyPrice;

    public PenaltyPrice(Double penaltyPrice) {
        this.penaltyPrice = penaltyPrice;
    }

    public Double getPenaltyPrice() {
        return penaltyPrice;
    }
}
