package entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "medicaments")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Medicament extends BaseEntity {
    @Column(nullable = false, unique = true)
    private String name;
}
