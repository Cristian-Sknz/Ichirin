package me.skiincraft.ichirin.models.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import me.skiincraft.ichirin.models.manga.MangaComments;

import javax.persistence.*;
import java.time.Clock;
import java.time.OffsetDateTime;

@Entity
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

    public long getId() {
        return id;
    }

    public OffsetDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(OffsetDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public MangaComments getManga() {
        return manga;
    }

    public void setManga(MangaComments manga) {
        this.manga = manga;
    }

    public IchirinUser getUser() {
        return user;
    }

    public void setUser(IchirinUser user) {
        this.user = user;
    }

    @PrePersist
    public void prePersist() {
        this.createdDate = OffsetDateTime.now(Clock.systemUTC());
    }
}
