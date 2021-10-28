package me.skiincraft.ichirin.models.manga;

import com.fasterxml.jackson.annotation.JsonIgnore;
import me.skiincraft.ichirin.models.user.IchirinUser;
import me.skiincraft.ichirin.models.user.UserFavorite;

import javax.persistence.*;
import java.util.Set;

/** <h2>MangaFavorite</h2>
 *  <p>Está entidade ficará responsável em registrar quem favoritou algum manga em especifico</p>
 *
 * @see Manga Manga
 * @see IchirinUser User
 */
@Entity
public class MangaFavorite {

    @Id
    @Column(name = "manga_id") private long id;

    @MapsId @OneToOne
    @JsonIgnore @JoinColumn(name = "manga_id")
    private Manga manga;

    @ManyToMany(mappedBy = "mangas")
    private Set<UserFavorite> users;

    public MangaFavorite() {
    }

    public MangaFavorite(Manga manga) {
        this.manga = manga;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Manga getManga() {
        return manga;
    }

    public void setManga(Manga manga) {
        this.manga = manga;
    }

    public Set<UserFavorite> getUsers() {
        return users;
    }

    public void setUsers(Set<UserFavorite> users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "MangaFavorite{" +
                "id=" + id +
                ", manga=" + manga +
                ", users=" + users +
                '}';
    }
}
