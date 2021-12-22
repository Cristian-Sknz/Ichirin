package me.skiincraft.ichirin.controller.impl;

import me.skiincraft.ichirin.entity.user.UserCommentary;
import me.skiincraft.ichirin.models.SimpleAuthenticatedUser;
import me.skiincraft.ichirin.models.data.DataType;
import me.skiincraft.ichirin.models.data.user.UserFavoriteData;
import me.skiincraft.ichirin.models.data.user.UserHistoryData;
import me.skiincraft.ichirin.models.data.user.UserCompact;
import me.skiincraft.ichirin.models.dto.UserCommentaryDTO;
import me.skiincraft.ichirin.service.CommentaryService;
import me.skiincraft.ichirin.service.FavoriteService;
import me.skiincraft.ichirin.service.UserHistoryService;
import me.skiincraft.ichirin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping(value = "/api/users")
public class UserController extends DynamicUserController {

    @Autowired
    public UserController(UserService userService,
                          UserHistoryService userHistoryService,
                          CommentaryService commentaryService,
                          FavoriteService favoriteService) {
        super(userService, userHistoryService, commentaryService, favoriteService);
    }

    @Override
    @GetMapping("/me")
    public UserCompact getUserById(@RequestParam(required = false) DataType type) {
        return super.getUserById(type, getAuthenticatedUser().getUserId());
    }

    @Override
    @GetMapping("/me/favorites")
    public UserFavoriteData getUserFavorites(Pageable pageable) {
        return super.getUserFavorites(getAuthenticatedUser().getUserId(), pageable);
    }

    @Override
    @PostMapping("/me/favorites/{mangaId}")
    public UserFavoriteData addToUserFavorites(Long mangaId) {
        return super.addToUserFavorites(getAuthenticatedUser().getUserId(), mangaId);
    }

    @Override
    @DeleteMapping("/me/favorites/{mangaId}")
    public UserFavoriteData removeToUserFavorites(Long mangaId) {
        return super.removeToUserFavorites(getAuthenticatedUser().getUserId(), mangaId);
    }

    @Override
    @GetMapping("/me/history")
    public UserHistoryData getUserHistory(Pageable pageable) {
        return super.getUserHistory(getAuthenticatedUser().getUserId(), pageable);
    }

    @Override
    @PostMapping("/me/history/{mangaId}")
    public UserHistoryData addToUserHistory(Long mangaId) {
        return super.addToUserHistory(getAuthenticatedUser().getUserId(), mangaId);
    }

    @Override
    @DeleteMapping("/me/history/{mangaId}")
    public UserHistoryData removeFromUserHistory(Long mangaId) {
        return super.removeFromUserHistory(getAuthenticatedUser().getUserId(), mangaId);
    }

    @Override
    @GetMapping("/me/comments")
    public Collection<UserCommentary> getUserCommentaries() {
        return super.getUserCommentaries(getAuthenticatedUser().getUserId());
    }

    @Override
    @GetMapping("/me/comments/{mangaId}")
    public Collection<UserCommentary> getUserCommentariesByManga(Long mangaId) {
        return super.getUserCommentariesByManga(getAuthenticatedUser().getUserId(), mangaId);
    }

    @Override
    @GetMapping("/me/comments/{mangaId}/{commentId}")
    public UserCommentary getUserCommentary(Long mangaId, Long commentId) {
        return super.getUserCommentary(getAuthenticatedUser().getUserId(), mangaId, commentId);
    }

    @Override
    @PostMapping("/me/comments/{mangaId}")
    public UserCommentary createUserCommentary(Long mangaId, UserCommentaryDTO userCommentary) {
        return super.createUserCommentary(getAuthenticatedUser().getUserId(), mangaId, userCommentary);
    }

    @Override
    @DeleteMapping("/me/comments/{mangaId}/{commentId}")
    public Object deleteUserCommentary(Long mangaId, Long commentId) {
        return super.deleteUserCommentary(getAuthenticatedUser().getUserId(), mangaId, commentId);
    }

    private SimpleAuthenticatedUser getAuthenticatedUser() {
        return (SimpleAuthenticatedUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }
}
