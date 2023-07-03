package entities;

import lombok.*;
import javax.persistence.*;

@Entity
@Table
@Getter
@Setter
public class Round extends BaseEntity {
    @Column(nullable = false)
    private String name;
}
