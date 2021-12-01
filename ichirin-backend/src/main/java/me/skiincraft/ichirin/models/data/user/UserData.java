package me.skiincraft.ichirin.models.data.user;

import me.skiincraft.ichirin.entity.user.IchirinUser;
import me.skiincraft.ichirin.entity.user.UserConfiguration;
import me.skiincraft.ichirin.models.data.manga.MangaShort;
import me.skiincraft.ichirin.models.data.user.impl.UserDataImpl;

import java.util.Collections;
import java.util.List;

public interface UserData extends UserShort {

    String getEmail();

    UserConfiguration getConfiguration();

    List<MangaShort> getFavorites();

    List<MangaShort> getHistory();

    static UserData of(IchirinUser ichirinUser, List<MangaShort> favorite, List<MangaShort> history) {
        return new UserDataImpl(ichirinUser, favorite, history);
    }

    static UserData of(IchirinUser ichirinUser) {
        return of(ichirinUser, Collections.emptyList(), Collections.emptyList());
    }
}
