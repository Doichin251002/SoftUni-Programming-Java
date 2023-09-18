package softuni.shop.domain.models.user.wrappers;

import jakarta.xml.bind.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import softuni.shop.domain.models.user.UserWithSoldProductModel;

import java.util.List;

@XmlRootElement(name = "users")
@XmlAccessorType(XmlAccessType.FIELD)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserWithSoldProductWrapperModel {
    @XmlElement(name = "user")
    private List<UserWithSoldProductModel> users;
}
