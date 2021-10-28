package me.skiincraft.ichirin.data.manga;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

public class MangaChapterDTO {

    @NotNull(message = "validation.chapter.name")
    private String name;

    @NotBlank(message = "validation.chapter.summary")
    private String summary;

    @PositiveOrZero(message = "validation.chapter.season")
    @NotNull(message = "validation.chapter.season")
    private int season;

    @PositiveOrZero(message = "validation.chapter.chapter")
    @NotNull(message = "validation.chapter.season")
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
