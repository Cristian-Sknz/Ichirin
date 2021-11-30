package me.skiincraft.ichirin.entity.manga.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum MangaDescriptionType {

    MARKDOWN(0, "Markdown"), PLAIN_TEXT(1, "Plain Text");

    private long id;
    private String name;
}