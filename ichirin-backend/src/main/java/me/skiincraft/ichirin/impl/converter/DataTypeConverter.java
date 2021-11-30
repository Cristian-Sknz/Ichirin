package me.skiincraft.ichirin.impl.converter;

import me.skiincraft.ichirin.impl.StringConverter;
import me.skiincraft.ichirin.models.data.DataType;

public class DataTypeConverter implements StringConverter<DataType> {

    @Override
    public DataType convert(String source) {
        return DataType.getByName(source);
    }
}
