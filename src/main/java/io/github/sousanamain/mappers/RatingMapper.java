package io.github.sousanamain.mappers;

import io.github.sousanamain.dtos.RatingDTO;
import io.github.sousanamain.entities.Rating;

public class RatingMapper {
    public static Rating fromDTO(RatingDTO rating) {
        return new Rating(rating.victories(), rating.losses(), rating.mmr());
    }
}
