package me.skiincraft.ichirin.entity.user.enums;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum ReadingStyle {

    DEFAULT(0, "Padrão"), PAGED(1, "Paginado"), CASCADE(2, "Cascata");

    private final int id;
    private final String name;
}
