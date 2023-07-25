package softuni.shop.domain.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class User extends BaseEntity {
    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column
    private Integer age;

    @OneToMany(targetEntity = Product.class, mappedBy = "seller", fetch = FetchType.EAGER)
    private Set<Product> sellingProducts;

    @OneToMany(targetEntity = Product.class, mappedBy = "buyer", fetch = FetchType.EAGER)
    private Set<Product> buyingProducts;

    @ManyToMany
    private Set<User> friends;
}
