package me.skiincraft.ichirin.security.impl;

import me.skiincraft.ichirin.models.SimpleAuthenticatedUser;
import me.skiincraft.ichirin.repository.user.IchirinUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Locale;

@Service
public class UserDetailsServiceImpl  implements UserDetailsService {

    private final IchirinUserRepository repository;
    private final MessageSource source;

    @Autowired
    public UserDetailsServiceImpl(IchirinUserRepository repository, MessageSource source) {
        this.repository = repository;
        this.source = source;
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return new SimpleAuthenticatedUser(repository.findByEmailIgnoreCase(username)
                .orElseThrow(() -> new UsernameNotFoundException(source.getMessage("exception.user.invalid.credentials",
                        null, Locale.getDefault()))));
    }
}
