package entities;

import lombok.*;
import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table
@Getter
@Setter
public class PlayerStatistic implements Serializable {
    @Id
    @ManyToOne
    @JoinColumn
    private Game game;

    @Id
    @ManyToOne
    @JoinColumn
    private Player player;

    @Column(name = "scored_goals")
    private int scoredGoals;

    @Column
    private int playerAssists;

    @Column
    private int playerMinutes;
}
