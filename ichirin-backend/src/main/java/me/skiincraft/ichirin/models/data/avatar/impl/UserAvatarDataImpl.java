package me.skiincraft.ichirin.models.data.avatar.impl;

import lombok.Data;
import me.skiincraft.ichirin.entity.user.UserAvatar;
import me.skiincraft.ichirin.models.data.avatar.UserAvatarData;

@Data
public class UserAvatarDataImpl implements UserAvatarData {

    private long id;
    private String name;
    private String avatarUrl;
    private String contentType;
    private long size;

    public UserAvatarDataImpl(UserAvatar avatar) {
        this.id = avatar.getUser().getId();
        this.name = avatar.getUser().getNickname();
        this.avatarUrl = "/api/avatar/user/" + id;
        this.contentType = avatar.getImage().getContentType();
        this.size = avatar.getImage().getSize();
    }
}
