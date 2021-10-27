package me.skiincraft.ichirin.util;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Converter
public class StringCollectionConverter implements AttributeConverter<String, List<String>> {

    @Override
    public List<String> convertToDatabaseColumn(String attribute) {
        return new ArrayList<>(Arrays.asList(attribute.split(",")));
    }

    @Override
    public String convertToEntityAttribute(List<String> dbData) {
        return String.join(",", dbData);
    }
}
