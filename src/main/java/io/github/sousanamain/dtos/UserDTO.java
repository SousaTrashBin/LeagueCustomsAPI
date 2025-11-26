package io.github.sousanamain.dtos;

import io.github.sousanamain.entities.User;

import java.io.Serializable;
import java.util.Set;

/**
 * DTO for {@link User}
 */
public record UserDTO(Long id, String discordId, RatingDTO rating,
                      Set<RiotAccountInfoDTO> riotAccounts) implements Serializable {
}