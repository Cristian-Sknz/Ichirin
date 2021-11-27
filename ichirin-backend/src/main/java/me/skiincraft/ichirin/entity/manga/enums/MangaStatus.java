package me.skiincraft.ichirin.entity.manga.enums;

import java.util.Arrays;

public enum MangaStatus {

    COMPLETED(0, "Completo"),
    IN_RELEASED(1, "Em Lançamento"),
    CANCELED(2, "Cancelado"),
    GAP(3, "Hiato"),
    NOT_YET_AIRED(4, "Não lançado");

    private int id;
    private String name;

    MangaStatus(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public static MangaStatus getById(int id) {
        return Arrays.stream(values()).filter(status -> status.id == id).findFirst().orElse(null);
    }
}
