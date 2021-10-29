package me.skiincraft.ichirin.controller;

import me.skiincraft.ichirin.models.user.IchirinUser;
import me.skiincraft.ichirin.models.user.UserFavorite;
import me.skiincraft.ichirin.models.user.UserHistory;
import me.skiincraft.ichirin.service.FavoriteService;
import me.skiincraft.ichirin.service.UserHistoryService;
import me.skiincraft.ichirin.service.UserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collection;

public abstract class DynamicUserController {

    protected UserService userService;
    protected UserHistoryService userHistoryService;
    protected FavoriteService favoriteService;

    public DynamicUserController(UserService userService,
                                 UserHistoryService userHistoryService,
                                 FavoriteService favoriteService) {
        this.userService = userService;
        this.userHistoryService = userHistoryService;
        this.favoriteService = favoriteService;
    }

    @GetMapping(value = "")
    public Page<IchirinUser> getUsers(Pageable pageable) {
        return userService.getAllUsers(pageable);
    }

    @GetMapping(value = "/{userId}")
    public IchirinUser getUserById(@PathVariable Long userId) {
        return userService.getUser(userId);
    }

    @GetMapping(value = "/{userId}/favorites")
    public UserFavorite getUserFavorites(@PathVariable Long userId) {
        return favoriteService.getUserFavorite(userId);
    }

    @PostMapping(value = "/{userId}/favorites/{mangaId}")
    public UserFavorite addToUserFavorites(@PathVariable Long userId,
                                           @PathVariable Long mangaId) {
        return favoriteService.addToUserFavorites(userId, mangaId);
    }

    @DeleteMapping(value = "/{userId}/favorites/{mangaId}")
    public UserFavorite removeToUserFavorites(@PathVariable Long userId,
                                             @PathVariable Long mangaId) {
        return favoriteService.removeFromUserFavorites(userId, mangaId);
    }

    @GetMapping(value = "/{userId}/history")
    public UserHistory getUserHistory(@PathVariable Long userId) {
        return userHistoryService.getUserHistory(userId);
    }

    @PostMapping(value = "/{userId}/history/{mangaId}")
    public UserHistory addToUserHistory(@PathVariable Long userId,
                                        @PathVariable Long mangaId) {
        return userHistoryService.addToUserHistory(userId, mangaId);
    }

    @DeleteMapping(value = "/{userId}/history/{mangaId}")
    public UserHistory removeFromUserHistory(@PathVariable Long userId,
                                        @PathVariable Long mangaId) {
        return userHistoryService.removeFromUserHistory(userId, mangaId);
    }

    @GetMapping(value = "/history")
    public Collection<UserHistory> getAllHistories() {
        return userHistoryService.getAllUserHistory();
    }
}
