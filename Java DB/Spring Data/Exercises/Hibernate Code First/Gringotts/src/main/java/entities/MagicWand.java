package entities;

import javax.persistence.*;

@Entity
@Table(name = "magic_wands")
public class MagicWand {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "magic_wand_creator", length = 100)
    private String magicWandCreator;

    @Column(name = "magic_wand_size")
    private int magicWandSize;

    public MagicWand(){}
}
