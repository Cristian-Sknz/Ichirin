package me.skiincraft.ichirin.service;

import me.skiincraft.ichirin.entity.IchirinImage;
import me.skiincraft.ichirin.entity.user.UserAvatar;
import me.skiincraft.ichirin.models.data.avatar.UserAvatarData;
import me.skiincraft.ichirin.repository.user.UserAvatarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class AvatarService {

    private final UserService userService;
    private final UserAvatarRepository repository;
    private final ImageService imageService;

    @Autowired
    public AvatarService(UserService userService,
                         UserAvatarRepository repository,
                         ImageService imageService) {
        this.userService = userService;
        this.repository = repository;
        this.imageService = imageService;
    }

    public UserAvatar getUserAvatar(long userId) {
        var user = userService.getUser(userId);
        var avatar = repository.findByUser(user);

        if (avatar.getImage() == null) {
            var defaultAvatar = imageService.getImage("default_avatar");
            avatar.setImage(defaultAvatar);
            return repository.save(avatar);
        }
        return avatar;
    }

    public UserAvatarData getUserAvatarData(long userId) {
        return UserAvatarData.of(getUserAvatar(userId));
    }

    public UserAvatarData setUserAvatar(Long userId, MultipartFile file) throws IOException {
        var user = userService.getUser(userId);
        var avatar = repository.findByUser(user);
        var image = imageService.getImageOrElse(user.getNickname(), () -> new IchirinImage(user.getNickname()));

        image.setData(file.getBytes());
        image.setSize(file.getSize());
        image.setContentType(file.getContentType());

        avatar.setImage(image);
        return UserAvatarData.of(repository.save(avatar));
    }
}