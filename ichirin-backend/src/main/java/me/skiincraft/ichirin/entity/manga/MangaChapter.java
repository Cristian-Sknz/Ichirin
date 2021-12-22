package me.skiincraft.ichirin.entity.manga;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import me.skiincraft.ichirin.models.dto.MangaChapterDTO;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.time.Clock;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.Objects;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "manga_chapters")
@SequenceGenerator(name = "manga_chapters", sequenceName = "seq_manga_chapters")
public class MangaChapter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "manga_chapters")
    private Long id;
    private String chapterName;
    private int season;
    private float chapter;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "manga_id")
    private Manga manga;

    @Column(name = "created_date")
    private OffsetDateTime createdDate;
    @Column(name = "release_date")
    private OffsetDateTime releaseDate;
    @Column(name = "last_update")
    private OffsetDateTime lastUpdate;

    public MangaChapter(Manga manga, MangaChapterDTO dto) {
        this.chapterName = dto.getName();
        this.chapter = dto.getChapter();
        this.releaseDate = OffsetDateTime.parse(dto.getReleaseDate());
        this.season = dto.getSeason();
        this.manga = manga;
    }

    @PrePersist
    @PreUpdate
    public void update() {
        if (this.createdDate == null)
            this.createdDate = OffsetDateTime.now(Clock.systemUTC());
        this.lastUpdate = OffsetDateTime.now(Clock.systemUTC());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        MangaChapter that = (MangaChapter) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
