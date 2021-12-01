package me.skiincraft.ichirin.models.data.user;

import me.skiincraft.ichirin.entity.user.IchirinUser;
import me.skiincraft.ichirin.models.data.user.impl.UserShortImpl;

import java.time.OffsetDateTime;

public interface UserShort {

    long getId();

    String getName();

    String getNickname();

    String getAvatarUrl();

    OffsetDateTime getCreatedDate();

    OffsetDateTime getLastLogin();

    static UserShort of(IchirinUser ichirinUser) {
        return new UserShortImpl(ichirinUser);
    }
}
