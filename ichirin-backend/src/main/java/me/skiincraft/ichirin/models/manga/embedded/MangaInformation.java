package me.skiincraft.ichirin.models.manga.embedded;

import lombok.Data;
import me.skiincraft.ichirin.data.manga.MangaDTO;
import me.skiincraft.ichirin.models.manga.enums.MangaStatus;
import me.skiincraft.ichirin.models.manga.enums.MangaType;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Embeddable
@Data
public class MangaInformation {

    @Enumerated(EnumType.ORDINAL)
    private MangaType type;
    @Enumerated(EnumType.ORDINAL)
    private MangaStatus status;

    private String rating;

    @ElementCollection
    private List<String> alternativeNames;
    @ElementCollection
    private List<String> authors;
    @ElementCollection
    private List<String> artists;

    public MangaInformation() {
        this.alternativeNames = new ArrayList<>();
        this.authors = new ArrayList<>();
        this.artists = new ArrayList<>();
    }

    public MangaInformation(MangaDTO dto) {
        this.type = MangaType.getById(dto.getMangaType());
        this.status = MangaStatus.getById(dto.getMangaStatus());
        this.alternativeNames = dto.getAlternativeNames();
        this.authors = dto.getAuthors();
        this.artists = dto.getArtists();
    }
}
