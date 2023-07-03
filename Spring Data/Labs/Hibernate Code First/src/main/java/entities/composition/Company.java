package entities.composition;

import entities.inheritence.Plane;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "companies")
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Basic
    private String name;
    @OneToMany(targetEntity = Plane.class,
            mappedBy = "company",
            fetch = FetchType.EAGER,
            cascade = CascadeType.ALL)
    private List<Plane> planes;

    public Company(){}

    public Company(String name) {
        this.name = name;
        this.planes = new ArrayList<>();
    }

    public List<Plane> getPlanes() {
        return planes;
    }
}
