package me.skiincraft.ichirin.models.data;

import lombok.AllArgsConstructor;
import lombok.Getter;
import me.skiincraft.ichirin.entity.manga.Manga;
import me.skiincraft.ichirin.models.data.manga.MangaData;
import me.skiincraft.ichirin.models.data.manga.MangaShort;

import java.util.Arrays;
import java.util.function.Function;

@Getter
@AllArgsConstructor
public enum DataType {

    SHORT("Short"), FULL("Full");

    private String name;

    public static DataType getByName(String name) {
        return Arrays.stream(values())
                .filter((dataType -> dataType.name.equalsIgnoreCase(name)))
                .findFirst().orElse(SHORT);
    }
}
