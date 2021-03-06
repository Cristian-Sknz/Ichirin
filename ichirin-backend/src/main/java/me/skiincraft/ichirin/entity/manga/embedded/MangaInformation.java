package me.skiincraft.ichirin.entity.manga.embedded;

import lombok.Data;
import me.skiincraft.ichirin.entity.manga.MangaDescription;
import me.skiincraft.ichirin.models.dto.MangaDTO;
import me.skiincraft.ichirin.entity.manga.enums.MangaStatus;
import me.skiincraft.ichirin.entity.manga.enums.MangaType;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Embeddable
@Data
public class MangaInformation {

    @OneToOne(mappedBy = "manga",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    @PrimaryKeyJoinColumn
    private MangaDescription description;

    @Enumerated(EnumType.ORDINAL)
    private MangaType type;
    @Enumerated(EnumType.ORDINAL)
    private MangaStatus status;

    private String rating;

    @ElementCollection
    @CollectionTable(name = "manga_names")
    private List<String> alternativeNames;
    @ElementCollection
    @CollectionTable(name = "manga_authors")
    private List<String> authors;
    @ElementCollection
    @CollectionTable(name = "manga_artists")
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
