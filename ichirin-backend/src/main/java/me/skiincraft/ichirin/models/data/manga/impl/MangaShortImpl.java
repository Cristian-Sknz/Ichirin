package me.skiincraft.ichirin.models.data.manga.impl;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;
import me.skiincraft.ichirin.entity.manga.Manga;
import me.skiincraft.ichirin.entity.manga.MangaCategory;
import me.skiincraft.ichirin.entity.manga.enums.MangaStatus;
import me.skiincraft.ichirin.entity.manga.enums.MangaType;
import me.skiincraft.ichirin.models.data.manga.MangaShort;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class MangaShortImpl implements MangaShort {

    private long id;
    private String name;
    private String author;
    private List<String> alternativeNames;
    private String imageUrl;
    private String summary;
    private List<MangaCategory> categories;
    private MangaType type;
    private MangaStatus status;

    @JsonIgnore
    protected Manga manga;

    public MangaShortImpl(Manga manga) {
        this.id = manga.getId();
        this.name = manga.getName();
        this.author = manga.getInformation().getAuthors().get(0);
        this.alternativeNames = manga.getInformation().getAlternativeNames();
        this.imageUrl = manga.getImageUrl();
        this.summary = manga.getSummary();
        this.categories = new ArrayList<>(manga.getCategory());
        this.type = manga.getInformation().getType();
        this.status = manga.getInformation().getStatus();
    }
}
