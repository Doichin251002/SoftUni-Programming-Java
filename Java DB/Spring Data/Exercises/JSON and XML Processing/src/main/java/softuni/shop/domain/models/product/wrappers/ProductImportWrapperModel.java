package softuni.shop.domain.models.product.wrappers;

import lombok.Getter;
import lombok.Setter;
import softuni.shop.domain.models.product.ProductImportModel;

import jakarta.xml.bind.annotation.*;
import java.util.List;

@Getter
@Setter
@XmlRootElement(name = "products")
@XmlAccessorType(XmlAccessType.FIELD)
public class ProductImportWrapperModel {
    @XmlElement(name = "product")
    private List<ProductImportModel> products;
}
