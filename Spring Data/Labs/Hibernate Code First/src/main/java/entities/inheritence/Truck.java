package entities.inheritence;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "trucks")
@DiscriminatorValue("truck")
public class Truck extends TransportationVehicle {

    public Truck(){}
    public Truck(double loadCapacity) {
        super(loadCapacity);
    }
}
