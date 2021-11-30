package me.skiincraft.ichirin.models.data.manga;

import me.skiincraft.ichirin.entity.manga.Manga;
import me.skiincraft.ichirin.entity.manga.MangaChapter;
import me.skiincraft.ichirin.entity.manga.MangaComments;
import me.skiincraft.ichirin.entity.manga.embedded.MangaDates;
import me.skiincraft.ichirin.entity.manga.embedded.MangaInformation;
import me.skiincraft.ichirin.models.data.manga.impl.MangaDataImpl;

import java.util.List;

public interface MangaData extends MangaShort {

    MangaInformation getInformation();
    MangaDates getDates();
    List<MangaChapter> getChapters();
    MangaComments getComments();

    static MangaData of(Manga manga, List<MangaChapter> chapters) {
        return new MangaDataImpl(manga, chapters);
    }
}
