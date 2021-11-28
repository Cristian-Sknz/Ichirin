package me.skiincraft.ichirin.controller;

import me.skiincraft.ichirin.entity.user.IchirinUser;
import me.skiincraft.ichirin.entity.user.UserCommentary;
import me.skiincraft.ichirin.entity.user.UserFavorite;
import me.skiincraft.ichirin.entity.user.UserHistory;
import me.skiincraft.ichirin.models.dto.UserCommentaryDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Collection;

public interface IUserController {

    Page<IchirinUser> getUsers(Pageable pageable);

    default IchirinUser getUserById() {
        throw new UnsupportedOperationException();
    }

    IchirinUser getUserById(@PathVariable Long userId);

    default UserFavorite getUserFavorites() {
        throw new UnsupportedOperationException();
    }

    UserFavorite getUserFavorites(@PathVariable Long userId);

    default UserFavorite addToUserFavorites(@PathVariable Long mangaId) {
        throw new UnsupportedOperationException();
    }

    UserFavorite addToUserFavorites(@PathVariable Long userId, @PathVariable Long mangaId);

    default UserFavorite removeToUserFavorites(@PathVariable Long mangaId) {
        throw new UnsupportedOperationException();
    }

    UserFavorite removeToUserFavorites(@PathVariable Long userId, @PathVariable Long mangaId);

    default UserHistory getUserHistory() {
        throw new UnsupportedOperationException();
    }

    UserHistory getUserHistory(@PathVariable Long userId);

    default UserHistory addToUserHistory(@PathVariable Long mangaId) {
        throw new UnsupportedOperationException();
    }

    UserHistory addToUserHistory(@PathVariable Long userId, @PathVariable Long mangaId);

    default UserHistory removeFromUserHistory(@PathVariable Long mangaId) {
        throw new UnsupportedOperationException();
    }

    UserHistory removeFromUserHistory(@PathVariable Long userId,
                                             @PathVariable Long mangaId);

    default Collection<UserHistory> getAllHistories() {
        throw new UnsupportedOperationException();
    }

    default Collection<UserCommentary> getUserCommentaries() {
        throw new UnsupportedOperationException();
    }

    Collection<UserCommentary> getUserCommentaries(@PathVariable Long userId);

    default Collection<UserCommentary>  getUserCommentariesByManga(@PathVariable Long mangaId) {
        throw new UnsupportedOperationException();
    }

    Collection<UserCommentary> getUserCommentariesByManga(@PathVariable Long userId, @PathVariable Long mangaId);

    default UserCommentary getUserCommentary(@PathVariable Long mangaId, @PathVariable Long commentId) {
        throw new UnsupportedOperationException();
    }

    UserCommentary getUserCommentary(@PathVariable Long userId, @PathVariable Long mangaId, @PathVariable Long commentId);

    default UserCommentary createUserCommentary(@PathVariable Long mangaId, @Validated @RequestBody UserCommentaryDTO userCommentary) {
        throw new UnsupportedOperationException();
    }

    UserCommentary createUserCommentary(@PathVariable Long userId, @PathVariable Long mangaId, @Validated @RequestBody UserCommentaryDTO userCommentary);

    Object deleteUserCommentary(@PathVariable Long userId,  @PathVariable Long mangaId, @PathVariable Long commentId);

    default Object deleteUserCommentary(@PathVariable Long mangaId, @PathVariable Long commentId) {
        throw new UnsupportedOperationException();
    }

}
