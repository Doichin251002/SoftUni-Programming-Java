package shampoo_company.services;

import org.springframework.stereotype.Service;
import shampoo_company.entities.Shampoo;
import shampoo_company.enums.Size;
import shampoo_company.repositories.ShampooRepository;

import java.math.BigDecimal;
import java.util.List;

@Service
public class ShampooServiceImpl implements ShampooService {
    private final ShampooRepository shampooRepository;

    public ShampooServiceImpl(ShampooRepository shampooRepository) {
        this.shampooRepository = shampooRepository;
    }

    @Override
    public List<Shampoo> findBySize(Size size) {
        return this.shampooRepository.findBySizeOrderById(size);
    }

    @Override
    public List<Shampoo> findBySizeOrLabel(Size size, Long labelId) {
        return this.shampooRepository.findBySizeOrLabelIdOrderByPrice(size, labelId);
    }

    @Override
    public List<Shampoo> findByPrice(BigDecimal price) {
        return this.shampooRepository.findByPriceGreaterThanOrderByPriceDesc(price);
    }

    @Override
    public Long getCountWithPriceLessThan(BigDecimal price) {
        return this.shampooRepository.countByPriceLessThan(price);
    }

    @Override
    public List<Shampoo> findByIngredientsName(List<String> ingredientNames) {
        return this.shampooRepository.findShampooByIngredientsNameIn(ingredientNames);
    }
}
