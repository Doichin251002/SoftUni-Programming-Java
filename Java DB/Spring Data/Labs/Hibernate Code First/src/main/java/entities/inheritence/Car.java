package entities.inheritence;

import entities.composition.Driver;
import entities.composition.PlateNumber;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "cars")
@DiscriminatorValue("car")
public class Car extends Vehicle {
    @Column(name = "seat_count")
    private int countSeats;
    @OneToOne
    @JoinColumn(name = "plate_id")
    private PlateNumber plateNumber;

    @ManyToMany
    @JoinTable(name = "cars_drivers",
                joinColumns = @JoinColumn(name = "car_id", referencedColumnName = "id"),
                inverseJoinColumns = @JoinColumn(name = "driver_id", referencedColumnName = "id"))
    private List<Driver> drivers;

    public Car() {}

    public Car(int id, String type, String model, BigDecimal price, String fuelType, int countSeats, PlateNumber plateNumber, List<Driver> drivers) {
        super(id, type, model, price, fuelType);
        this.countSeats = countSeats;
        this.plateNumber = plateNumber;
        this.drivers = drivers;
    }

    public int getCountSeats() {
        return countSeats;
    }

    public void setCountSeats(int countSeats) {
        this.countSeats = countSeats;
    }
}
