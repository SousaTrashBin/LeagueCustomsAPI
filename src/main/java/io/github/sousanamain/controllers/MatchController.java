package io.github.sousanamain.controllers;

import io.github.sousanamain.services.MatchService;
import jakarta.inject.Inject;
import jakarta.ws.rs.Path;

@Path("matches")
public class MatchController {
    @Inject
    MatchService matchService;
}
