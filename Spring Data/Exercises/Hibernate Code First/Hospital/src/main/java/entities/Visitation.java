package entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "visitations")
@Getter
@Setter
public class Visitation extends BaseEntity {
    @Column(nullable = false)
    private Date date;

    @Column(columnDefinition = "TEXT")
    private String comment;
}
