package finalTest.libraryManagement.infrastructure.entrypoints.DTOs.userDTO;

import finalTest.libraryManagement.domain.models.user.User;
import finalTest.libraryManagement.domain.models.user.attributes.UserId;
import finalTest.libraryManagement.domain.models.user.attributes.UserLastName;
import finalTest.libraryManagement.domain.models.user.attributes.UserName;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserDTO {


    private Integer userId;

    @NotBlank
    @Size(max = 30,
          message = "The user name cannot contain more than 30 characters ")
    @Pattern(regexp = "^[A-z\\s]+(?<!\\s)$",
             message = "The user name cannot contain special characters")
    private String userName;

    @NotBlank
    @Size(max = 30,
          message = "The user lastname cannot contain more than 30 characters ")
    @Pattern(regexp = "^[A-z\\s]+(?<!\\s)$",
             message = "The user lastname cannot contain special characters")
    private String userLastName;


    public static User toDomain(UserDTO userDTO) {
        return new User(new UserId(userDTO.getUserId()),
                        new UserName(userDTO.getUserName()),
                        new UserLastName(userDTO.getUserLastName())

        );
    }

    public static UserDTO fromDomain(User user) {
        return new UserDTO(
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
