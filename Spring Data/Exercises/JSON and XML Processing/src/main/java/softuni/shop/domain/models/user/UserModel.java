package softuni.shop.domain.models.user;

import lombok.Getter;
import lombok.Setter;
import softuni.shop.domain.models.product.ProductModel;

import java.util.Set;

@Getter
@Setter
public class UserModel {
    private String firstName;

    private String lastName;

    private Integer age;

    private Set<ProductModel> sellingProducts;

    public UserWithSoldProducts toUserWithProductModel() {
        return new UserWithSoldProducts(firstName, lastName, age, ProductModel.toProductsSoldWithCountDto(sellingProducts));
    }
}
