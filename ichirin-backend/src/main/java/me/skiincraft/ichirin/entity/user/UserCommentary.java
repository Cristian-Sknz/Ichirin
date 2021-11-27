package me.skiincraft.ichirin.entity.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import me.skiincraft.ichirin.entity.manga.MangaComments;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.time.Clock;
import java.time.OffsetDateTime;
import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
public class UserCommentary {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private OffsetDateTime createdDate;
    @Lob
    private String content;

    @JsonIgnore
    @ManyToOne
    private MangaComments manga;
    @ManyToOne
    private IchirinUser user;

    public UserCommentary() {
        this.id = 0L;
    }

    public UserCommentary(IchirinUser user, MangaComments manga, String content) {
        this();
        this.user = user;
        this.manga = manga;
        this.content = content;
    }

    @PrePersist
    public void prePersist() {
        this.createdDate = OffsetDateTime.now(Clock.systemUTC());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        UserCommentary that = (UserCommentary) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
