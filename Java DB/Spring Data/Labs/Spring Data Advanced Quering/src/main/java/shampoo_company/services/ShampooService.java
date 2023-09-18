package shampoo_company.services;

import org.springframework.data.jpa.repository.Query;
import shampoo_company.entities.Shampoo;
import shampoo_company.enums.Size;

import java.math.BigDecimal;
import java.util.List;

public interface ShampooService {
    List<Shampoo> findBySize(Size size);

    List<Shampoo> findBySizeOrLabel(Size size, Long labelId);

    List<Shampoo> findByPrice(BigDecimal price);

    Long getCountWithPriceLessThan(BigDecimal price);

    @Query("select s from Shampoo s join Ingredient i where i.name in :names")
    List<Shampoo> findByIngredientsName(List<String> ingredientNames);
}
