package softuni.shop.services.seed;

import jakarta.xml.bind.JAXBException;
import java.io.IOException;

public interface SeedService {
    void seedUsers(String type) throws IOException, jakarta.xml.bind.JAXBException;
    void seedCategories(String type) throws IOException, jakarta.xml.bind.JAXBException;
    void seedProducts(String type) throws IOException, jakarta.xml.bind.JAXBException;

    default void seedAll(String type) throws IOException, JAXBException {
        seedUsers(type);
        seedCategories(type);
        seedProducts(type);
    }
}
