package me.skiincraft.ichirin.models.data.user.impl;

import lombok.Data;
import lombok.EqualsAndHashCode;
import me.skiincraft.ichirin.entity.user.IchirinUser;
import me.skiincraft.ichirin.entity.user.UserConfiguration;
import me.skiincraft.ichirin.models.data.manga.MangaShort;
import me.skiincraft.ichirin.models.data.user.UserData;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
public class UserDataImpl extends UserShortImpl implements UserData {

    private String email;
    private List<MangaShort> favorites;
    private List<MangaShort> history;
    private UserConfiguration configuration;

    public UserDataImpl(IchirinUser ichirinUser, List<MangaShort> favorite, List<MangaShort> history) {
        super(ichirinUser);
        this.email = ichirinUser.getEmail();
        this.history = history;
        this.favorites = favorite;
        this.configuration = ichirinUser.getConfiguration();
    }
}
