package io.github.sousanamain.repositories;

import io.github.sousanamain.entities.Match;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class MatchRepository implements PanacheRepositoryBase<Match, Long> {
}
