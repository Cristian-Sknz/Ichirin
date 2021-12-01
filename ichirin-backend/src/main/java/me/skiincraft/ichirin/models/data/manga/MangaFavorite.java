package me.skiincraft.ichirin.models.data.manga;

import me.skiincraft.ichirin.entity.manga.Manga;
import me.skiincraft.ichirin.entity.user.IchirinUser;
import me.skiincraft.ichirin.models.data.manga.impl.MangaFavoriteImpl;
import me.skiincraft.ichirin.models.data.user.UserShort;
import org.springframework.data.domain.Page;

public interface MangaFavorite extends MangaShort {

    Page<UserShort> getUsers();

    static MangaFavorite of(Manga manga, Page<IchirinUser> user) {
        return new MangaFavoriteImpl(manga, user.map(UserShort::of));
    }

}
