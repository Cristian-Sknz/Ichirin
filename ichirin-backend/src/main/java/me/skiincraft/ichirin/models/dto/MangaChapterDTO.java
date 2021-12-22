package me.skiincraft.ichirin.models.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

@Data
@NoArgsConstructor
public class MangaChapterDTO {

    @NotBlank(message = "validation.chapter.name")
    private String name;

    @NotBlank(message = "validation.chapter.summary")
    private String summary;

    @PositiveOrZero(message = "validation.chapter.season")
    @NotNull(message = "validation.chapter.season")
    private int season;

    @PositiveOrZero(message = "validation.chapter.chapter")
    @NotNull(message = "validation.chapter.season")
    private float chapter;

    private String releaseDate;
}
