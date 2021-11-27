package me.skiincraft.ichirin.entity.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import me.skiincraft.ichirin.entity.manga.Manga;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.time.Clock;
import java.time.OffsetDateTime;
import java.util.Objects;
import java.util.Set;

@Entity

@Getter
@Setter
public class UserFavorite {


    @Id
    @Column(name = "user_id") private Long id;
    @Column(name = "last_update")
    private OffsetDateTime lastUpdate;

    @MapsId @OneToOne
    @JsonIgnore @JoinColumn(name = "user_id")
    private IchirinUser user;
    @ManyToMany
    @JoinTable(name = "user_favorite_mangas",
            joinColumns = { @JoinColumn(name = "manga_id") },
            inverseJoinColumns = { @JoinColumn(name = "favorite_id") })
    private Set<Manga> mangas;

    public UserFavorite() {
        this.lastUpdate = OffsetDateTime.now(Clock.systemUTC());
    }

    public UserFavorite(IchirinUser user) {
        this();
        this.user = user;
    }

    public void addManga(Manga manga) {
        this.mangas.add(manga);
    }

    public void removeManga(Manga manga) {
        this.mangas.remove(manga);
    }

    @PrePersist
    @PreUpdate
    public void update() {
        this.lastUpdate = OffsetDateTime.now(Clock.systemUTC());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        UserFavorite that = (UserFavorite) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
