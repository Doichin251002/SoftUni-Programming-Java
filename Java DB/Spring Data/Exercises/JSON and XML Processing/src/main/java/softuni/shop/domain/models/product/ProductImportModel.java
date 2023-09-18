package softuni.shop.domain.models.product;

import lombok.Getter;
import lombok.Setter;

import jakarta.xml.bind.annotation.*;
import java.math.BigDecimal;

@Getter
@Setter
@XmlRootElement(name = "product")
@XmlAccessorType(XmlAccessType.FIELD)
public class ProductImportModel {
    @XmlElement(name = "name")
    private String name;

    @XmlElement(name = "price")
    private BigDecimal price;
}
