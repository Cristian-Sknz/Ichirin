package me.skiincraft.ichirin.models.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import me.skiincraft.ichirin.models.manga.MangaFavorite;

import javax.persistence.*;
import java.time.Clock;
import java.time.OffsetDateTime;
import java.util.Set;

@Entity
public class UserFavorite {


    @Id
    @Column(name = "user_id") private long id;

    @MapsId @OneToOne
    @JsonIgnore @JoinColumn(name = "user_id")
    private IchirinUser user;

    @ManyToMany
    private Set<MangaFavorite> mangas;
    private OffsetDateTime lastUpdate;

    public UserFavorite() {
        this.lastUpdate = OffsetDateTime.now(Clock.systemUTC());
    }

    public UserFavorite(IchirinUser user) {
        this();
        this.user = user;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public IchirinUser getUser() {
        return user;
    }

    public void setUser(IchirinUser user) {
        this.user = user;
    }

    public Set<MangaFavorite> getMangas() {
        return mangas;
    }

    public void setMangas(Set<MangaFavorite> mangas) {
        this.mangas = mangas;
    }

    public OffsetDateTime getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(OffsetDateTime lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    @Override
    public String toString() {
        return "UserFavorite{" +
                "id=" + id +
                ", user=" + user +
                ", mangas=" + mangas +
                ", lastUpdate=" + lastUpdate +
                '}';
    }
}
