package softuni.shop.services.user;

import softuni.shop.domain.models.UserWithSoldProductModel;

import java.io.IOException;
import java.util.List;

public interface UserService {
    List<UserWithSoldProductModel> getUsersWithSoldProducts() throws IOException;
}
