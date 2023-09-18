package softuni.shop.domain.models.product;

import lombok.*;
import jakarta.xml.bind.annotation.*;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@XmlRootElement(name = "product")
@XmlAccessorType(XmlAccessType.FIELD)
public class ProductBasicInfoModel {
    @XmlAttribute
    private String name;

    @XmlAttribute
    private BigDecimal price;
}
