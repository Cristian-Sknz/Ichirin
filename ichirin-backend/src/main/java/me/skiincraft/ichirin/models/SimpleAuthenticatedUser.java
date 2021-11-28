package me.skiincraft.ichirin.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import me.skiincraft.ichirin.entity.user.IchirinUser;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

@Data
@NoArgsConstructor
public class SimpleAuthenticatedUser implements UserDetails {

    private long userId;
    private String email;
    private String nickname;
    private String password;

    public SimpleAuthenticatedUser(IchirinUser user) {
        this.userId = user.getId();
        this.email = user.getEmail();
        this.nickname = user.getNickname();
        this.password = user.getPassword();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
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
