package finalTest.libraryManagement.domain.models.user.attributes;

import java.util.regex.Pattern;

import org.springframework.util.Assert;

public class UserName {

    private final String userName;

    public UserName(String userName) {
        Assert.notNull(userName, "The user name can not be null");
        Assert.isTrue(userName.length() <= 30, "The Maximum user name size must be 30 characters");
        Assert.isTrue(Pattern.matches("^[A-z\\s]+(?<!\\s)$", userName), "The user name cannot contain special characters");
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }
}
