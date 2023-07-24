package softuni.mappingobjects.dto;

import softuni.mappingobjects.entities.BaseEntity;

public class AddressDTO extends BaseEntity {
    private String country;
    private String town;

    public AddressDTO(String country, String town) {
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
