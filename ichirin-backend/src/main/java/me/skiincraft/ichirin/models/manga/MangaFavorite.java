package me.skiincraft.ichirin.models.manga;

import me.skiincraft.ichirin.models.user.IchirinUser;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import java.util.Set;

/** <h2>MangaFavorite</h2>
 *  <p>Está entidade ficará responsável em registrar quem favoritou algum manga em especifico</p>
 *
 * @see Manga Manga
 * @see IchirinUser User
 */
@Entity
public class MangaFavorite {

    @OneToOne
    private Manga manga;
    @ManyToMany
    private Set<IchirinUser> users;

}
