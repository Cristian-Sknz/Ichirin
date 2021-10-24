package me.skiincraft.ichirin.models.enums;

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

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
