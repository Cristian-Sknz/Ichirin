package me.skiincraft.ichirin.models.manga;

import me.skiincraft.ichirin.models.user.IchirinUser;

import javax.persistence.*;
import java.util.Set;

/** <h2>MangaFavorite</h2>
 *  <p>Está entidade ficará responsável em registrar quem favoritou algum manga em especifico</p>
 *
 * @see Manga Manga
 * @see IchirinUser User
 */

public class MangaFavorite {

    @Id
    private long id;

    @MapsId
    @OneToOne
    private Manga manga;
    @ManyToMany
    private Set<IchirinUser> users;

}
