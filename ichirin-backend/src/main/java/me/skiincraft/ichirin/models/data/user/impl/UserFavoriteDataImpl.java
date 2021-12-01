package me.skiincraft.ichirin.models.data.user.impl;

import lombok.Data;
import lombok.EqualsAndHashCode;
import me.skiincraft.ichirin.entity.user.IchirinUser;
import me.skiincraft.ichirin.models.data.manga.MangaShort;
import me.skiincraft.ichirin.models.data.user.UserFavoriteData;
import org.springframework.data.domain.Page;

@Data
@EqualsAndHashCode(callSuper = true)
public class UserFavoriteDataImpl extends UserShortImpl implements UserFavoriteData {

    private Page<MangaShort> mangas;

    public UserFavoriteDataImpl(IchirinUser user, Page<MangaShort> mangas) {
        super(user);
        this.mangas = mangas;
    }
}
