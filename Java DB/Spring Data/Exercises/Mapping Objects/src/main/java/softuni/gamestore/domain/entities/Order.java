package softuni.gamestore.domain.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@Table(name = "orders")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Order extends BaseEntity {
    @ManyToOne
    private User user;

    @ManyToMany(targetEntity = Game.class, fetch = FetchType.EAGER)
    private Set<Game> games;
}
