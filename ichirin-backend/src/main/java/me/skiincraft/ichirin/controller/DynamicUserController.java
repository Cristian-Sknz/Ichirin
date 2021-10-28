package me.skiincraft.ichirin.controller;

import me.skiincraft.ichirin.models.user.IchirinUser;
import me.skiincraft.ichirin.models.user.UserHistory;
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

    public DynamicUserController(UserService userService, UserHistoryService userHistoryService) {
        this.userService = userService;
        this.userHistoryService = userHistoryService;
    }

    @GetMapping(value = "")
    public Page<IchirinUser> getUsers(Pageable pageable) {
        return userService.getAllUsers(pageable);
    }

    @GetMapping(value = "/{userId}")
    public IchirinUser getUserById(long userId) {
        return userService.getUser(userId);
    }

    @GetMapping(value = "/{userId}/favorites")
    public IchirinUser getUserFavorites(long userId) {
        return null;
    }

    @PostMapping(value = "/{userId}/favorites")
    public IchirinUser addToUserFavorites(long userId, long mangaId) {
        return null;
    }

    @DeleteMapping(value = "/{userId}/favorites")
    public IchirinUser removeToUserFavorites(long userId, long mangaId) {
        return null;
    }

    @GetMapping(value = "/{userId}/history")
    public UserHistory getUserHistory(@PathVariable Long userId) {
        return userHistoryService.getUserHistory(userId);
    }

    @PostMapping(value = "/{userId}/history/{mangaId}")
    public UserHistory addToUserHistory(@PathVariable Long userId, @PathVariable Long mangaId) {
        return userHistoryService.addToUserHistory(userId, mangaId);
    }

    @GetMapping(value = "/history")
    public Collection<UserHistory> getAllHistories() {
        return userHistoryService.getAllUserHistory();
    }
}
