package softuni.gamestore.domain.models;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Map;

@Getter
@Setter
public class GameEditDTO {
    private Long id;
    private String title;
    private BigDecimal price;
    private Float size;
    private String trailer;
    private String imageThumbnail;
    private String description;
    private LocalDate releaseDate;

    public void updateFields(Map<String, String> updatedValues) {
        for (String key : updatedValues.keySet()) {
            switch (key) {
                case "title" -> setTitle(updatedValues.get(key));
                case "price" -> setPrice(new BigDecimal (updatedValues.get(key)));
                case "size" -> setSize(Float.parseFloat(updatedValues.get(key)));
                case "trailer" -> setTrailer(updatedValues.get(key));
                case "imageThumbnail" -> setImageThumbnail(updatedValues.get(key));
                case "description" -> setDescription(updatedValues.get(key));
                case "releaseDate" -> setReleaseDate(LocalDate.parse(updatedValues.get(key)));
            }
        }
    }
}
