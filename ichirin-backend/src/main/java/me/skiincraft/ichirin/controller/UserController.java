package me.skiincraft.ichirin.controller;

import me.skiincraft.ichirin.models.user.IchirinUser;
import me.skiincraft.ichirin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/users")
public class UserController {

    public UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/api/users/@me")
    public IchirinUser getAuthenticatedUser() {
        return null;
    }

    @GetMapping(value = "/api/users/{id}")
    public IchirinUser getUserById(long id) {
        return null;
    }

}
