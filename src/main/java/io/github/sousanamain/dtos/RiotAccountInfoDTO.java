package io.github.sousanamain.dtos;

import io.github.sousanamain.entities.RiotAccount;

import java.io.Serializable;

/**
 * DTO for {@link RiotAccount}
 */
public record RiotAccountInfoDTO(Long id, String puuid, String name, String tag) implements Serializable {
}