package me.skiincraft.ichirin.entity.manga.enums;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
@Getter
public enum MangaDescriptionType {

    MARKDOWN(0, "Markdown"), PLAIN_TEXT(1, "Plain Text");

    private final long id;
    private final String name;
}