package me.skiincraft.ichirin.entity.manga.enums;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
@Getter
@AllArgsConstructor
public enum MangaStatus {

    COMPLETED(0, "Completo"),
    IN_RELEASED(1, "Em Lançamento"),
    CANCELED(2, "Cancelado"),
    GAP(3, "Hiato"),
    NOT_YET_AIRED(4, "Não lançado");

    private final int id;
    private final String name;

    public static MangaStatus getById(int id) {
        return Arrays.stream(values()).filter(status -> status.id == id).findFirst().orElse(null);
    }
}
