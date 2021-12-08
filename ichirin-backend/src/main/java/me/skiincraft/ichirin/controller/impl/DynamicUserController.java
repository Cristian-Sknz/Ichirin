package me.skiincraft.ichirin.controller.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import me.skiincraft.ichirin.controller.IUserController;
import me.skiincraft.ichirin.entity.user.UserCommentary;
import me.skiincraft.ichirin.models.data.DataType;
import me.skiincraft.ichirin.models.data.user.UserFavoriteData;
import me.skiincraft.ichirin.models.data.user.UserHistoryData;
import me.skiincraft.ichirin.models.data.user.UserShort;
import me.skiincraft.ichirin.models.dto.UserCommentaryDTO;
import me.skiincraft.ichirin.service.CommentaryService;
import me.skiincraft.ichirin.service.FavoriteService;
import me.skiincraft.ichirin.service.UserHistoryService;
import me.skiincraft.ichirin.service.UserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

public abstract class DynamicUserController implements IUserController {

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
    public Page<UserShort> getUsers(@RequestParam(required = false) DataType type,
                                    Pageable pageable) {
        return userService.getAllUsers(type, pageable);
    }

    @GetMapping(value = "/{userId}")
    public UserShort getUserById(@RequestParam(required = false) DataType type,
                                 @PathVariable Long userId) {
        return userService.getUser(type, userId);
    }

    @GetMapping(value = "/{userId}/favorites")
    public UserFavoriteData getUserFavorites(@PathVariable Long userId,
                                             Pageable pageable) {
        return favoriteService.getUserFavorite(userId, pageable);
    }

    @PostMapping(value = "/{userId}/favorites/{mangaId}")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public UserFavoriteData addToUserFavorites(@PathVariable Long userId,
                                               @PathVariable Long mangaId) {
        return favoriteService.addUserFavorite(userId, mangaId);
    }

    @DeleteMapping(value = "/{userId}/favorites/{mangaId}")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public UserFavoriteData removeToUserFavorites(@PathVariable Long userId,
                                                  @PathVariable Long mangaId) {
        return favoriteService.removeUserFavorite(userId, mangaId);
    }

    @GetMapping(value = "/{userId}/history")
    public UserHistoryData getUserHistory(@PathVariable Long userId, Pageable pageable) {
        return userHistoryService.getUserHistory(userId, pageable);
    }

    @PostMapping(value = "/{userId}/history/{mangaId}")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public UserHistoryData addToUserHistory(@PathVariable Long userId,
                                            @PathVariable Long mangaId) {
        return userHistoryService.addManga(userId, mangaId);
    }

    @DeleteMapping(value = "/{userId}/history/{mangaId}")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public UserHistoryData removeFromUserHistory(@PathVariable Long userId,
                                                 @PathVariable Long mangaId) {
        return userHistoryService.removeManga(userId, mangaId);
    }

    @GetMapping(value = "/history")
    @Deprecated
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public Page<UserHistoryData> getAllHistories(Pageable pageable) {
        return userHistoryService.getAllUserHistory(pageable);
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
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public UserCommentary createUserCommentary(@PathVariable Long userId,
                                               @PathVariable Long mangaId,
                                               @Validated @RequestBody UserCommentaryDTO userCommentary) {
        return commentaryService.createUserCommentary(userId, mangaId, userCommentary);
    }

    @DeleteMapping(value = "/{userId}/comments/{mangaId}/{commentId}")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public Object deleteUserCommentary(@PathVariable Long userId,
                                       @PathVariable Long mangaId,
                                       @PathVariable Long commentId) {
        commentaryService.deleteUserCommentary(userId, mangaId, commentId);
        return new ObjectMapper().createObjectNode().put("response", "ok");
        // TODO mudar as respostas de DELETE
    }
}
