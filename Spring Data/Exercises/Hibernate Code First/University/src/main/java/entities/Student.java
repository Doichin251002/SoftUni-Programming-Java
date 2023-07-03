package entities;

import lombok.*;
import javax.persistence.*;
import java.util.Set;

@Entity
@Table (name = "students")
@Getter
@Setter
public class Student extends BaseEntity {
    @Column(name = "first_name", length = 50, nullable = false)
    private String firstName;

    @Column(name = "last_name", length = 50,nullable = false)
    private String lastName;

    @Column(name = "phone_number", length = 10, unique = true)
    private String phoneNumber;

    @Column(name = "average_grade", scale = 3, precision = 2)
    private Double averageGrade;

    @Column
    private int attendance;

    @ManyToMany
    @JoinTable(name = "students_courses",
            joinColumns = @JoinColumn(name = "student_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "course_id", referencedColumnName = "id"))
    private Set<Course> courses;
}
