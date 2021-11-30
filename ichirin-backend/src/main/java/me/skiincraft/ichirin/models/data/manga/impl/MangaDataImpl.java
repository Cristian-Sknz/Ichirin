package me.skiincraft.ichirin.models.data.manga.impl;

import lombok.Data;
import lombok.EqualsAndHashCode;
import me.skiincraft.ichirin.entity.manga.Manga;
import me.skiincraft.ichirin.entity.manga.MangaChapter;
import me.skiincraft.ichirin.entity.manga.MangaComments;
import me.skiincraft.ichirin.entity.manga.embedded.MangaDates;
import me.skiincraft.ichirin.entity.manga.embedded.MangaInformation;
import me.skiincraft.ichirin.models.data.manga.MangaData;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
public class MangaDataImpl extends MangaShortImpl implements MangaData {

    private MangaInformation information;
    private MangaDates dates;
    private List<MangaChapter> chapters;
    private MangaComments comments;

    public MangaDataImpl(Manga manga, List<MangaChapter> chapters) {
        super(manga);
        this.information = manga.getInformation();
        this.dates = manga.getDates();
        this.chapters = chapters;
        this.comments = manga.getComments();
    }
}
