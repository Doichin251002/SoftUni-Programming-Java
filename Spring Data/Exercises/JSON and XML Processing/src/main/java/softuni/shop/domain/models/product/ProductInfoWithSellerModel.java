package softuni.shop.domain.models.product;

import com.google.gson.annotations.SerializedName;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import softuni.shop.domain.entities.Product;

import java.math.BigDecimal;

@XmlRootElement(name = "product")
@XmlAccessorType(XmlAccessType.FIELD)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ProductInfoWithSellerModel {
    @XmlAttribute
    private String name;

    @XmlAttribute
    private BigDecimal price;

    @SerializedName(value = "seller")
    @XmlAttribute(name = "seller")
    private String seller;

    public static ProductInfoWithSellerModel getFromProduct(Product product) {
        String fullName =
                product.getSeller().getFirstName()
                + " "
                + product.getSeller().getLastName();

        return new ProductInfoWithSellerModel(product.getName(), product.getPrice(), fullName);
    }
}
