package me.skiincraft.ichirin.models.user;

import me.skiincraft.ichirin.data.IchirinUserDTO;
import me.skiincraft.ichirin.models.manga.Manga;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import java.time.OffsetDateTime;
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
    private long id;

    @MapsId
    @OneToOne
    private IchirinUser user;
    private OffsetDateTime lastUpdate;
    private Set<Manga> mangas;

}
