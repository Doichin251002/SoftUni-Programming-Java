package entities;

import lombok.*;

import javax.persistence.*;

@Entity
@Table
@Getter
@Setter
public class Continent extends BaseEntity {
    @Column(nullable = false, unique = true)
    private String name;
}
