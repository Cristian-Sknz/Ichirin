package me.skiincraft.ichirin.models.manga;

import me.skiincraft.ichirin.data.manga.MangaDTO;
import me.skiincraft.ichirin.models.manga.embedded.MangaDates;
import me.skiincraft.ichirin.models.manga.embedded.MangaInformation;
import me.skiincraft.ichirin.repository.manga.MangaRepository;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

/**
 * <h2>Manga</h2>
 * <p>Está entidade será a referência de todos os mangas,
 * com todas as informações e capítulos.</p>
 *
 * @see MangaRepository Repository
 * @see me.skiincraft.ichirin.service.MangaService Service
 * @see MangaDTO Data Transfer Object
 */
@Entity
@Table(name = "tb_mangas")
public class Manga {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    @Column(name = "image_url")
    private String imageUrl;
    private String summary;

    @Embedded
    private MangaInformation information;

    @Embedded
    private MangaDates dates;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<MangaCategory> category;

    @OneToOne(mappedBy = "manga",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    @PrimaryKeyJoinColumn
    private MangaComments comments;

    public Manga() {
        this.information = new MangaInformation();
        this.dates = new MangaDates();
    }

    public Manga(MangaDTO dto) {
        this.name = dto.getName();
        this.imageUrl = dto.getImageUrl();
        this.summary = dto.getSummary();
        this.information = new MangaInformation(dto);
        this.dates = new MangaDates(dto);
        this.comments = new MangaComments(this);
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public MangaInformation getInformation() {
        return information;
    }

    public void setInformation(MangaInformation information) {
        this.information = information;
    }

    public MangaDates getDates() {
        return dates;
    }

    public void setDates(MangaDates dates) {
        this.dates = dates;
    }

    public void setCategory(Set<MangaCategory> category) {
        this.category = category;
    }

    public Set<MangaCategory> getCategory() {
        return category;
    }

    public MangaComments getComments() {
        return comments;
    }

    public void setComments(MangaComments comments) {
        this.comments = comments;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Manga manga = (Manga) o;
        return id != null && Objects.equals(id, manga.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
