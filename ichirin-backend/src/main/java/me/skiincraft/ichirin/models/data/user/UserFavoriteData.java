package me.skiincraft.ichirin.models.data.user;

import me.skiincraft.ichirin.entity.manga.Manga;
import me.skiincraft.ichirin.entity.user.IchirinUser;
import me.skiincraft.ichirin.models.data.manga.MangaCompact;
import me.skiincraft.ichirin.models.data.user.impl.UserFavoriteDataImpl;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UserFavoriteData extends UserCompact {

    Page<MangaCompact> getMangas();

    static UserFavoriteData of(IchirinUser favorite, List<Manga> mangaList, Pageable pageable) {
        return new UserFavoriteDataImpl(favorite, new PageImpl<>(mangaList, pageable, mangaList.size()).map(MangaCompact::of));
    }

}
