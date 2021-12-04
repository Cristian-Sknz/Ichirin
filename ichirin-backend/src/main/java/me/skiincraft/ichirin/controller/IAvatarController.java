package me.skiincraft.ichirin.controller;

import me.skiincraft.ichirin.models.data.avatar.UserAvatarData;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

public interface IAvatarController {

    default ResponseEntity<byte[]> getUserAvatarImage() {
        throw new UnsupportedOperationException();
    }
    ResponseEntity<byte[]> getUserAvatarImage(Long userId);

    default UserAvatarData getUserAvatar() {
        throw new UnsupportedOperationException();
    }
    UserAvatarData getUserAvatar(Long userId);

    default ResponseEntity<Object> setUserAvatar(MultipartFile file) {
        throw new UnsupportedOperationException();
    }
    ResponseEntity<Object> setUserAvatar(Long userId, MultipartFile file);

}