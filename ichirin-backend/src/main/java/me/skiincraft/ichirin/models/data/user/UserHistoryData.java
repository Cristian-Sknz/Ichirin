package me.skiincraft.ichirin.models.data.user;

import me.skiincraft.ichirin.entity.manga.Manga;
import me.skiincraft.ichirin.entity.user.IchirinUser;
import me.skiincraft.ichirin.models.data.manga.MangaCompact;
import me.skiincraft.ichirin.models.data.user.impl.UserHistoryDataImpl;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UserHistoryData extends UserCompact {

    Page<MangaCompact> getMangas();

    static UserHistoryData of(IchirinUser user, List<Manga> mangaList, Pageable pageable) {
        return new UserHistoryDataImpl(user, new PageImpl<>(mangaList, pageable, mangaList.size()).map(MangaCompact::of));
    }
}
