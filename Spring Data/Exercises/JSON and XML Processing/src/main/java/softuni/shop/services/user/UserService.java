package softuni.shop.services.user;

import jakarta.xml.bind.JAXBException;
import softuni.shop.domain.models.user.UserWithSoldProductModel;
import softuni.shop.domain.models.user.wrappers.UsersWithSoldProductsWrapperModel;

import java.io.IOException;
import java.util.List;

public interface UserService {
    List<UserWithSoldProductModel> getUsersWithSoldProducts() throws IOException, JAXBException;

    UsersWithSoldProductsWrapperModel getUsersWithSoldProductsWrapper() throws IOException, JAXBException;
}
