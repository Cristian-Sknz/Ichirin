package me.skiincraft.ichirin.controller.impl;

import me.skiincraft.ichirin.entity.user.IchirinUser;
import me.skiincraft.ichirin.entity.user.UserCommentary;
import me.skiincraft.ichirin.entity.user.UserFavorite;
import me.skiincraft.ichirin.entity.user.UserHistory;
import me.skiincraft.ichirin.models.SimpleAuthenticatedUser;
import me.skiincraft.ichirin.models.dto.UserCommentaryDTO;
import me.skiincraft.ichirin.service.CommentaryService;
import me.skiincraft.ichirin.service.FavoriteService;
import me.skiincraft.ichirin.service.UserHistoryService;
import me.skiincraft.ichirin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public IchirinUser getUserById() {
        return super.getUserById(getAuthenticatedUser().getUserId());
    }

    @Override
    @GetMapping("/me/favorites")
    public UserFavorite getUserFavorites() {
        return super.getUserFavorites(getAuthenticatedUser().getUserId());
    }

    @Override
    @PostMapping("/me/favorites/{mangaId}")
    public UserFavorite addToUserFavorites(Long mangaId) {
        return super.addToUserFavorites(getAuthenticatedUser().getUserId(), mangaId);
    }

    @Override
    @DeleteMapping("/me/favorites/{mangaId}")
    public UserFavorite removeToUserFavorites(Long mangaId) {
        return super.removeToUserFavorites(getAuthenticatedUser().getUserId(), mangaId);
    }

    @Override
    @GetMapping("/me/history")
    public UserHistory getUserHistory() {
        return super.getUserHistory(getAuthenticatedUser().getUserId());
    }

    @Override
    @PostMapping("/me/history/{mangaId}")
    public UserHistory addToUserHistory(Long mangaId) {
        return super.addToUserHistory(getAuthenticatedUser().getUserId(), mangaId);
    }

    @Override
    @DeleteMapping("/me/history/{mangaId}")
    public UserHistory removeFromUserHistory(Long mangaId) {
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
