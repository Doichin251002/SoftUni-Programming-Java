package entities.inheritence;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "bikes")
@DiscriminatorValue("bike")
public class Bike extends Vehicle {

    public Bike() {}
}
