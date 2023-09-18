package softuni.shop.services.category;

import jakarta.xml.bind.JAXBException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.shop.domain.models.category.CategorySummaryInfoModel;
import softuni.shop.domain.models.category.wrappers.CategorySummaryInfoWrapperModel;
import softuni.shop.repositories.CategoryRepository;

import java.io.IOException;
import java.util.List;

import static softuni.shop.constants.Paths.THIRD_JSON_PATH;
import static softuni.shop.constants.Paths.THIRD_XML_PATH;
import static softuni.shop.constants.Utils.*;

@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<CategorySummaryInfoModel> getCategories() throws IOException, JAXBException {
        List<CategorySummaryInfoModel> categories = this.categoryRepository.getAllCategories()
                .stream().map(c -> MAPPER.map(c, CategorySummaryInfoModel.class))
                .toList();

        CategorySummaryInfoWrapperModel wrapper = new CategorySummaryInfoWrapperModel(categories);

        writeIntoJsonFile(categories, THIRD_JSON_PATH);
        writeIntoXmlFile(wrapper, THIRD_XML_PATH);

        return categories;
    }
}
