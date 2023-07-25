package softuni.shop.services.seed;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.shop.domain.entities.Category;
import softuni.shop.domain.entities.Product;
import softuni.shop.domain.entities.User;
import softuni.shop.domain.models.CategoryImportModel;
import softuni.shop.domain.models.ProductImportModel;
import softuni.shop.domain.models.UserImportModel;
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
    public void seedUsers() throws IOException {
        if (this.userRepository.count() > 0) return;

        FileReader fileReader = new FileReader(USERS_JSON_PATH.toFile());

        List<User> users = Arrays
                .stream(GSON.fromJson(fileReader, UserImportModel[].class))
                .map(user -> MAPPER.map(user, User.class))
                .toList();

        this.userRepository.saveAll(users);
        fileReader.close();
    }

    @Override
    public void seedCategories() throws IOException {
        if (this.categoryRepository.count() > 0) return;

        FileReader fileReader = new FileReader(CATEGORIES_JSON_PATH.toFile());

        List<Category> categories = Arrays
                .stream(GSON.fromJson(fileReader, CategoryImportModel[].class))
                .map(category -> MAPPER.map(category, Category.class))
                .toList();

        this.categoryRepository.saveAll(categories);
        fileReader.close();
    }

    @Override
    public void seedProducts() throws IOException {
        if (this.productRepository.count() > 0) return;

        FileReader fileReader = new FileReader(PRODUCTS_JSON_PATH.toFile());

        List<Product> products = Arrays.stream(GSON.fromJson(fileReader, ProductImportModel[].class))
                .map(product -> MAPPER.map(product, Product.class))
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
}
