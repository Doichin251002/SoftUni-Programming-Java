package softuni.shop.services.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.shop.domain.models.UserWithSoldProductModel;
import softuni.shop.repositories.UserRepository;

import java.io.IOException;
import java.util.List;

import static softuni.shop.constants.Paths.SECOND_JSON_PATH;
import static softuni.shop.constants.Utils.MAPPER;
import static softuni.shop.constants.Utils.writeIntoJsonFile;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<UserWithSoldProductModel> getUsersWithSoldProducts() throws IOException {
        List<UserWithSoldProductModel> users = this.userRepository
                .findAllBySellingProductsBuyerIsNotNullOrderBySellingProductsBuyerLastName()
                .stream().map(u -> MAPPER.map(u, UserWithSoldProductModel.class))
                .toList();

        writeIntoJsonFile(users, SECOND_JSON_PATH);

        return users;
    }
}
