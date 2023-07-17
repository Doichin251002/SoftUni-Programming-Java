package shampoo_company.services;

import shampoo_company.entities.Ingredient;

import java.util.List;

public interface IngredientService {
    List<Ingredient> findByName(String letters);

    List<Ingredient> findByNames(List<String> names);
}
