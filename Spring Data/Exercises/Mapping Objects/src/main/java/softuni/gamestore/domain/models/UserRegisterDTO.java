package softuni.gamestore.domain.models;

import lombok.*;

import java.util.regex.Pattern;

import static softuni.gamestore.constants.ErrorMessages.*;
import static softuni.gamestore.constants.Validations.EMAIL_PATTERN;
import static softuni.gamestore.constants.Validations.PASSWORD_PATTERN;

@Builder
@Getter
@Setter
public class UserRegisterDTO {
    private String email;
    private String password;
    private String confirmPassword;
    private String fullName;

    public UserRegisterDTO(String email, String password, String confirmPassword, String fullName) {
        this.email = email;
        this.password = password;
        this.confirmPassword = confirmPassword;
        this.fullName = fullName;
        
        validate();
    }

    private void validate() {
        if (!Pattern.matches(EMAIL_PATTERN, this.email)) {
            throw new IllegalArgumentException(INVALID_EMAIL);
        }

        if (!Pattern.matches(PASSWORD_PATTERN, this.password)) {
            throw new IllegalArgumentException(INVALID_PASSWORD);
        }
        if (!this.password.equals(this.confirmPassword)) {
            throw new IllegalArgumentException(PASSWORD_NO_MATCH);
        }
    }
}
