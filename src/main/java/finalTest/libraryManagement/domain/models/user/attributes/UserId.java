package finalTest.libraryManagement.domain.models.user.attributes;

import org.springframework.util.Assert;

public class UserId {

    private final Integer userId;

    public UserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getUserId() {
        return userId;
    }
}
