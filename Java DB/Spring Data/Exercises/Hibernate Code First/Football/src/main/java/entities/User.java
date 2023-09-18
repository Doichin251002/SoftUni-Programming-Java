package entities;

import lombok.*;
import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table
@Getter
@Setter
public class User extends BaseEntity {
    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(name = "full_name")
    private String fullName;

    @Column
    private BigDecimal balance;
}
