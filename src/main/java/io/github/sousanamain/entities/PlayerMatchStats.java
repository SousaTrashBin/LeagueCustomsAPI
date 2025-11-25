package io.github.sousanamain.entities;

import io.github.sousanamain.utils.TeamSideEnum;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.proxy.HibernateProxy;

import java.util.Objects;

@Entity
@Table(name = "player_match_stats")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PlayerMatchStats {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(nullable = false)
    private Long id;

    @Column(nullable = false)
    private Integer kills = 0;

    @Column(nullable = false)
    private Integer deaths = 0;

    @Column(nullable = false)
    private Integer assists = 0;

    @Column(name = "total_damage_dealt_to_champs", nullable = false)
    private Double totalDamageToChampions = 0.0;

    @Column(name = "troll_pings", nullable = false)
    private Integer trollPings = 0;

    @Column(name = "champion_name", nullable = false)
    private String championName;

    @Column(name = "team_side", nullable = false)
    private TeamSideEnum teamSide;

    @ManyToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "match", nullable = false)
    private Match match;

    @ManyToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "riot_account", nullable = false)
    private RiotAccount riotAccount;

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
        if (thisEffectiveClass != oEffectiveClass) return false;
        PlayerMatchStats that = (PlayerMatchStats) o;
        return getId() != null && Objects.equals(getId(), that.getId());
    }

    @Override
    public final int hashCode() {
        return this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass().hashCode() : getClass().hashCode();
    }
}
