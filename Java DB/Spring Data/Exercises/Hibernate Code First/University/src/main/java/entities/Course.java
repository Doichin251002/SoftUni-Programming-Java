package entities;

import lombok.*;
import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "courses")
@Getter
@Setter
public class Course extends BaseEntity {
    @Column(length = 50, nullable = false, unique = true)
    private String name;

    @Column(length = 100, columnDefinition = "TEXT")
    private String description;

    @Column(name = "start_date")
    private Date startDate;

    @Column(name = "end_date")
    private Date endDate;

    @Column
    private int credits;

    @ManyToMany(mappedBy = "courses")
    private Set<Student> students;

    @ManyToOne
    private Teacher teacher;
}
