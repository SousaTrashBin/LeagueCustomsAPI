package io.github.sousanamain;

import io.github.sousanamain.entities.User;
import io.github.sousanamain.services.UserService;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;

@QuarkusTest
public class UserTest {
    @Inject
    UserService userService;
    User dummyUser = User.builder().discordId("dummyPlaceHolder").build();

    @Test
    void testCreateUser() {
        var savedUser = userService.createUser(dummyUser);
        System.out.println(savedUser);
        assert savedUser.getId() != null;
        assert savedUser.getDiscordId() != null && savedUser.getId().equals(dummyUser.getId());
    }
}
