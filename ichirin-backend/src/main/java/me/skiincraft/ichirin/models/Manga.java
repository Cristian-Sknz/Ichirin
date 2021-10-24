package me.skiincraft.ichirin.models;

import me.skiincraft.ichirin.data.converter.StringCollectionConverter;
import me.skiincraft.ichirin.models.enums.MangaStatus;
import me.skiincraft.ichirin.models.enums.MangaType;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.util.List;

@Entity
@Table(name = "tb_mangas")
public class Manga {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String image_url;
    private String summary;

    @Enumerated(EnumType.ORDINAL)
    private MangaType type;
    @Enumerated(EnumType.ORDINAL)
    private MangaStatus status;

    private boolean isAdult;

    @Convert(converter = StringCollectionConverter.class)
    private List<String> alternativeNames;
    @Convert(converter = StringCollectionConverter.class)
    private List<String> authors;
    @Convert(converter = StringCollectionConverter.class)
    private List<String> artists;

    @CreatedDate
    private OffsetDateTime createdTime;
    private LocalDateTime releaseDate;
    @LastModifiedDate
    private OffsetDateTime lastUpdate;

    @OneToMany
    private MangaChapter[] chapters;
}
