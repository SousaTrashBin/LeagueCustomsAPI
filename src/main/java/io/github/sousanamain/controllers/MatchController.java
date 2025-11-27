package io.github.sousanamain.controllers;

import io.github.sousanamain.services.MatchService;
import jakarta.inject.Inject;
import jakarta.ws.rs.Path;

@Path("matches")
public class MatchController {
    @Inject
    MatchService matchService;

    //@POST createMatch (which should create a "lobby" aka match lobby)

    //@POST startMatch (which should start a "match" possibly filling some information about players)

    //@POST endMatch (which should end a match and fill the missing details from
    // the match as well as all the stats from each player)

    //@PUT finishSeason (possible season reset)
}
