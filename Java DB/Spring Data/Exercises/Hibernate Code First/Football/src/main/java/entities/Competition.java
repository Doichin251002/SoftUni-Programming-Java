package entities;

import lombok.*;
import javax.persistence.*;

@Entity
@Table
@Getter
@Setter
public class Competition extends BaseEntity {
    @Column(nullable = false)
    private String name;

    @ManyToOne
    private CompetitionType type;
}
