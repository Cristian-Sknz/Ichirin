package me.skiincraft.ichirin.models.manga;

import me.skiincraft.ichirin.data.manga.MangaChapterDTO;
import me.skiincraft.ichirin.data.manga.MangaDTO;

import javax.persistence.*;
import java.time.Clock;
import java.time.OffsetDateTime;

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
public class MangaChapter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String chapterName;
    private int season;
    private float chapter;

    @ManyToOne
    @JoinColumn(name = "manga_id")
    private Manga manga;

    @Column(name = "created_date")
    private OffsetDateTime createdDate;

    @Column(name = "release_date")
    private OffsetDateTime releaseDate;

    @Column(name = "last_update")
    private OffsetDateTime lastUpdate;

    public MangaChapter() {
    }

    public MangaChapter(Manga manga, MangaChapterDTO dto) {
        this.chapterName = dto.getName();
        this.chapter = dto.getChapter();
        this.releaseDate = OffsetDateTime.now(Clock.systemUTC());
        this.season = dto.getSeason();
        this.manga = manga;
    }

    public long getId() {
        return id;
    }

    public String getChapterName() {
        return chapterName;
    }

    public void setChapterName(String chapterName) {
        this.chapterName = chapterName;
    }

    public int getSeason() {
        return season;
    }

    public void setSeason(int season) {
        this.season = season;
    }

    public float getChapter() {
        return chapter;
    }

    public void setChapter(float chapter) {
        this.chapter = chapter;
    }

    public Manga getManga() {
        return manga;
    }

    public void setManga(Manga manga) {
        this.manga = manga;
    }

    public OffsetDateTime getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(OffsetDateTime releaseDate) {
        this.releaseDate = releaseDate;
    }

    public OffsetDateTime getLastUpdate() {
        return lastUpdate;
    }

    public OffsetDateTime getCreatedDate() {
        return createdDate;
    }

    public void setLastUpdate(OffsetDateTime lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public void setCreatedDate(OffsetDateTime createdDate) {
        this.createdDate = createdDate;
    }

    @PrePersist
    @PreUpdate
    public void update() {
        if (this.createdDate == null)
            this.createdDate = OffsetDateTime.now(Clock.systemUTC());
        this.lastUpdate = OffsetDateTime.now(Clock.systemUTC());
    }
}
