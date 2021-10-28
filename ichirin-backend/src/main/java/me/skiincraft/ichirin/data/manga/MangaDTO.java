package me.skiincraft.ichirin.data.manga;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.*;
import java.util.List;

public class MangaDTO {

    @NotBlank(message = "validation.manga.name")
    private String name;
    @NotBlank(message = "validation.manga.image")
    private String imageUrl;
    @NotBlank(message = "validation.manga.summary")
    private String summary;

    @PositiveOrZero(message = "validation.manga.type")
    @Max(value = 4, message = "validation.manga.type")
    @NotNull(message = "validation.manga.type")
    private int mangaType;

    @PositiveOrZero(message = "validation.manga.status")
    @Max(value = 4, message = "validation.manga.status")
    @NotNull(message = "validation.manga.status")
    private int mangaStatus;

    @Size(min = 1, max = 4, message = "validation.manga.alternative-names")
    private List<String> alternativeNames;

    @Size(min = 1, max = 4, message = "validation.manga.authors")
    @NotNull(message = "validation.manga.authors")
    private List<String> authors;

    @Size(min = 1, max = 4, message = "validation.manga.artists")
    @NotNull(message = "validation.manga.artists")
    private List<String> artists;

    @NotBlank(message = "validation.manga.date")
    @Length(min = 8, message = "validation.manga.date")
    private String releaseDate;

    public MangaDTO() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public int getMangaType() {
        return mangaType;
    }

    public void setMangaType(int mangaType) {
        this.mangaType = mangaType;
    }

    public int getMangaStatus() {
        return mangaStatus;
    }

    public void setMangaStatus(int mangaStatus) {
        this.mangaStatus = mangaStatus;
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

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }
}
