package softuni.gamestore.services;

import softuni.gamestore.domain.entities.User;

public interface UserService {
    String registerUser(String[] args);
    String loginUser(String[] args);
    String logoutUser();
    boolean isLoggedUserAdmin();
}
