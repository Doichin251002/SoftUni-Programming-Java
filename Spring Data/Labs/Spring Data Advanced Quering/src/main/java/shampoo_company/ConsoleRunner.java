package shampoo_company;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import shampoo_company.entities.Ingredient;
import shampoo_company.entities.Shampoo;
import shampoo_company.services.IngredientService;
import shampoo_company.services.ShampooService;

import java.math.BigDecimal;
import java.util.List;

@Component
public class ConsoleRunner implements CommandLineRunner {
    private final ShampooService shampooService;
    private final IngredientService ingredientService;

    public ConsoleRunner(ShampooService shampooService, IngredientService ingredientService) {
        this.shampooService = shampooService;
        this.ingredientService = ingredientService;
    }

    @Override
    public void run(String... args) throws Exception {
        this.ingredientService.deleteByName("Herbs");
    }
}
