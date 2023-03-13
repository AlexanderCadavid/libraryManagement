package finalTest.libraryManagement.infrastructure.adapters.DBOs.usersDBO;

import finalTest.libraryManagement.domain.models.users.Users;
import finalTest.libraryManagement.domain.models.users.attributes.PenaltyFee;
import finalTest.libraryManagement.domain.models.users.attributes.UserId;
import finalTest.libraryManagement.domain.models.users.attributes.UserLastName;
import finalTest.libraryManagement.domain.models.users.attributes.UserName;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UsersDBO {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer userId;

    private String userName;

    private String userLastName;

    private Boolean penaltyFee;

    public static Users toDomain(UsersDBO usersDBO) {
        return new Users(new UserId(usersDBO.getUserId()),
                         new UserName(usersDBO.getUserName()),
                         new UserLastName(usersDBO.getUserLastName()),
                         new PenaltyFee(usersDBO.getPenaltyFee())

        );
    }

    public static UsersDBO fromDomain(Users users) {
        return new UsersDBO(
                users
                        .getUserId()
                        .getUserId(),
                users
                        .getUserName()
                        .getUserName(),
                users
                        .getUserLastName()
                        .getUserLastName(),
                users
                        .getPenaltyFee()
                        .getPenaltyFee()
        );
    }

}
