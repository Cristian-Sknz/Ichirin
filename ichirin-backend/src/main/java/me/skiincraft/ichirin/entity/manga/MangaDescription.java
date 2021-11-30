package me.skiincraft.ichirin.entity.manga;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import me.skiincraft.ichirin.entity.manga.enums.MangaDescriptionType;

import javax.persistence.*;
import java.time.Clock;
import java.time.OffsetDateTime;

@Entity
@Getter
@NoArgsConstructor
public class MangaDescription {

    @Id
    @Column(name = "manga_id")
    private Long id;

    @MapsId
    @JsonIgnore
    @OneToOne
    @JoinColumn(name = "manga_id")
    private Manga manga;

    @Enumerated
    private MangaDescriptionType type;

    @Lob
    private String text;
    private OffsetDateTime lastUpdate;

    public MangaDescription(Manga manga, String text, MangaDescriptionType type) {
        this.manga = manga;
        this.text = text;
        this.type= type;
    }

    public MangaDescription(Manga manga, MangaDescriptionType type) {
        this.manga = manga;
        this.text = "";
        this.type= type;
    }

    @PrePersist
    @PreUpdate
    public void update() {
        this.lastUpdate = OffsetDateTime.now(Clock.systemUTC());
    }
}
