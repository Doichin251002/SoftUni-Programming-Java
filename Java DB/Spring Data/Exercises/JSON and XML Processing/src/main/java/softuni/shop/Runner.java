package softuni.shop;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import softuni.shop.services.category.CategoryService;
import softuni.shop.services.product.ProductService;
import softuni.shop.services.seed.SeedService;
import softuni.shop.services.user.UserService;

import java.math.BigDecimal;

@Component
public class Runner implements CommandLineRunner {
    private final SeedService seedService;
    private final ProductService productService;
    private final UserService userService;

    private final CategoryService categoryService;

    public Runner(SeedService seedService, ProductService productService, UserService userService, CategoryService categoryService) {
        this.seedService = seedService;
        this.productService = productService;
        this.userService = userService;
        this.categoryService = categoryService;
    }

    @Override
    public void run(String... args) throws Exception {
        this.seedService.seedAll("XML");

        this.productService.getProductsInRangeWithoutBuyer
        (BigDecimal.valueOf(500), BigDecimal.valueOf(1000));

        this.userService.getUsersWithSoldProducts();

        this.categoryService.getCategories();

        this.userService.getUsersWithSoldProductsWrapper();
    }
}
