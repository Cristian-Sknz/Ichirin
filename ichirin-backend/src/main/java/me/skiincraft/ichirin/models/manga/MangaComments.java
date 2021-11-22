package me.skiincraft.ichirin.models.manga;

import com.fasterxml.jackson.annotation.JsonIgnore;
import me.skiincraft.ichirin.models.user.UserCommentary;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tb_manga_comments")
public class MangaComments {

    @Id
    @Column(name = "manga_id")
    private Long id;

    @MapsId
    @JsonIgnore
    @OneToOne
    @JoinColumn(name = "manga_id")
    private Manga manga;

    @OneToMany(mappedBy = "manga",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private Set<UserCommentary> userCommentaries;

    public MangaComments() {
    }

    public MangaComments(Manga manga) {
        this.manga = manga;
        this.userCommentaries = new HashSet<>();
    }

    public Long getId() {
        return id;
    }

    public Manga getManga() {
        return manga;
    }

    public void setManga(Manga manga) {
        this.manga = manga;
    }

    public Set<UserCommentary> getUserCommentaries() {
        return userCommentaries;
    }

    public void setUserCommentaries(Set<UserCommentary> userCommentaries) {
        this.userCommentaries = userCommentaries;
    }
}
