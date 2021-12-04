package me.skiincraft.ichirin.controller.impl;

import me.skiincraft.ichirin.controller.IAvatarController;
import me.skiincraft.ichirin.models.data.avatar.UserAvatarData;
import me.skiincraft.ichirin.service.AvatarService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

public abstract class DynamicAvatarController implements IAvatarController {

    private final AvatarService avatarService;

    public DynamicAvatarController(AvatarService avatarService) {
        this.avatarService = avatarService;
    }

    @Override
    @GetMapping("/user/{userId}/image")
    public ResponseEntity<byte[]> getUserAvatarImage(@PathVariable Long userId) {
        try {
            var avatar = avatarService.getUserAvatar(userId);
            return ResponseEntity.ok()
                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + avatar.getUser().getNickname() + "\"")
                    .contentType(MediaType.valueOf(avatar.getImage().getContentType()))
                    .body(avatar.getImage().getData());
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.notFound().build();
        }
    }

    @Override
    @GetMapping("/user/{userId}")
    public UserAvatarData getUserAvatar(@PathVariable Long userId) {
        return avatarService.getUserAvatarData(userId);
    }

    @Override
    @PostMapping("/user/{userId}")
    public ResponseEntity<Object> setUserAvatar(@PathVariable Long userId,
                                                @RequestParam(name = "file") MultipartFile file) {
        try {
            return ResponseEntity.ok(avatarService.setUserAvatar(userId, file));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().body(String.format("[%s] Não foi possível dar upload nesta imagem.", file.getOriginalFilename()));
        }
    }
}