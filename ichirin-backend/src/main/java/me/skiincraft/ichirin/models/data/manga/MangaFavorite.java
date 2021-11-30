package me.skiincraft.ichirin.models.data.manga;

import java.time.OffsetDateTime;

public interface MangaFavorite {

    long getUserId();
    OffsetDateTime getLastUpdate();
    Object getUser(); //UserShort
    MangaShort getManga();

}
