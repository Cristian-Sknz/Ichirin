package me.skiincraft.ichirin.models.data.manga;

import me.skiincraft.ichirin.entity.manga.Manga;
import me.skiincraft.ichirin.entity.user.IchirinUser;
import me.skiincraft.ichirin.models.data.manga.impl.MangaFavoriteImpl;
import me.skiincraft.ichirin.models.data.user.UserCompact;
import org.springframework.data.domain.Page;

public interface MangaFavorite extends MangaCompact {

    Page<UserCompact> getUsers();

    static MangaFavorite of(Manga manga, Page<IchirinUser> user) {
        return new MangaFavoriteImpl(manga, user.map(UserCompact::of));
    }

}
