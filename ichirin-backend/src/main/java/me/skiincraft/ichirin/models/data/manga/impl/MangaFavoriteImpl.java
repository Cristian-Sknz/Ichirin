package me.skiincraft.ichirin.models.data.manga.impl;

import lombok.Data;
import lombok.NoArgsConstructor;
import me.skiincraft.ichirin.models.data.manga.MangaFavorite;
import me.skiincraft.ichirin.models.data.manga.MangaShort;

import java.time.OffsetDateTime;

@Data
@NoArgsConstructor
public class MangaFavoriteImpl implements MangaFavorite {

    private long userId;
    private OffsetDateTime lastUpdate;
    private Object user;
    private MangaShort manga;
}
