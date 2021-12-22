package me.skiincraft.ichirin.models.data.user;

import me.skiincraft.ichirin.entity.user.IchirinUser;
import me.skiincraft.ichirin.entity.user.UserConfiguration;
import me.skiincraft.ichirin.models.data.manga.MangaCompact;
import me.skiincraft.ichirin.models.data.user.impl.UserDataImpl;

import java.util.Collections;
import java.util.List;

public interface UserData extends UserCompact {

    String getEmail();
    UserConfiguration getConfiguration();
    List<MangaCompact> getFavorites();
    List<MangaCompact> getHistory();

    static UserData of(IchirinUser ichirinUser, List<MangaCompact> favorite, List<MangaCompact> history) {
        return new UserDataImpl(ichirinUser, favorite, history);
    }

    static UserData of(IchirinUser ichirinUser) {
        return of(ichirinUser, Collections.emptyList(), Collections.emptyList());
    }
}
