package entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Getter
@Setter
public abstract class BillingDetail{
    @Id
    @Column(length = 30)
    private String number;

    @ManyToOne
    private User owner;
}
