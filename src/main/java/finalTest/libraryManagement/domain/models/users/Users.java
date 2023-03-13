package finalTest.libraryManagement.domain.models.users;

import finalTest.libraryManagement.domain.models.users.attributes.PenaltyFee;
import finalTest.libraryManagement.domain.models.users.attributes.UserId;
import finalTest.libraryManagement.domain.models.users.attributes.UserLastName;
import finalTest.libraryManagement.domain.models.users.attributes.UserName;

public class Users {

    private final UserId userId;

    private final UserName userName;

    private final UserLastName userLastName;

    private final PenaltyFee penaltyFee;

    public Users(UserId userId, UserName userName, UserLastName userLastName, PenaltyFee penaltyFee) {
        this.userId = userId;
        this.userName = userName;
        this.userLastName = userLastName;
        this.penaltyFee = penaltyFee;
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

    public PenaltyFee getPenaltyFee() {
        return penaltyFee;
    }
}
