package me.skiincraft.ichirin.controller;

import me.skiincraft.ichirin.models.user.IchirinUser;
import me.skiincraft.ichirin.service.UserHistoryService;
import me.skiincraft.ichirin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/users")
public class UserController extends DynamicUserController {

    @Autowired
    public UserController(UserService userService, UserHistoryService userHistoryService) {
        super(userService, userHistoryService);
    }

    @GetMapping(value = "/@me")
    public IchirinUser getUser() {
        return null;
    }

    @GetMapping(value = "/@me/favorites")
    public IchirinUser getUserFavorites() {
        return null;
    }

    @PostMapping(value = "/@me/favorites/{mangaId}")
    public IchirinUser addToUserFavorites() {
        return null;
    }

    @DeleteMapping(value = "/@me/favorites/{mangaId}")
    public IchirinUser removeFromUserFavorites() {
        return null;
    }
}
