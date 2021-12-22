package me.skiincraft.ichirin.models.data.user.impl;

import lombok.Data;
import lombok.NoArgsConstructor;
import me.skiincraft.ichirin.entity.permissions.Role;
import me.skiincraft.ichirin.entity.user.IchirinUser;
import me.skiincraft.ichirin.models.data.user.UserCompact;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class UserCompactImpl implements UserCompact {

    protected static final String AVATAR_URL = "/api/avatar/user/%s/image";

    private long id;
    private String name;
    private String nickname;
    private String avatarUrl;
    private OffsetDateTime createdDate;
    private OffsetDateTime lastLogin;
    private List<Role> roles;

    public UserCompactImpl(IchirinUser user) {
        this.id = user.getId();
        this.name = user.getName();
        this.nickname = user.getNickname();
        this.avatarUrl = String.format(AVATAR_URL, user.getId());
        this.createdDate = user.getCreatedDate();
        this.lastLogin = user.getLastLogin();
        this.roles = new ArrayList<>(user.getRoles());
    }
}
