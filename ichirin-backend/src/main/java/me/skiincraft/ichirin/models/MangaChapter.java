package me.skiincraft.ichirin.models;

import javax.persistence.*;
import java.time.OffsetDateTime;

@Entity
@Table(name = "tb_mangas_chapters")
public class MangaChapter {

    @Id
    private int id;
    private String chapterName;

    @ManyToOne
    @MapsId
    private Manga manga;
    private OffsetDateTime releaseDate;
}
