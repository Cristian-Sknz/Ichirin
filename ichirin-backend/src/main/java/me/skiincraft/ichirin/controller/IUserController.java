package me.skiincraft.ichirin.controller;

import me.skiincraft.ichirin.entity.user.UserCommentary;
import me.skiincraft.ichirin.models.data.DataType;
import me.skiincraft.ichirin.models.data.user.UserFavoriteData;
import me.skiincraft.ichirin.models.data.user.UserHistoryData;
import me.skiincraft.ichirin.models.data.user.UserCompact;
import me.skiincraft.ichirin.models.dto.UserCommentaryDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Collection;

public interface IUserController {

    Page<? extends UserCompact> getUsers(DataType type, Pageable pageable);

    default UserCompact getUserById(DataType type) {
        throw new UnsupportedOperationException();
    }

    UserCompact getUserById(DataType type, @PathVariable Long userId);

    default UserFavoriteData getUserFavorites(Pageable pageable) {
        throw new UnsupportedOperationException();
    }

    UserFavoriteData getUserFavorites(@PathVariable Long userId, Pageable pageable);

    default UserFavoriteData addToUserFavorites(@PathVariable Long mangaId) {
        throw new UnsupportedOperationException();
    }

    UserFavoriteData addToUserFavorites(@PathVariable Long userId, @PathVariable Long mangaId);

    default UserFavoriteData removeToUserFavorites(@PathVariable Long mangaId) {
        throw new UnsupportedOperationException();
    }

    UserFavoriteData removeToUserFavorites(@PathVariable Long userId, @PathVariable Long mangaId);

    default UserHistoryData getUserHistory(Pageable pageable) {
        throw new UnsupportedOperationException();
    }

    UserHistoryData getUserHistory(@PathVariable Long userId, Pageable pageable);

    default UserHistoryData addToUserHistory(@PathVariable Long mangaId) {
        throw new UnsupportedOperationException();
    }

    UserHistoryData addToUserHistory(@PathVariable Long userId, @PathVariable Long mangaId);

    default UserHistoryData removeFromUserHistory(@PathVariable Long mangaId) {
        throw new UnsupportedOperationException();
    }

    UserHistoryData removeFromUserHistory(@PathVariable Long userId,
                                          @PathVariable Long mangaId);

    default Collection<UserHistoryData> getAllHistories() {
        throw new UnsupportedOperationException();
    }

    default Collection<UserCommentary> getUserCommentaries() {
        throw new UnsupportedOperationException();
    }

    Collection<UserCommentary> getUserCommentaries(@PathVariable Long userId);

    default Collection<UserCommentary> getUserCommentariesByManga(@PathVariable Long mangaId) {
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

    Object deleteUserCommentary(@PathVariable Long userId, @PathVariable Long mangaId, @PathVariable Long commentId);

    default Object deleteUserCommentary(@PathVariable Long mangaId, @PathVariable Long commentId) {
        throw new UnsupportedOperationException();
    }

}
