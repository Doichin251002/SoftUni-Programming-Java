package shampoo_company.services;

import org.springframework.stereotype.Service;
import shampoo_company.entities.Ingredient;
import shampoo_company.repositories.IngredientRepository;

import java.util.List;

@Service
public class IngredientServiceImpl implements IngredientService {
    private final IngredientRepository ingredientRepository;

    public IngredientServiceImpl(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }

    @Override
    public List<Ingredient> findByName(String letters) {
        return this.ingredientRepository.findByNameStartingWith(letters);
    }

    @Override
    public List<Ingredient> findByNames(List<String> names) {
        return this.ingredientRepository.findByNameInOrderByPrice(names);
    }
}
