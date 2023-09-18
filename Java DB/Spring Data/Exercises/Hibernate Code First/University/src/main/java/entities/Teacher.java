package entities;

import lombok.*;
import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "teachers")
@Getter
@Setter
public class Teacher extends BaseEntity {
    @Column(name = "first_name", length = 50, nullable = false)
    private String firstName;

    @Column(name = "last_name", length = 50, nullable = false)
    private String lastName;

    @Column(name = "phone_number", length = 10, unique = true)
    private String phoneNumber;

    @Column(unique = true)
    private String email;

    @Column(name = "salary_per_hour", scale = 10, precision = 2)
    private Double salaryPerHour;

    @OneToMany
    @JoinColumn(name = "course_id")
    private Set<Course> course;
}
