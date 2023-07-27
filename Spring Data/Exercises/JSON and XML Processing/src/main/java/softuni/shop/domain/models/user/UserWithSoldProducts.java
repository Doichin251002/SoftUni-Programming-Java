package softuni.shop.domain.models.user;

import jakarta.xml.bind.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import softuni.shop.domain.models.product.ProductsSoldWithCountModel;

@XmlRootElement(name = "user")
@XmlAccessorType(XmlAccessType.FIELD)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserWithSoldProducts {
    @XmlAttribute(name = "first-name")
    private String firstName;

    @XmlAttribute(name = "last-name")
    private String lastName;

    @XmlAttribute
    private Integer age;

    @XmlElement(name = "sold-products")
    private ProductsSoldWithCountModel soldProducts;

}
