package entities;

import lombok.*;
import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Time;
import java.util.Date;

@Entity
@Table
@Getter
@Setter
public class Bet extends BaseEntity {
    @Column
    private BigDecimal money;

    @Column
    private Time timeOfBet;

    @ManyToOne
    private User user;
}
