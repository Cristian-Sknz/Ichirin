package me.skiincraft.ichirin.controller;

import me.skiincraft.ichirin.data.IchirinUserDTO;
import me.skiincraft.ichirin.models.user.IchirinUser;
import me.skiincraft.ichirin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    private final UserService service;

    @Autowired
    public AuthController(UserService service) {
        this.service = service;
    }

    @PostMapping("/signin")
    public IchirinUser createUser(@RequestBody @Validated IchirinUserDTO dto) {
        return service.createUser(dto);
    }
}