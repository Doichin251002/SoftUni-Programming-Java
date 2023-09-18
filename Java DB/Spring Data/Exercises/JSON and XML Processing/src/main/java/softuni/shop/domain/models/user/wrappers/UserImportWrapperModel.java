package softuni.shop.domain.models.user.wrappers;

import lombok.Getter;
import lombok.Setter;
import softuni.shop.domain.models.user.UserImportModel;

import jakarta.xml.bind.annotation.*;
import java.util.List;

@XmlRootElement(name = "users")
@XmlAccessorType(XmlAccessType.FIELD)
@Getter
@Setter
public class UserImportWrapperModel {
    @XmlElement(name = "user")
    private List<UserImportModel> users;
}
