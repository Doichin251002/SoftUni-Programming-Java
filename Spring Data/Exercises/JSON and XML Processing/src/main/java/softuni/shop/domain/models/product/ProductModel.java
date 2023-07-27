package softuni.shop.domain.models.product;

import lombok.Getter;
import lombok.Setter;
import softuni.shop.domain.entities.User;
import softuni.shop.domain.models.category.CategoryModel;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

@Getter
@Setter
public class ProductModel {
    private String name;
    private BigDecimal price;
    private User buyer;
    private User seller;
    private Set<CategoryModel> categories;


    public static ProductsSoldWithCountModel toProductsSoldWithCountDto(Set<ProductModel> sellingProducts) {
        List<ProductBasicInfoModel> productBasicInfoModelStream = sellingProducts.stream()
                .map(ProductModel::toProductBasicInfoModel)
                .toList();

        return ProductsSoldWithCountModel.productsSoldWithCountDto(productBasicInfoModelStream);
    }

    private static ProductBasicInfoModel toProductBasicInfoModel(ProductModel productDto) {
        return new ProductBasicInfoModel(productDto.getName(), productDto.getPrice());
    }
}
