package me.skiincraft.ichirin.models.data.user.impl;

import lombok.Data;
import lombok.EqualsAndHashCode;
import me.skiincraft.ichirin.entity.user.IchirinUser;
import me.skiincraft.ichirin.entity.user.UserConfiguration;
import me.skiincraft.ichirin.models.data.manga.MangaCompact;
import me.skiincraft.ichirin.models.data.user.UserData;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
public class UserDataImpl extends UserCompactImpl implements UserData {

    private String email;
    private List<MangaCompact> favorites;
    private List<MangaCompact> history;
    private UserConfiguration configuration;

    public UserDataImpl(IchirinUser ichirinUser, List<MangaCompact> favorite, List<MangaCompact> history) {
        super(ichirinUser);
        this.email = ichirinUser.getEmail();
        this.history = history;
        this.favorites = favorite;
        this.configuration = ichirinUser.getConfiguration();
    }
}
