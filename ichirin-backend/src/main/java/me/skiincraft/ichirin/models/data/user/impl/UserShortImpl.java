package me.skiincraft.ichirin.models.data.user.impl;

import lombok.Data;
import lombok.NoArgsConstructor;
import me.skiincraft.ichirin.entity.user.IchirinUser;
import me.skiincraft.ichirin.models.data.user.UserShort;

import java.time.OffsetDateTime;

@Data
@NoArgsConstructor
public class UserShortImpl implements UserShort {

    private long id;
    private String name;
    private String nickname;
    private String avatarUrl;
    private OffsetDateTime createdDate;
    private OffsetDateTime lastLogin;

    public UserShortImpl(IchirinUser user) {
        this.id = user.getId();
        this.name = user.getName();
        this.nickname = user.getNickname();
        this.avatarUrl = user.getAvatarUrl();
        this.createdDate = user.getCreatedDate();
        this.lastLogin = user.getLastLogin();
    }
}
