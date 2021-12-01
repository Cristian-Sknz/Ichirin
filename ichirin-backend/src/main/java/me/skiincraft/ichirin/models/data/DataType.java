package me.skiincraft.ichirin.models.data;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

@Getter
@AllArgsConstructor
public enum DataType {

    SHORT("Short"), LIMITED("Limited"), FULL("Full");

    private String name;

    public static DataType getByName(String name) {
        return Arrays.stream(values())
                .filter((dataType -> dataType.name.equalsIgnoreCase(name)))
                .findFirst().orElse(SHORT);
    }
}
