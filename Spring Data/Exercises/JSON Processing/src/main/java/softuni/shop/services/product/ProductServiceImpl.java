package softuni.shop.services.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.shop.domain.models.ProductInfoWithSellerModel;
import softuni.shop.repositories.ProductRepository;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

import static softuni.shop.constants.Paths.FIRST_JSON_PATH;
import static softuni.shop.constants.Utils.writeIntoJsonFile;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<ProductInfoWithSellerModel> getProductsInRangeWithoutBuyer(BigDecimal lowBoundary, BigDecimal highBoundary) throws IOException {
        List<ProductInfoWithSellerModel> products = this.productRepository
                .findAllByPriceBetweenAndBuyerIsNullOrderByPrice(lowBoundary, highBoundary)
                .stream()
                .map(ProductInfoWithSellerModel::getFromProduct)
                .toList();

        writeIntoJsonFile(products, FIRST_JSON_PATH);

        return products;
    }
}
