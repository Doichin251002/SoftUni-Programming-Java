package softuni.shop.domain.models.user;

import lombok.Getter;
import lombok.Setter;

import jakarta.xml.bind.annotation.*;

@Getter
@Setter
@XmlRootElement(name = "user")
@XmlAccessorType(XmlAccessType.FIELD)
public class UserImportModel {
    @XmlAttribute(name = "first-name")
    private String firstName;

    @XmlAttribute(name = "last-name")
    private String lastName;

    @XmlAttribute(name = "age")
    private int age;
}
