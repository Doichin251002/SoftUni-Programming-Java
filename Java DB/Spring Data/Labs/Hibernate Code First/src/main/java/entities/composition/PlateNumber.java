package entities.composition;

import entities.inheritence.Car;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "plate_numbers")
public class PlateNumber {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id;
    @Column(unique = true)
    private String number;
    @Column(name = "issued_at")
    private LocalDate issuedAt;

    @OneToOne(targetEntity = Car.class, mappedBy = "plateNumber")
    private Car car;

    public PlateNumber(){}

    public PlateNumber(int id, String number, LocalDate issuedAt, Car car) {
        this.id = id;
        this.number = number;
        this.issuedAt = issuedAt;
        this.car = car;
    }
}
