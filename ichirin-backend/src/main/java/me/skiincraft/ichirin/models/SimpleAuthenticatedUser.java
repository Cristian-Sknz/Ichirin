package me.skiincraft.ichirin.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import me.skiincraft.ichirin.entity.permissions.Permission;
import me.skiincraft.ichirin.entity.permissions.Role;
import me.skiincraft.ichirin.entity.user.IchirinUser;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
public class SimpleAuthenticatedUser implements UserDetails {

    private long userId;
    private String email;
    private String nickname;
    private String password;
    private Collection<? extends GrantedAuthority> authorities;

    public SimpleAuthenticatedUser(IchirinUser user) {
        this.userId = user.getId();
        this.email = user.getEmail();
        this.nickname = user.getNickname();
        this.password = user.getPassword();
        this.authorities = getAuthorities(user);
    }

    private Collection<? extends GrantedAuthority> getAuthorities(IchirinUser user) {
        return getPermissions(user.getRoles()).stream().map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
    }

    private Collection<String> getPermissions(Collection<Role> roles) {
        return roles.stream().map((role) -> {
            var permissions = role.getPermissions()
                    .stream()
                    .map(Permission::getName)
                    .collect(Collectors.toList());
            permissions.add(role.getName());

            return permissions;
        }).flatMap(Collection::stream).collect(Collectors.toList());
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
