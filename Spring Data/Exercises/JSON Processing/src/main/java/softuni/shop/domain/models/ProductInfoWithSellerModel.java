package softuni.shop.domain.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import softuni.shop.domain.entities.Product;

import java.math.BigDecimal;

@AllArgsConstructor
@Getter
@Setter
public class ProductInfoWithSellerModel {
    private String name;
    private BigDecimal price;
    private String seller;

    public static ProductInfoWithSellerModel getFromProduct(Product product) {
        String fullName = product.getSeller().getFirstName()
                + " "
                + product.getSeller().getLastName();

        return new ProductInfoWithSellerModel(product.getName(), product.getPrice(), fullName);
    }
}
