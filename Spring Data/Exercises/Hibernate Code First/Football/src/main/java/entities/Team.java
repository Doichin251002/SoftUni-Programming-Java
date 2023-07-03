package entities;

import entities.enums.TeamShortName;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table
@Getter
@Setter
public class Team extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, unique = true, length = 50)
    private String name;

    @Column(nullable = false, unique = true)
    private String logo;

    @Column(name = "short_name")
    @Enumerated(EnumType.STRING)
    private TeamShortName shortName;

    @ManyToOne
    @JoinColumn(name = "primary_kit_color")
    private Color primaryColor;

    @ManyToOne
    @JoinColumn(name = "secondary_kit_color")
    private Color secondaryColor;

    @ManyToOne
    private Town town;

    @Column
    private BigDecimal budget;

}
