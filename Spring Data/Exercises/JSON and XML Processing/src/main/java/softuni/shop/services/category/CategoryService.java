package softuni.shop.services.category;

import jakarta.xml.bind.JAXBException;
import softuni.shop.domain.models.category.CategorySummaryInfoModel;

import java.io.IOException;
import java.util.List;

public interface CategoryService {
    List<CategorySummaryInfoModel> getCategories() throws IOException, JAXBException;
}
