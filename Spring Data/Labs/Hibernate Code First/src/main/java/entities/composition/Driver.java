package entities.composition;

import entities.inheritence.Car;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "drivers")
public class Driver {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "full_name")
    private String fullName;

    @ManyToMany(targetEntity = Car.class, mappedBy = "drivers")
    private List<Car> cars;

    public Driver() {}

    public Driver(int id, String fullName) {
        this.id = id;
        this.fullName = fullName;
    }
}
