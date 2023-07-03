package entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "wizards")
public class Wizard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "first_name", length = 50)
    private String firstName;

    @Column(name = "last_name", length = 60, nullable = false)
    private String lastName;

    @Column(length = 1000, columnDefinition = "TEXT")
    private String notes;

    @Column(nullable = false)
    private int age;

    @OneToOne
    @JoinColumn(name = "magic_wand_id")
    private MagicWand magicWand;

    @OneToMany
    @JoinTable(name = "wizard_deposits",
            joinColumns = @JoinColumn(name = "wizard_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "deposit_id", referencedColumnName = "id"))
    private List<Deposit> deposits;

}
