package io.github.sousanamain.mappers;

import io.github.sousanamain.dtos.UserDTO;
import io.github.sousanamain.entities.RiotAccount;
import io.github.sousanamain.entities.User;

import java.util.Set;
import java.util.stream.Collectors;

public class UserMapper {
    public static User fromDTO(UserDTO dto) {
        Set<RiotAccount> riotAccounts = dto.riotAccounts().stream().map(RiotAccountMapper::fromInfoDTO).collect(Collectors.toSet());
        return new User(dto.id(), dto.discordId(), RatingMapper.fromDTO(dto.rating()), riotAccounts);
    }

    public static UserDTO toDTO(User userDTO) {
        return null;
    }
}
