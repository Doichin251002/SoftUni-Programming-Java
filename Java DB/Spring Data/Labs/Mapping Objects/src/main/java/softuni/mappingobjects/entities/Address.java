package softuni.mappingobjects.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "addresses")
public class Address extends BaseEntity {
    @Column(nullable = false)
    private String country;
    @Column(nullable = false)
    private String town;

    public Address() {}

    public Address(String country, String town) {
        this.country = country;
        this.town = town;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }
}
