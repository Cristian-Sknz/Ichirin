package me.skiincraft.ichirin.models.data.user;

import me.skiincraft.ichirin.entity.permissions.Role;
import me.skiincraft.ichirin.entity.user.IchirinUser;
import me.skiincraft.ichirin.models.data.user.impl.UserCompactImpl;

import java.time.OffsetDateTime;
import java.util.List;

public interface UserCompact {

    long getId();
    String getName();
    String getNickname();
    String getAvatarUrl();
    OffsetDateTime getCreatedDate();
    OffsetDateTime getLastLogin();
    List<Role> getRoles();

    static UserCompact of(IchirinUser ichirinUser) {
        return new UserCompactImpl(ichirinUser);
    }
}
