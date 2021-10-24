package me.skiincraft.ichirin.models.enums;

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
}
