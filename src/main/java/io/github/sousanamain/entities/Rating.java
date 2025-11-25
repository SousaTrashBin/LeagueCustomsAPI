package io.github.sousanamain.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Table;
import lombok.*;

@Embeddable
@Table(name = "ratings")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Rating {
    @Column(nullable = false)
    private Integer victories = 0;

    @Column(nullable = false)
    private Integer losses = 0;

    @Column(nullable = false)
    private Integer mmr = 0;

    public void addVictory() {
        this.victories++;
    }

    public void addLoss() {
        this.losses++;
    }

    public void updateMMR(Integer mmr) {
        this.mmr += mmr;
    }
}