package fr.eni.filmothequeapi.dtos;

import fr.eni.filmothequeapi.model.classes.Rating;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class RatingDto {

    private long id;
    private long movieId;
    private int note;
    private String comment;
    private long userId;

    public static List<RatingDto> asDtos(List<Rating> ratings){
        if(ratings.isEmpty()){
            return new ArrayList<>();
        }
        return ratings.stream().map(RatingDto::asDto).collect(Collectors.toList());
    }

    public static RatingDto asDto(Rating rating){
        if(rating == null){
            return new RatingDto();
        }
        return new RatingDto(rating.getId(), rating.getMovie().getId(), rating.getNote(),
                rating.getComment(), rating.getUser().getId());
    }

}
