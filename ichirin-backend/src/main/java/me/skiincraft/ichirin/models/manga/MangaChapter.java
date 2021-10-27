package me.skiincraft.ichirin.models.manga;

import me.skiincraft.ichirin.data.MangaDTO;

import javax.persistence.*;
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
    private int id;
    private String chapterName;
    private int season;
    private int chapter;

    @ManyToOne
    @MapsId
    private Manga manga;
    private OffsetDateTime releaseDate;

    public int getId() {
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

    public int getChapter() {
        return chapter;
    }

    public void setChapter(int chapter) {
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
}
