package entities;

import entities.enums.ResultPredictionValue;
import lombok.*;
import javax.persistence.*;

@Entity
@Table
@Getter
@Setter
public class ResultPrediction extends BaseEntity {
    @Enumerated(EnumType.STRING)
    private ResultPredictionValue prediction;
}
