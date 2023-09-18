package entities;

import lombok.*;
import javax.persistence.*;
@Entity
@Table
@Getter
@Setter
public class Position {
    @Id
    @Column(length = 2)
    private String id;

    @Column
    private String description;

}
