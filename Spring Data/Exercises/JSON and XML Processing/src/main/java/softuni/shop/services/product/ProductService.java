package softuni.shop.services.product;

import jakarta.xml.bind.JAXBException;
import softuni.shop.domain.models.product.ProductInfoWithSellerModel;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

public interface ProductService {
    List<ProductInfoWithSellerModel> getProductsInRangeWithoutBuyer(BigDecimal lowBoundary, BigDecimal highBoundary) throws IOException, JAXBException;
}
