package me.skiincraft.ichirin.models.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import me.skiincraft.ichirin.data.IchirinUserDTO;
import me.skiincraft.ichirin.models.manga.Manga;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.time.Clock;
import java.time.OffsetDateTime;
import java.util.Objects;
import java.util.Set;

/** <h2>UserHistory</h2>
 *  <p>Entidade responsável em registrar o histórico de leitura de um usuário.</p>
 *
 * @see IchirinUser User
 * @see IchirinUserDTO Data Transfer Object
 */
@Entity
public class UserHistory {

    @Id
    @Column(name = "user_id") private Long id;

    @Column(name = "last_update")
    private OffsetDateTime lastUpdate;

    @MapsId @OneToOne
    @JsonIgnore @JoinColumn(name = "user_id")
    private IchirinUser user;

    @ManyToMany
    @JoinTable(name = "user_history_mangas",
            joinColumns = { @JoinColumn(name = "manga_id") },
            inverseJoinColumns = { @JoinColumn(name = "history_id") })
    private Set<Manga> mangas;

    public UserHistory() {
        this.lastUpdate = OffsetDateTime.now(Clock.systemUTC());
    }

    public UserHistory(IchirinUser user) {
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

    public OffsetDateTime getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(OffsetDateTime lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public Set<Manga> getMangas() {
        return mangas;
    }

    public void setMangas(Set<Manga> mangas) {
        this.mangas = mangas;
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
        UserHistory history = (UserHistory) o;
        return id != null && Objects.equals(id, history.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
