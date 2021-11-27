package me.skiincraft.ichirin.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import me.skiincraft.ichirin.models.dto.UserCommentaryDTO;
import me.skiincraft.ichirin.entity.user.IchirinUser;
import me.skiincraft.ichirin.entity.user.UserCommentary;
import me.skiincraft.ichirin.entity.user.UserFavorite;
import me.skiincraft.ichirin.entity.user.UserHistory;
import me.skiincraft.ichirin.service.CommentaryService;
import me.skiincraft.ichirin.service.FavoriteService;
import me.skiincraft.ichirin.service.UserHistoryService;
import me.skiincraft.ichirin.service.UserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

public abstract class DynamicUserController {

    protected UserService userService;
    protected UserHistoryService userHistoryService;
    protected CommentaryService commentaryService;
    protected FavoriteService favoriteService;

    public DynamicUserController(UserService userService,
                                 UserHistoryService userHistoryService,
                                 CommentaryService commentaryService,
                                 FavoriteService favoriteService) {
        this.userService = userService;
        this.userHistoryService = userHistoryService;
        this.commentaryService = commentaryService;
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
        return favoriteService.addUserFavorite(userId, mangaId);
    }

    @DeleteMapping(value = "/{userId}/favorites/{mangaId}")
    public UserFavorite removeToUserFavorites(@PathVariable Long userId,
                                              @PathVariable Long mangaId) {
        return favoriteService.removeUserFavorite(userId, mangaId);
    }

    @GetMapping(value = "/{userId}/history")
    public UserHistory getUserHistory(@PathVariable Long userId) {
        return userHistoryService.getUserHistory(userId);
    }

    @PostMapping(value = "/{userId}/history/{mangaId}")
    public UserHistory addToUserHistory(@PathVariable Long userId,
                                        @PathVariable Long mangaId) {
        return userHistoryService.addManga(userId, mangaId);
    }

    @DeleteMapping(value = "/{userId}/history/{mangaId}")
    public UserHistory removeFromUserHistory(@PathVariable Long userId,
                                             @PathVariable Long mangaId) {
        return userHistoryService.removeManga(userId, mangaId);
    }

    @GetMapping(value = "/history")
    public Collection<UserHistory> getAllHistories() {
        return userHistoryService.getAllUserHistory();
    }

    @GetMapping(value = "/{userId}/comments")
    public Collection<UserCommentary> getUserCommentaries(@PathVariable Long userId) {
        return commentaryService.getUserComments(userId);
    }

    @GetMapping(value = "/{userId}/comments/{mangaId}")
    public Collection<UserCommentary> getUserCommentariesByManga(@PathVariable Long userId,
                                                                 @PathVariable Long mangaId) {
        return commentaryService.getUserComments(userId, mangaId);
    }

    @GetMapping(value = "/{userId}/comments/{mangaId}/{commentId}")
    public UserCommentary getUserCommentary(@PathVariable Long userId,
                                            @PathVariable Long mangaId,
                                            @PathVariable Long commentId) {
        return commentaryService.getUserCommentary(userId, mangaId, commentId);
    }

    @PostMapping(value = "/{userId}/comments/{mangaId}")
    public UserCommentary createUserCommentary(@PathVariable Long userId,
                                               @PathVariable Long mangaId,
                                               @Validated @RequestBody UserCommentaryDTO userCommentary) {
        return commentaryService.createUserCommentary(userId, mangaId, userCommentary);
    }

    @DeleteMapping(value = "/{userId}/comments/{mangaId}/{commentId}")
    public Object deleteUserCommentary(@PathVariable Long userId,
                                       @PathVariable Long mangaId,
                                       @PathVariable Long commentId) {
        commentaryService.deleteUserCommentary(userId, mangaId, commentId);
        return new ObjectMapper().createObjectNode().put("response", "ok");
        // TODO mudar as respostas de DELETE
    }
}
