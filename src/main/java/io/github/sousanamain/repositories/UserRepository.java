package io.github.sousanamain.repositories;

import io.github.sousanamain.entities.User;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class UserRepository implements PanacheRepositoryBase<User, Long> {

    public User findByDiscordId(String discordId) {
        return find("discordId", discordId).firstResult();
    }

    public boolean existsByDiscordId(String discordId) {
        return count("discordId", discordId) > 0;
    }
}