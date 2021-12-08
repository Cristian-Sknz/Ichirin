package me.skiincraft.ichirin.entity.manga;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import me.skiincraft.ichirin.entity.user.UserCommentary;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "manga_comments")
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

    public MangaComments(Manga manga) {
        this.manga = manga;
        this.userCommentaries = new HashSet<>();
    }
}
