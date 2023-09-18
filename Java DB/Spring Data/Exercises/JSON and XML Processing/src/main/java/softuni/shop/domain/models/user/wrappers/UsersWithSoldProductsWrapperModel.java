package softuni.shop.domain.models.user.wrappers;

import jakarta.xml.bind.annotation.*;
import lombok.*;
import softuni.shop.domain.models.user.UserWithSoldProducts;

import java.util.List;

@XmlRootElement(name = "users")
@XmlAccessorType(XmlAccessType.FIELD)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UsersWithSoldProductsWrapperModel {
    @XmlAttribute
    private Integer count;

    @XmlElement(name = "user")
    private List<UserWithSoldProducts> users;

    public UsersWithSoldProductsWrapperModel(List<UserWithSoldProducts> users) {
        this.users = users;
        this.count = users.size();
    }
}
