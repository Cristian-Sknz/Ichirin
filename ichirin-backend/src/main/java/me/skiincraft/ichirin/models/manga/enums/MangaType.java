package me.skiincraft.ichirin.models.manga.enums;

import java.util.Arrays;

public enum MangaType {
    MANGA(0, "Mangá"),
    MANHUA(1, "Manhua"),
    MANHWA(2, "Manhwa"),
    WEBTOON(3, "Webtoon"),
    ONESHOT(4, "One-shot");

    private int id;
    private String name;

    MangaType(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public static MangaType getById(int id) {
        return Arrays.stream(values()).filter(type -> type.id == id).findFirst().orElse(null);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
