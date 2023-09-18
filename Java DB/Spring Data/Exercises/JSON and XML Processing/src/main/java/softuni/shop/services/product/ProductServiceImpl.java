package softuni.shop.services.product;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.shop.domain.models.product.ProductInfoWithSellerModel;
import softuni.shop.domain.models.product.wrappers.ProductInfoWithSellerWrapperModel;
import softuni.shop.repositories.ProductRepository;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

import static softuni.shop.constants.Paths.FIRST_JSON_PATH;
import static softuni.shop.constants.Paths.FIRST_XML_PATH;
import static softuni.shop.constants.Utils.writeIntoJsonFile;
import static softuni.shop.constants.Utils.writeIntoXmlFile;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<ProductInfoWithSellerModel> getProductsInRangeWithoutBuyer(BigDecimal lowBoundary, BigDecimal highBoundary) throws IOException, JAXBException {
        List<ProductInfoWithSellerModel> products = this.productRepository
                .findAllByPriceBetweenAndBuyerIsNullOrderByPrice(lowBoundary, highBoundary)
                .stream()
                .map(ProductInfoWithSellerModel::getFromProduct)
                .toList();

        ProductInfoWithSellerWrapperModel wrapper = new ProductInfoWithSellerWrapperModel(products);

        writeIntoJsonFile(products, FIRST_JSON_PATH);
        writeIntoXmlFile(wrapper, FIRST_XML_PATH);

        return products;
    }
}
