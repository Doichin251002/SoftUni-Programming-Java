package softuni.shop.services.category;

import softuni.shop.domain.models.CategorySummaryInfoModel;

import java.io.IOException;
import java.util.List;

public interface CategoryService {
    List<CategorySummaryInfoModel> getCategories() throws IOException;
}
