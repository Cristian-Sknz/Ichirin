package me.skiincraft.ichirin.entity.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import me.skiincraft.ichirin.models.dto.IchirinUserDTO;
import me.skiincraft.ichirin.repository.user.IchirinUserRepository;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.time.Clock;
import java.time.OffsetDateTime;
import java.util.Objects;

/**
 * <h2>IchirinUser</h2>
 * <p>Está entidade será um usuário no banco de dados onde serão guardado as
 * informações privadas, configurações, histórico e favoritos.</p>
 *
 * @see IchirinUserRepository Repository
 * @see me.skiincraft.ichirin.service.UserService Service
 * @see IchirinUserDTO Data Transfer Object
 */

@Entity
@Getter
@Setter
@ToString
public class IchirinUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String nickname;
    private String avatarUrl;
    private String email;

    @JsonIgnore
    private String password;

    @Column(name = "created_date")
    private OffsetDateTime createdDate;

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
        this.id = 0L;
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

    @PrePersist
    @PreUpdate
    public void update() {
        if (this.createdDate == null)
            this.createdDate = OffsetDateTime.now(Clock.systemUTC());
        this.lastLogin = OffsetDateTime.now(Clock.systemUTC());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        IchirinUser that = (IchirinUser) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
