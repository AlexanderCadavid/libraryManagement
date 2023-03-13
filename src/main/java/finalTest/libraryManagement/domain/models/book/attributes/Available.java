package finalTest.libraryManagement.domain.models.book.attributes;

import org.springframework.util.Assert;

public class Available {

    private final Boolean available;

    public Available(Boolean available) {
        Assert.notNull(available, "The available attribute cannot be null");
        this.available = available;
    }

    public Boolean getAvailable() {
        return available;
    }
}
