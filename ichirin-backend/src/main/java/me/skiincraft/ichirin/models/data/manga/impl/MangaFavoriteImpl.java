package me.skiincraft.ichirin.models.data.manga.impl;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import me.skiincraft.ichirin.entity.manga.Manga;
import me.skiincraft.ichirin.models.data.manga.MangaFavorite;
import me.skiincraft.ichirin.models.data.user.UserShort;
import org.springframework.data.domain.Page;


@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class MangaFavoriteImpl extends MangaShortImpl implements MangaFavorite {

    private Page<UserShort> users;

    public MangaFavoriteImpl(Manga manga, Page<UserShort> users) {
        super(manga);
        this.users = users;
    }
}
