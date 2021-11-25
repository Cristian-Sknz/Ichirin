package me.skiincraft.ichirin.data.manga;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.*;
import java.util.List;

@Data
@NoArgsConstructor
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

}
