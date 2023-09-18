package softuni.shop.services.user;

import jakarta.xml.bind.JAXBException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.shop.domain.models.user.UserModel;
import softuni.shop.domain.models.user.UserWithSoldProductModel;
import softuni.shop.domain.models.user.UserWithSoldProducts;
import softuni.shop.domain.models.user.wrappers.UserWithSoldProductWrapperModel;
import softuni.shop.domain.models.user.wrappers.UsersWithSoldProductsWrapperModel;
import softuni.shop.repositories.UserRepository;

import java.io.IOException;
import java.util.List;

import static softuni.shop.constants.Paths.*;
import static softuni.shop.constants.Utils.*;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<UserWithSoldProductModel> getUsersWithSoldProducts() throws IOException, JAXBException {
        List<UserWithSoldProductModel> users = this.userRepository
                .findAllBySellingProductsBuyerIsNotNullOrderBySellingProductsBuyerLastName()
                .stream().map(u -> MAPPER.map(u, UserWithSoldProductModel.class))
                .toList();

        UserWithSoldProductWrapperModel wrapper = new UserWithSoldProductWrapperModel(users);

        writeIntoJsonFile(users, SECOND_JSON_PATH);
        writeIntoXmlFile(wrapper, SECOND_XML_PATH);

        return users;
    }

    @Override
    public UsersWithSoldProductsWrapperModel getUsersWithSoldProductsWrapper() throws IOException, JAXBException {
        List<UserWithSoldProducts> users = this.userRepository
                .findAllBySellingProductsBuyerIsNotNullOrderBySellingProductsBuyerLastName()
                .stream()
                .map(u -> MAPPER.map(u, UserModel.class))
                .map(UserModel::toUserWithProductModel)
                .toList();

        UsersWithSoldProductsWrapperModel wrapper = new UsersWithSoldProductsWrapperModel(users);

        writeIntoJsonFile(users, FOURTH_JSON_PATH);
        writeIntoXmlFile(wrapper, FOURTH_XML_PATH);

        return wrapper;
    }


}
