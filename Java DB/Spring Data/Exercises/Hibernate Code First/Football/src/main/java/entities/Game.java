package entities;

import lombok.*;
import javax.persistence.*;
import java.sql.Time;
import java.util.Date;

@Entity
@Table
@Getter
@Setter
public class Game extends BaseEntity {

    @OneToOne
    @JoinColumn
    private Team homeTeam;

    @OneToOne
    @JoinColumn
    private Team awayTeam;

    @Column
    private int homeGoals;

    @Column
    private int awayGoals;

    @Column
    private Date dateGame;

    @Column
    private Double homeTeamWinBetRate;

    @Column
    private Double awayTeamWinBetRate;

    @Column
    private Double drawGameWinBetRate;

    @ManyToOne
    @JoinColumn
    private Round round;

    @ManyToOne
    @JoinColumn
    private Competition competition;

}
