package me.skiincraft.ichirin.entity.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import me.skiincraft.ichirin.entity.IchirinImage;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class UserAvatar {

    @Id
    @Column(name = "user_id") private Long id;

    @MapsId @OneToOne
    @JsonIgnore @JoinColumn(name = "user_id")
    private IchirinUser user;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "image_id")
    private IchirinImage image;

    public UserAvatar(IchirinUser user) {
        this.user = user;
    }
}
