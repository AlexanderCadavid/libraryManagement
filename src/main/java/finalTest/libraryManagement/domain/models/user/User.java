package finalTest.libraryManagement.domain.models.user;

import finalTest.libraryManagement.domain.models.user.attributes.UserId;
import finalTest.libraryManagement.domain.models.user.attributes.UserLastName;
import finalTest.libraryManagement.domain.models.user.attributes.UserName;

public class User {

    private final UserId userId;

    private final UserName userName;

    private final UserLastName userLastName;


    public User(UserId userId, UserName userName, UserLastName userLastName) {
        this.userId = userId;
        this.userName = userName;
        this.userLastName = userLastName;
    }

    public UserId getUserId() {
        return userId;
    }

    public UserName getUserName() {
        return userName;
    }

    public UserLastName getUserLastName() {
        return userLastName;
    }

}
