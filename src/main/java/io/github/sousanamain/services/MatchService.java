package io.github.sousanamain.services;

import io.github.sousanamain.repositories.MatchRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class MatchService {

    @Inject
    MatchRepository matchRepository;
}
