package me.skiincraft.ichirin.entity.user.enums;

public enum ReadingStyle {

    DEFAULT("Padrão"), PAGED("Paginado"), CASCADE("Cascata");

    private String name;

    ReadingStyle(String name) {
        this.name = name;
    }
}
