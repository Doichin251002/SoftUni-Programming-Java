package softuni.gamestore.services;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.gamestore.domain.entities.User;
import softuni.gamestore.domain.models.UserLoginDTO;
import softuni.gamestore.domain.models.UserRegisterDTO;
import softuni.gamestore.repositories.UserRepository;

import java.util.Optional;

import static softuni.gamestore.constants.ErrorMessages.*;
import static softuni.gamestore.constants.SuccessMessages.*;

@Service
public class UserServiceImpl implements UserService {
    private User loggedInUser;
    private final UserRepository repository;
    private final ModelMapper mapper;

    public UserServiceImpl(UserRepository repository) {
        this.repository = repository;
        this.mapper = new ModelMapper();
    }

    @Override
    public String registerUser(String[] args) {
        int argsLength = args.length;
        String email = argsLength > 1 ? args[1] : "";
        String password = argsLength > 2 ? args[2] : "";
        String confirmPassword = argsLength > 3 ? args[3] : "";
        String fullName = argsLength > 4 ? args[4] : "";

        UserRegisterDTO userRegisterDTO;
        try {
            userRegisterDTO = new UserRegisterDTO(email, password, confirmPassword, fullName);
        } catch (IllegalArgumentException e) {
            return e.getMessage();
        }

        if (this.repository.findFirstByEmail(userRegisterDTO.getEmail()).isPresent()) {
            throw new IllegalArgumentException(EMAIL_ALREADY_EXISTS);
        }

        User user = this.mapper.map(userRegisterDTO, User.class);

        user.setIsAdmin(this.repository.count() == 0);

        this.repository.saveAndFlush(user);

        return String.format(REGISTERED_USER_FORMAT, user.getFullName());
    }

    @Override
    public String loginUser(String[] args) {
        if (this.loggedInUser != null) {
            return USER_ALREADY_LOGGED_IN;
        }

        int argsLength = args.length;
        String email = argsLength > 1 ? args[1] : "";
        String password = argsLength > 2 ? args[2] : "";

        Optional<User> optionalUser = this.repository.findFirstByEmail(email);

        if (optionalUser.isEmpty()) {
             return INVALID_USERNAME_OR_PASSWORD;
        }

        UserLoginDTO userLoginDTO = new UserLoginDTO(email, password);

        try {
            userLoginDTO.validate(optionalUser.get().getPassword());
        } catch (IllegalArgumentException e) {
            return e.getMessage();
        }

        this.loggedInUser = optionalUser.get();

        return String.format(LOGGED_IN_USER_FORMAT, this.loggedInUser.getFullName());
    }

    @Override
    public String logoutUser() {
        if (this.loggedInUser == null) {
            return NO_USER_LOGGED;
        }

        String name = this.loggedInUser.getFullName();
        this.loggedInUser = null;

        return String.format(LOGGED_OUT_USER_FORMAT, name);
    }

    @Override
    public boolean isLoggedUserAdmin() {
        return this.loggedInUser != null && this.loggedInUser.getIsAdmin();
    }
}
