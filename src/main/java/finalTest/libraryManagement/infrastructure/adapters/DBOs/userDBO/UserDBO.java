package finalTest.libraryManagement.infrastructure.adapters.DBOs.userDBO;

import finalTest.libraryManagement.domain.models.user.User;
import finalTest.libraryManagement.domain.models.user.attributes.UserId;
import finalTest.libraryManagement.domain.models.user.attributes.UserLastName;
import finalTest.libraryManagement.domain.models.user.attributes.UserName;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "users")
public class UserDBO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;

    private String userName;

    private String userLastName;


    public static User toDomain(UserDBO userDBO) {
        return new User(new UserId(userDBO.getUserId()),
                        new UserName(userDBO.getUserName()),
                        new UserLastName(userDBO.getUserLastName())

        );
    }

    public static UserDBO fromDomain(User user) {
        return new UserDBO(
                user
                        .getUserId()
                        .getUserId(),
                user
                        .getUserName()
                        .getUserName(),
                user
                        .getUserLastName()
                        .getUserLastName()
        );
    }

}
