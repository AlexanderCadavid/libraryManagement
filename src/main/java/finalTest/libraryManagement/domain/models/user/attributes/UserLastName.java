package finalTest.libraryManagement.domain.models.user.attributes;

import java.util.regex.Pattern;

import org.springframework.util.Assert;

public class UserLastName {

    private final String userLastName;

    public UserLastName(String userLastName) {
        Assert.notNull(userLastName, "The user lastname can not be null");
        Assert.isTrue(userLastName.length() <= 30, "The Maximum user lastname size must be 30 characters");
        Assert.isTrue(Pattern.matches("^[A-z\\s]+(?<!\\s)$", userLastName), "The user lastname cannot contain special characters");
        this.userLastName = userLastName;
    }

    public String getUserLastName() {
        return userLastName;
    }
}
