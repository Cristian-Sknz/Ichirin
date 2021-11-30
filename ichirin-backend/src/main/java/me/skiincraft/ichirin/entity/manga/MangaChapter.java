package me.skiincraft.ichirin.entity.manga;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import me.skiincraft.ichirin.models.dto.MangaChapterDTO;
import me.skiincraft.ichirin.models.dto.MangaDTO;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.time.Clock;
import java.time.OffsetDateTime;
import java.util.Objects;

/** <h2>MangaChapter</h2>
 *  <p>Está entidade será um capitulo de algum manga, com as informações básicas como:
 *    <ul>
 *        <li>Nome</li>
 *        <li>Numero do capitulo</li>
 *        <li>Temporada</li>
 *    </ul>
 *  </p>
 *
 * @see Manga Manga
 * @see MangaDTO Data Transfer Object
 */
@Entity
@Table(name = "tb_mangas_chapters")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class MangaChapter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
        this.releaseDate = OffsetDateTime.now(Clock.systemUTC());
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
