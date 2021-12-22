package me.skiincraft.ichirin.entity.permissions;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@SequenceGenerator(name = "permissions", sequenceName = "seq_permissions")
@Table(name = "permissions")
public class Permission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "permissions")
    private Long id;
    private String name;

    @ManyToMany(mappedBy = "permissions")
    @JsonIgnore
    private Set<Role> roles;

    public Permission(String name) {
        this.name = name;
    }
}
