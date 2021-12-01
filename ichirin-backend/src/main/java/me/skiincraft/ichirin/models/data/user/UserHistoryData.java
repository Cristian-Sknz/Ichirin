package me.skiincraft.ichirin.models.data.user;

import me.skiincraft.ichirin.entity.manga.Manga;
import me.skiincraft.ichirin.entity.user.IchirinUser;
import me.skiincraft.ichirin.models.data.manga.MangaShort;
import me.skiincraft.ichirin.models.data.user.impl.UserHistoryDataImpl;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UserHistoryData extends UserShort {

    Page<MangaShort> getMangas();

    static UserHistoryData of(IchirinUser user, List<Manga> mangaList, Pageable pageable) {
        return new UserHistoryDataImpl(user, new PageImpl<>(mangaList, pageable, mangaList.size()).map(MangaShort::of));
    }
}
