package softuni.gamestore.domain.models;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.regex.Pattern;

import static softuni.gamestore.constants.ErrorMessages.*;
import static softuni.gamestore.constants.Validations.GAME_TITLE_PATTERN;
import static softuni.gamestore.constants.Validations.GAME_URL_PATTERN;

@Builder
@Getter
@Setter
public class GameAddDTO {
    private String title;
    private BigDecimal price;
    private Float size;
    private String trailer;
    private String imageThumbnail;
    private String description;
    private LocalDate releaseDate;

    public GameAddDTO(String title, BigDecimal price, Float size, String trailer, String thumbnailURL, String description, LocalDate releaseDate) {
        this.title = title;
        this.price = price;
        this.size = size;
        this.trailer = trailer;
        this.imageThumbnail = thumbnailURL;
        this.description = description;
        this.releaseDate = releaseDate;

        validate();
    }

    private void validate() {
        if (!Pattern.matches(GAME_TITLE_PATTERN, this.title)) {
            throw new IllegalArgumentException(INVALID_GAME_TITLE);
        }

        if (this.price.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException(INVALID_GAME_PRICE);
        }

        if (this.size < 0) {
            throw new IllegalArgumentException(INVALID_GAME_SIZE);
        }

        if (this.trailer.length() != 11) {
            throw new IllegalArgumentException(INVALID_GAME_TRAILER);
        }

        if (!Pattern.matches(GAME_URL_PATTERN, this.imageThumbnail)) {
            throw new IllegalArgumentException(INVALID_GAME_URL);
        }

        if (this.description.length() < 20) {
            throw new IllegalArgumentException(INVALID_GAME_DESCRIPTION);
        }
    }
}
