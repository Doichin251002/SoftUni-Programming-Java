package entities.inheritence;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "vehicles")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type")
public abstract class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private int id;
    @Basic
    @Column(insertable = false, updatable = false)
    private String type;

    @Column(name = "model")
    private String model;
    @Column(name = "price")
    private BigDecimal price;
    @Column(name = "fuel_type")
    private String fuelType;

    protected Vehicle(){}

    public Vehicle(int id, String type, String model, BigDecimal price, String fuelType) {
        this.id = id;
        this.type = type;
        this.model = model;
        this.price = price;
        this.fuelType = fuelType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }
}
