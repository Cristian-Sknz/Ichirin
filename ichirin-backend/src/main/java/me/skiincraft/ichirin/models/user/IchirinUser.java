package me.skiincraft.ichirin.models.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import me.skiincraft.ichirin.data.IchirinUserDTO;
import me.skiincraft.ichirin.models.manga.MangaFavorite;

import javax.persistence.*;
import java.util.Set;

/** <h2>IchirinUser</h2>
 *  <p>Está entidade será um usuário no banco de dados onde serão guardado as
 *  informações privadas, configurações, histórico e favoritos.</p>
 *
 * @see me.skiincraft.ichirin.repository.IchirinUserRepository Repository
 * @see me.skiincraft.ichirin.service.UserService Service
 * @see IchirinUserDTO Data Transfer Object
 */
@Entity
public class IchirinUser {

    @Id
    private long id;
    private String name;
    private String nickname;
    private String email;

    @JsonIgnore
    private String password;

    @ManyToMany
    private Set<MangaFavorite> favorites;
    @OneToOne
    private UserHistory history;

    @Embedded
    private UserConfiguration configuration;

    public IchirinUser() {
        this.configuration = new UserConfiguration();
    }

    public IchirinUser(IchirinUserDTO user) {
        this();
        this.name = user.getName();
        this.email = user.getEmail();
        this.nickname = user.getNickname();
        this.password = user.getPassword();
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<MangaFavorite> getFavorites() {
        return favorites;
    }

    public void setFavorites(Set<MangaFavorite> favorites) {
        this.favorites = favorites;
    }

    public UserHistory getHistory() {
        return history;
    }

    public void setHistory(UserHistory history) {
        this.history = history;
    }

    public UserConfiguration getConfiguration() {
        return configuration;
    }

    public void setConfiguration(UserConfiguration configuration) {
        this.configuration = configuration;
    }

}
