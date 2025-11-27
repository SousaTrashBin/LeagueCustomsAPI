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
    public UserDTO registerUser(UserDTO user) {
        if (user.discordId() == null) {
            throw new WebApplicationException("User discord id is empty");
        }
        UserDTO safeDTO = new UserDTO(null, user.discordId(), null, null);
        User savedUser = userService.createUser(UserMapper.fromDTO(safeDTO));
        return new UserDTO(savedUser.getId(), safeDTO.discordId(), null, null);
    }

    /*

    @GET('/:discordId')

    @GET + sorting (possibly filter)

    @DELETE

    @PUT addRiotAccount (should possibly validate with icon)

    @PUT addPlayerToQueue (there should be multiple queues somehow for each gameMode)
     | this should detect automatically if a game should be started (aka if it reaches max players)
     | a player can be in multiple queues at the same time, and the queues should not persist
     | this should then send a match request, which people can either accept or decline
     | (not sure if its better to have everyone accept or at least half).

    @PUT removePlayerFromQueue (...)

    */

}
