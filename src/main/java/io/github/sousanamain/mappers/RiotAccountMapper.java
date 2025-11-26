package io.github.sousanamain.mappers;

import io.github.sousanamain.dtos.RiotAccountInfoDTO;
import io.github.sousanamain.entities.RiotAccount;

public class RiotAccountMapper {
    public static RiotAccount fromInfoDTO(RiotAccountInfoDTO riotAccountInfoDTO) {
        return RiotAccount.builder()
                .id(riotAccountInfoDTO.id())
                .puuid(riotAccountInfoDTO.puuid())
                .name(riotAccountInfoDTO.name())
                .tag(riotAccountInfoDTO.tag())
                .build();
    }
}
