package me.skiincraft.ichirin.models.data.avatar;

import me.skiincraft.ichirin.entity.user.UserAvatar;
import me.skiincraft.ichirin.models.data.avatar.impl.UserAvatarDataImpl;

public interface UserAvatarData {

    long getId();
    String getName();
    String getAvatarUrl();
    String getContentType();
    long getSize();

    static UserAvatarData of(UserAvatar avatar) {
        return new UserAvatarDataImpl(avatar);
    }
}
