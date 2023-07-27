package softuni.shop.services.seed;

import jakarta.xml.bind.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.shop.domain.entities.Category;
import softuni.shop.domain.entities.Product;
import softuni.shop.domain.entities.User;
import softuni.shop.domain.models.category.CategoryImportModel;
import softuni.shop.domain.models.category.wrappers.CategoryImportWrapperModel;
import softuni.shop.domain.models.product.ProductImportModel;
import softuni.shop.domain.models.product.wrappers.ProductImportWrapperModel;
import softuni.shop.domain.models.user.UserImportModel;
import softuni.shop.domain.models.user.wrappers.UserImportWrapperModel;
import softuni.shop.repositories.CategoryRepository;
import softuni.shop.repositories.ProductRepository;
import softuni.shop.repositories.UserRepository;

import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.*;
import java.util.stream.IntStream;

import static softuni.shop.constants.Paths.*;
import static softuni.shop.constants.Utils.GSON;
import static softuni.shop.constants.Utils.MAPPER;

@Service
public class SeedServiceImpl implements SeedService {
    private final UserRepository userRepository;
    private final CategoryRepository categoryRepository;
    private final ProductRepository productRepository;

    @Autowired
    public SeedServiceImpl(UserRepository userRepository, CategoryRepository categoryRepository, ProductRepository productRepository) {
        this.userRepository = userRepository;
        this.categoryRepository = categoryRepository;
        this.productRepository = productRepository;
    }

    @Override
    public void seedUsers(String type) throws IOException, JAXBException {
        if (this.userRepository.count() > 0) return;

        List<User> users = type.equals("JSON")
                ? getAllUsersFromJson()
                : getAllUsersFromXml();

        this.userRepository.saveAll(users);
    }

    @Override
    public void seedCategories(String type) throws IOException, JAXBException {
        if (this.categoryRepository.count() > 0) return;

        List<Category> categories = type.equals("JSON")
                ? getAllCategoriesFromJson()
                : getAllCategoriesFromXml();

        this.categoryRepository.saveAll(categories);
    }

    @Override
    public void seedProducts(String type) throws IOException, JAXBException {
        if (this.productRepository.count() > 0) return;

        FileReader fileReader = new FileReader(PRODUCTS_JSON_PATH.toFile());

        List<Product> productsBeforeMapping = type.equals("JSON")
                ? getAllProductsFromJson()
                : getAllProductsFromXml();

        List<Product> products = productsBeforeMapping.stream()
                .map(this::setRandomCategory)
                .map(this::setRandomBuyer)
                .map(this::setRandomSeller)
                .toList();

        this.productRepository.saveAll(products);

        fileReader.close();
    }

    private Product setRandomCategory(Product product) {
        Random random = new Random();
        int countCategories = random.nextInt((int) this.categoryRepository.count());

        Set<Category> categories = new HashSet<>();

        IntStream.range(0, countCategories)
                .forEach(value -> {
                    categories.add(this.categoryRepository
                            .getRandomEntity()
                            .orElseThrow(NoSuchElementException::new));
                });

        product.setCategories(categories);

        return product;
    }

    private Product setRandomBuyer(Product product) {
        if (product.getPrice().compareTo(BigDecimal.valueOf(750L)) > 0) {
            User buyer = this.userRepository
                    .getRandomEntity()
                    .orElseThrow(NoSuchElementException::new);

            product.setBuyer(buyer);
        }

        return product;
    }

    private Product setRandomSeller(Product product) {
        User seller = this.userRepository
                .getRandomEntity()
                .orElseThrow(NoSuchElementException::new);

        while (product.getBuyer() != null && product.getBuyer().getId().equals(seller.getId())) {
            seller = this.userRepository
                    .getRandomEntity()
                    .orElseThrow(NoSuchElementException::new);
        }

        product.setSeller(seller);

        return product;
    }

    private List<Category> getAllCategoriesFromJson() throws IOException {
        FileReader fileReader = new FileReader(CATEGORIES_JSON_PATH.toFile());

        List<Category> categories = Arrays
                .stream(GSON.fromJson(fileReader, CategoryImportModel[].class))
                .map(category -> MAPPER.map(category, Category.class))
                .toList();

        fileReader.close();
        return categories;
    }

    private List<Category> getAllCategoriesFromXml() throws IOException, JAXBException {
        FileReader fileReader = new FileReader(CATEGORIES_XML_PATH.toFile());

        JAXBContext jaxbContext = JAXBContext
                .newInstance(CategoryImportWrapperModel.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        CategoryImportWrapperModel wrapperImportModel =
                (CategoryImportWrapperModel) unmarshaller.unmarshal(fileReader);

        List<Category> categories = wrapperImportModel.getCategories().stream()
                .map(categoryImportModel ->
                        MAPPER.map(categoryImportModel, Category.class))
                .toList();

        fileReader.close();
        return categories;
    }

    private List<User> getAllUsersFromJson() throws IOException {
        FileReader fileReader = new FileReader(USERS_JSON_PATH.toFile());

        List<User> users = Arrays
                .stream(GSON.fromJson(fileReader, UserImportModel[].class))
                .map(userImportModel -> MAPPER.map(userImportModel, User.class))
                .toList();

        fileReader.close();
        return users;
    }

    private List<User> getAllUsersFromXml() throws IOException, JAXBException {
        FileReader fileReader = new FileReader(USERS_XML_PATH.toFile());

        JAXBContext jaxbContext = JAXBContext
                .newInstance(UserImportWrapperModel.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        UserImportWrapperModel userImportWrapperModel =
                (UserImportWrapperModel) unmarshaller.unmarshal(fileReader);

        List<User> users = userImportWrapperModel.getUsers().stream()
                .map(userImportModel -> MAPPER.map(userImportModel, User.class))
                .toList();

        fileReader.close();
        return users;
    }

    private List<Product> getAllProductsFromJson() throws IOException {
        FileReader fileReader = new FileReader(PRODUCTS_JSON_PATH.toFile());

        List<Product> products = Arrays
                .stream(GSON.fromJson(fileReader, ProductImportModel[].class))
                .map(productImportModel ->
                        MAPPER.map(productImportModel, Product.class))
                .toList();

        fileReader.close();
        return products;
    }

    private List<Product> getAllProductsFromXml() throws IOException, JAXBException {
        FileReader fileReader = new FileReader(PRODUCTS_XML_PATH.toFile());

        JAXBContext jaxbContext = JAXBContext
                .newInstance(ProductImportWrapperModel.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        ProductImportWrapperModel productWrapperImportModel =
                (ProductImportWrapperModel) unmarshaller.unmarshal(fileReader);

        List<Product> products = productWrapperImportModel.getProducts().stream()
                .map(productImportModel ->
                        MAPPER.map(productImportModel, Product.class))
                .toList();

        fileReader.close();
        return products;
    }
}
