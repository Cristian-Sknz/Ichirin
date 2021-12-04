package me.skiincraft.ichirin.controller.impl;

import me.skiincraft.ichirin.models.SimpleAuthenticatedUser;
import me.skiincraft.ichirin.models.data.avatar.UserAvatarData;
import me.skiincraft.ichirin.service.AvatarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/avatar")
public class AvatarController extends DynamicAvatarController {

    @Autowired
    public AvatarController(AvatarService avatarService) {
        super(avatarService);
    }

    @GetMapping("/user/me/image")
    @Override
    public ResponseEntity<byte[]> getUserAvatarImage() {
        return super.getUserAvatarImage(getAuthenticatedUser().getUserId());
    }

    @GetMapping("/user/me")
    @Override
    public UserAvatarData getUserAvatar() {
        return super.getUserAvatar(getAuthenticatedUser().getUserId());
    }

    @PostMapping("/user/me")
    @Override
    public ResponseEntity<Object> setUserAvatar(@RequestParam(name = "file") MultipartFile file) {
        return super.setUserAvatar(getAuthenticatedUser().getUserId(), file);
    }

    private SimpleAuthenticatedUser getAuthenticatedUser() {
        return (SimpleAuthenticatedUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }
}