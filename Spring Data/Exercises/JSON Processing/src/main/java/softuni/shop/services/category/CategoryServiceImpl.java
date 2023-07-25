package softuni.shop.services.category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.shop.domain.models.CategorySummaryInfoModel;
import softuni.shop.repositories.CategoryRepository;

import java.io.IOException;
import java.util.List;

import static softuni.shop.constants.Paths.THIRD_JSON_PATH;
import static softuni.shop.constants.Utils.MAPPER;
import static softuni.shop.constants.Utils.writeIntoJsonFile;

@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<CategorySummaryInfoModel> getCategories() throws IOException {
        List<CategorySummaryInfoModel> categories = this.categoryRepository.getAllCategories()
                .stream().map(c -> MAPPER.map(c, CategorySummaryInfoModel.class))
                .toList();

        writeIntoJsonFile(categories, THIRD_JSON_PATH);

        return categories;
    }
}
