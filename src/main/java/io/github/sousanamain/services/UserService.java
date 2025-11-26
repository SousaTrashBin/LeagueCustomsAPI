package io.github.sousanamain.services;

import io.github.sousanamain.entities.User;
import io.github.sousanamain.repositories.UserRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.Response;

@ApplicationScoped
public class UserService {
    @Inject
    UserRepository userRepository;

    @Transactional
    public User createUser(User user) {
        if (userRepository.existsByDiscordId(user.getDiscordId())) {
            throw new WebApplicationException("User with Discord ID " + user.getDiscordId() + " already exists.",
                    Response.Status.CONFLICT);
        }
        userRepository.persist(user);
        return user;
    }
}