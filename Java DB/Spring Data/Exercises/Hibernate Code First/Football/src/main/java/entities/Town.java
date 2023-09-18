package entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table
@Getter
@Setter
public class Town extends BaseEntity {
    @Column(nullable = false)
    private String name;

    @ManyToOne
    private Country country;
}
