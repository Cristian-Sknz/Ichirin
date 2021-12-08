package me.skiincraft.ichirin.entity.manga;

import lombok.*;
import me.skiincraft.ichirin.entity.manga.enums.MangaDescriptionType;
import me.skiincraft.ichirin.models.dto.MangaDTO;
import me.skiincraft.ichirin.entity.manga.embedded.MangaDates;
import me.skiincraft.ichirin.entity.manga.embedded.MangaInformation;
import me.skiincraft.ichirin.repository.manga.MangaRepository;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.HashSet;
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
@Getter
@Setter
@NoArgsConstructor
@SequenceGenerator(name = "manga_sequence", sequenceName = "seq_manga")
@Table(name = "mangas")
public class Manga {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "manga_sequence")
    private Long id;

    private String name;
    @Column(name = "image_url")
    private String imageUrl;
    private String summary;

    @Embedded
    private MangaInformation information;

    @Embedded
    private MangaDates dates;

    @ManyToMany(cascade = CascadeType.ALL,
            fetch = FetchType.EAGER)
    @JoinTable(name = "manga_categories")
    private Set<MangaCategory> category;

    @OneToOne(mappedBy = "manga",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    @PrimaryKeyJoinColumn
    private MangaComments comments;

    public Manga(MangaDTO dto) {
        this.name = dto.getName();
        this.imageUrl = dto.getImageUrl();
        this.summary = dto.getSummary();
        this.information = new MangaInformation(dto);
        this.dates = new MangaDates(dto);
        this.comments = new MangaComments(this);
        this.category = new HashSet<>();
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

    @PrePersist
    public void prePresist() {
        if (this.information.getDescription() == null) {
            this.information.setDescription(new MangaDescription(this, MangaDescriptionType.PLAIN_TEXT));
        }
    }
}
