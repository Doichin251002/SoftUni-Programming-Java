package softuni.shop.domain.models.category;

import lombok.Getter;
import lombok.Setter;

import jakarta.xml.bind.annotation.*;

@Getter
@Setter
@XmlRootElement(name = "category")
@XmlAccessorType(XmlAccessType.FIELD)
public class CategoryImportModel {
    @XmlElement(name = "name")
    private String name;
}
