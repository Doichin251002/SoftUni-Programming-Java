package entities.inheritence;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class TransportationVehicle extends Vehicle {
    @Column(name = "load_capacity")
    private double loadCapacity;

    public TransportationVehicle(){}

    public TransportationVehicle(double loadCapacity) {
        this.loadCapacity = loadCapacity;
    }

    public double getLoadCapacity() {
        return loadCapacity;
    }

    public void setLoadCapacity(double loadCapacity) {
        this.loadCapacity = loadCapacity;
    }
}
