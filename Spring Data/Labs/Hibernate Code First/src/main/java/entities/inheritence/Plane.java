package entities.inheritence;

import entities.composition.Company;

import javax.persistence.*;

@Entity
@Table(name = "planes")
@DiscriminatorValue("plane")
public class Plane extends PassengerVehicle {
    @Column(name = "airline")
    private String airline;

    @ManyToOne
    private Company company;

    public Plane() {}

    public Plane(int passengerCapacity, String airline) {
        super(passengerCapacity);
        this.airline = airline;
    }

    public String getAirline() {
        return airline;
    }

    public void setAirline(String airline) {
        this.airline = airline;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }
}
