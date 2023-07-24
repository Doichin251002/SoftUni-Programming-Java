package softuni.gamestore.domain.models;

import lombok.Getter;
import lombok.Setter;

import static softuni.gamestore.constants.ErrorMessages.PASSWORD_NO_MATCH;

@Getter
@Setter
public class UserLoginDTO {
    private String email;
    private String password;

    public UserLoginDTO(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public void validate(String realPassword) {
        if (!this.password.equals(realPassword)) {
            throw new IllegalArgumentException(PASSWORD_NO_MATCH);
        }
    }
}
