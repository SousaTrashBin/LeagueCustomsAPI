package io.github.sousanamain.dtos;

import io.github.sousanamain.entities.Rating;

import java.io.Serializable;

/**
 * DTO for {@link Rating}
 */
public record RatingDTO(Integer victories, Integer losses, Integer mmr) implements Serializable {
}