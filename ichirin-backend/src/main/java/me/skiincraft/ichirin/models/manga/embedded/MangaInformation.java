package me.skiincraft.ichirin.models.manga.embedded;

import me.skiincraft.ichirin.data.manga.MangaDTO;
import me.skiincraft.ichirin.models.manga.enums.MangaStatus;
import me.skiincraft.ichirin.models.manga.enums.MangaType;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Embeddable
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
        this.authors = dto.getAuthors();
        this.artists = dto.getArtists();
    }

    public MangaType getType() {
        return type;
    }

    public void setType(MangaType type) {
        this.type = type;
    }

    public MangaStatus getStatus() {
        return status;
    }

    public void setStatus(MangaStatus status) {
        this.status = status;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public List<String> getAlternativeNames() {
        return alternativeNames;
    }

    public void setAlternativeNames(List<String> alternativeNames) {
        this.alternativeNames = alternativeNames;
    }

    public List<String> getAuthors() {
        return authors;
    }

    public void setAuthors(List<String> authors) {
        this.authors = authors;
    }

    public List<String> getArtists() {
        return artists;
    }

    public void setArtists(List<String> artists) {
        this.artists = artists;
    }
}
