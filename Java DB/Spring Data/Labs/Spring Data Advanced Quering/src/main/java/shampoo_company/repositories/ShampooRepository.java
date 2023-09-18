package shampoo_company.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import shampoo_company.entities.Label;
import shampoo_company.entities.Shampoo;
import shampoo_company.enums.Size;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Repository
public interface ShampooRepository extends JpaRepository<Shampoo, Long> {
    List<Shampoo> findBySizeOrderById(Size size);

    List<Shampoo> findBySizeOrLabelIdOrderByPrice(Size size, Long labelId);

    List<Shampoo> findByPriceGreaterThanOrderByPriceDesc(BigDecimal price);

    Long countByPriceLessThan(BigDecimal price);

    List<Shampoo> findShampooByIngredientsNameIn(List<String> ingredientNames);
}
