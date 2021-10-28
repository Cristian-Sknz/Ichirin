package me.skiincraft.ichirin.models.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import me.skiincraft.ichirin.data.IchirinUserDTO;
import me.skiincraft.ichirin.repository.user.IchirinUserRepository;

import javax.persistence.*;
import java.time.Clock;
import java.time.OffsetDateTime;

/** <h2>IchirinUser</h2>
 *  <p>Está entidade será um usuário no banco de dados onde serão guardado as
 *  informações privadas, configurações, histórico e favoritos.</p>
 *
 * @see IchirinUserRepository Repository
 * @see me.skiincraft.ichirin.service.UserService Service
 * @see IchirinUserDTO Data Transfer Object
 */

@Entity
public class IchirinUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String nickname;
    private String email;

    @JsonIgnore
    private String password;

    @Column(name = "created_time")
    private OffsetDateTime createdTime;

    @Column(name = "last_login")
    private OffsetDateTime lastLogin;

    @OneToOne(mappedBy = "user",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    @PrimaryKeyJoinColumn
    private UserFavorite favorite;

    @OneToOne(mappedBy = "user",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    @PrimaryKeyJoinColumn
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
        this.setFavorite(new UserFavorite(this));
        this.setHistory(new UserHistory(this));
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

    public OffsetDateTime getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(OffsetDateTime createdTime) {
        this.createdTime = createdTime;
    }

    public OffsetDateTime getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(OffsetDateTime lastLogin) {
        this.lastLogin = lastLogin;
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

    public UserConfiguration getConfiguration() {
        return configuration;
    }

    public void setConfiguration(UserConfiguration configuration) {
        this.configuration = configuration;
    }

    public UserHistory getHistory() {
        return history;
    }

    public void setHistory(UserHistory history) {
        this.history = history;
    }

    public UserFavorite getFavorite() {
        return favorite;
    }

    public void setFavorite(UserFavorite userFavorite) {
        this.favorite = userFavorite;
    }

    @PrePersist
    @PreUpdate
    public void update() {
        if (this.createdTime == null)
            this.createdTime = OffsetDateTime.now(Clock.systemUTC());
        this.lastLogin = OffsetDateTime.now(Clock.systemUTC());
    }
}
