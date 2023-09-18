package entities;

import lombok.*;
import javax.persistence.*;

@Entity
@Table
@Getter
@Setter
public class Player extends BaseEntity {
    @Column(nullable = false, unique = true, length = 50)
    private String name;

    @Column(name = "squad_number")
    private Integer squadNumber;

    @ManyToOne
    private Team team;

    @ManyToOne
    private Position position;

    @Column(name = "is_currently_injured")
    private boolean isCurrentlyInjured;
}
