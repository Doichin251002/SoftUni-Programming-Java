package softuni.shop.domain.models;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class UserWithSoldProductModel {
    private String firstName;
    private String lastName;
    private Set<ProductSoldModel> buyingProducts;
}
