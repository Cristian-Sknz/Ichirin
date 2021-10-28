package me.skiincraft.ichirin.data.manga;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PositiveOrZero;

public class MangaChapterDTO {

    @NotBlank
    private String name;
    @NotBlank
    private String summary;
    @PositiveOrZero
    private int season;
    @PositiveOrZero
    private float chapter;

    public MangaChapterDTO() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public int getSeason() {
        return season;
    }

    public void setSeason(int season) {
        this.season = season;
    }

    public float getChapter() {
        return chapter;
    }

    public void setChapter(int chapter) {
        this.chapter = chapter;
    }
}
