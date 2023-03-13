package finalTest.libraryManagement.infrastructure.entrypoints.DTOs.usersDTO;

import finalTest.libraryManagement.domain.models.users.Users;
import finalTest.libraryManagement.domain.models.users.attributes.PenaltyFee;
import finalTest.libraryManagement.domain.models.users.attributes.UserId;
import finalTest.libraryManagement.domain.models.users.attributes.UserLastName;
import finalTest.libraryManagement.domain.models.users.attributes.UserName;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UsersDTO {

    private Integer userId;

    private String userName;

    private String userLastName;

    private Boolean penaltyFee;

    public static Users toDomain(UsersDTO usersDTO) {
        return new Users(new UserId(usersDTO.getUserId()),
                         new UserName(usersDTO.getUserName()),
                         new UserLastName(usersDTO.getUserLastName()),
                         new PenaltyFee(usersDTO.getPenaltyFee())

        );
    }

    public static UsersDTO fromDomain(Users users) {
        return new UsersDTO(
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
