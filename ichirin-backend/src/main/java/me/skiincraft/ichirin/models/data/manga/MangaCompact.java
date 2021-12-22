package me.skiincraft.ichirin.models.data.manga;

import me.skiincraft.ichirin.entity.manga.Manga;
import me.skiincraft.ichirin.entity.manga.MangaCategory;
import me.skiincraft.ichirin.entity.manga.enums.MangaStatus;
import me.skiincraft.ichirin.entity.manga.enums.MangaType;
import me.skiincraft.ichirin.models.data.manga.impl.MangaCompactImpl;

import java.util.List;

public interface MangaCompact {

    long getId();
    String getName();
    List<String> getAlternativeNames();
    String getImageUrl();
    String getSummary();
    List<MangaCategory> getCategories();
    MangaType getType();
    MangaStatus getStatus();
    String getAuthor();

    static MangaCompact of(Manga manga) {
        return new MangaCompactImpl(manga);
    }
}
