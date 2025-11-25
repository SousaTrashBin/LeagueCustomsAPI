package io.github.sousanamain.entities;

import io.github.sousanamain.utils.GameModeEnum;
import io.github.sousanamain.utils.MatchStatusEnum;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "matches")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Match {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(nullable = false)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "game_mode", nullable = false)
    private GameModeEnum gameModeEnum = GameModeEnum.ARAM;

    @Enumerated(EnumType.STRING)
    @Column(name = "match_status",nullable = false)
    private MatchStatusEnum matchStatus = MatchStatusEnum.PENDING;

    @ToString.Exclude
    @ManyToMany
    @Size(max = 10)
    private Set<RiotAccount> riotAccounts = new LinkedHashSet<>();

    @ToString.Exclude
    @OneToMany(mappedBy = "match", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<MatchStats> matchStats = new LinkedHashSet<>();

    public void start() {
        matchStatus = MatchStatusEnum.ON_GOING;
    }

    public void end() {
        matchStatus = MatchStatusEnum.FINISHED;
    }

    public void addRiotAccount(RiotAccount riotAccount) {
        if (riotAccounts.size() < 10) {
            riotAccounts.add(riotAccount);
        }
    }
}
