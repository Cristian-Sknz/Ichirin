package me.skiincraft.ichirin.entity.permissions;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import me.skiincraft.ichirin.entity.user.IchirinUser;

import javax.persistence.*;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @ManyToMany(mappedBy = "roles")
    private Set<IchirinUser> users;

    @ManyToMany
    @JoinTable(name = "roles_permissions",
            joinColumns = @JoinColumn(
                    name = "role_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(
                    name = "permission_id", referencedColumnName = "id"))
    private Set<Permission> permissions;

    public Role(String name, Collection<Permission> permissions) {
        this.name = name;
        this.permissions = new HashSet<>(permissions);
    }
}