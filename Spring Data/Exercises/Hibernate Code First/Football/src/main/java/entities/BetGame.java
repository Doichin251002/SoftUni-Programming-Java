package entities;

import lombok.*;
import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;

@Entity
@Table
@Getter
@Setter
public class BetGame implements Serializable {
    @Id
    @OneToOne
    private Game game;

    @Id
    @OneToOne
    private Bet bet;

    @OneToOne
    @JoinColumn
    private ResultPrediction resultPrediction;
}
