package me.skiincraft.ichirin.models.manga.embedded;

import me.skiincraft.ichirin.data.MangaDTO;
import me.skiincraft.ichirin.util.StringCollectionConverter;
import me.skiincraft.ichirin.models.manga.enums.MangaStatus;
import me.skiincraft.ichirin.models.manga.enums.MangaType;

import javax.persistence.Convert;
import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.util.ArrayList;
import java.util.List;

@Embeddable
public class MangaInformation {

    @Enumerated(EnumType.ORDINAL)
    private MangaType type;
    @Enumerated(EnumType.ORDINAL)
    private MangaStatus status;

    private String rating;

    @Convert(converter = StringCollectionConverter.class)
    private List<String> alternativeNames;
    @Convert(converter = StringCollectionConverter.class)
    private List<String> authors;
    @Convert(converter = StringCollectionConverter.class)
    private List<String> artists;

    public MangaInformation() {
        this.alternativeNames = new ArrayList<>();
        this.authors = new ArrayList<>();
        this.artists = new ArrayList<>();
    }

    public MangaInformation(MangaDTO dto) {
        this.type = MangaType.getById(dto.getMangaType());
        this.status = MangaStatus.getById(dto.getMangaStatus());
        this.authors = dto.getAuthors();
        this.artists = dto.getArtists();
    }
}
