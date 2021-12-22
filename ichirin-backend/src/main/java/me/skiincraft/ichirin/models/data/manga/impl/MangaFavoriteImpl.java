package me.skiincraft.ichirin.models.data.manga.impl;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import me.skiincraft.ichirin.entity.manga.Manga;
import me.skiincraft.ichirin.models.data.manga.MangaFavorite;
import me.skiincraft.ichirin.models.data.user.UserCompact;
import org.springframework.data.domain.Page;


@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class MangaFavoriteImpl extends MangaCompactImpl implements MangaFavorite {

    private Page<UserCompact> users;

    public MangaFavoriteImpl(Manga manga, Page<UserCompact> users) {
        super(manga);
        this.users = users;
    }
}
