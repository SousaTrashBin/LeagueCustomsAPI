package io.github.sousanamain.controllers;

import io.github.sousanamain.dtos.UserDTO;
import io.github.sousanamain.entities.User;
import io.github.sousanamain.mappers.UserMapper;
import io.github.sousanamain.services.UserService;
import jakarta.inject.Inject;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.WebApplicationException;

@Path("users")
public class UserController {

    @Inject
    UserService userService;

    @POST
    public UserDTO createUser(UserDTO user) {
        if (user.discordId() == null) {
            throw new WebApplicationException("User discord id is empty");
        }
        UserDTO safeDTO = new UserDTO(null, user.discordId(), null, null);
        User savedUser = userService.createUser(UserMapper.fromDTO(safeDTO));
        return new UserDTO(savedUser.getId(), safeDTO.discordId(), null, null);
    }

    //@GET('/:discordId')

    //@GET + sorting (possibly filter)

    //@DELETE

    //@PUT <- add riot account (should validate with icon)

    //@PUT <- possible season reset
}
