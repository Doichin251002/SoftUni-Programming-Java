package entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "visitations")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Visitation extends BaseEntity {
    @Column(nullable = false)
    private Date date;

    @Column(columnDefinition = "TEXT")
    private String comment;
}
