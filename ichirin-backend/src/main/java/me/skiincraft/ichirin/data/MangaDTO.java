package me.skiincraft.ichirin.data;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.*;
import java.util.List;

public class MangaDTO {

    @NotBlank
    private String name;
    @NotBlank
    private String imageUrl;
    @NotBlank
    private String summary;

    @PositiveOrZero
    @Max(4)
    private int mangaType;

    @PositiveOrZero
    @Max(4)
    private int mangaStatus;

    private List<String> alternativeNames;
    @Size(min = 1, max = 4)
    @NotNull
    private List<String> authors;

    @Size(min = 1, max = 4)
    @NotNull
    private List<String> artists;

    @NotBlank
    @Length(min = 8)
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
