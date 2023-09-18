package softuni.gamestore.domain.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "games")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class Game extends BaseEntity {

    @Column(nullable = false, unique = true)
    private String title;

    @Column
    private String trailer;

    @Column
    private String imageThumbnail;

    @Column
    private Float size;

    @Column(nullable = false)
    private BigDecimal price;

    @Column
    private String description;

    @Column
    private LocalDate releaseDate;
}
