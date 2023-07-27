package softuni.shop.domain.models.category.wrappers;

import lombok.Getter;
import lombok.Setter;
import softuni.shop.domain.models.category.CategoryImportModel;

import jakarta.xml.bind.annotation.*;
import java.util.List;

@Getter
@Setter
@XmlRootElement(name = "categories")
@XmlAccessorType(XmlAccessType.FIELD)
public class CategoryImportWrapperModel {
    @XmlElement(name = "category")
    private List<CategoryImportModel> categories;

}
