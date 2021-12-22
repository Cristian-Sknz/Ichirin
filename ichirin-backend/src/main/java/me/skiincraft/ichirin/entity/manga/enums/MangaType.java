package me.skiincraft.ichirin.entity.manga.enums;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
@Getter
@AllArgsConstructor
public enum MangaType {

    MANGA(0, "Mangá"),
    MANHUA(1, "Manhua"),
    MANHWA(2, "Manhwa"),
    WEBTOON(3, "Webtoon"),
    ONESHOT(4, "One-shot");

    private final int id;
    private final String name;

    public static MangaType getById(int id) {
        return Arrays.stream(values()).filter(type -> type.id == id).findFirst().orElse(null);
    }
}
