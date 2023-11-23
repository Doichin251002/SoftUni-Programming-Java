package entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "diagnoses")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Diagnose extends BaseEntity {
    @Column(nullable = false, unique = true)
    private String name;

    @Column(columnDefinition = "TEXT")
    private String comment;
}
