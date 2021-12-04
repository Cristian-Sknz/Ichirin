package me.skiincraft.ichirin.models.data.user.impl;

import lombok.Data;
import lombok.NoArgsConstructor;
import me.skiincraft.ichirin.entity.user.IchirinUser;
import me.skiincraft.ichirin.models.data.user.UserShort;

import java.time.OffsetDateTime;

@Data
@NoArgsConstructor
public class UserShortImpl implements UserShort {

    protected static final String AVATAR_URL = "/api/avatar/user/image/%s";

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
        this.avatarUrl = String.format(AVATAR_URL, user.getId());
        this.createdDate = user.getCreatedDate();
        this.lastLogin = user.getLastLogin();
    }
}
