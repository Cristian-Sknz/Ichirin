package me.skiincraft.ichirin.security;

import me.skiincraft.ichirin.configuration.ControllerExceptionHandler;
import me.skiincraft.ichirin.security.filter.AuthenticationFilter;
import me.skiincraft.ichirin.security.filter.ValidationFilter;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.DefaultSecurityFilterChain;

public class JWTConfigurerAdapter extends SecurityConfigurerAdapter<DefaultSecurityFilterChain, HttpSecurity> {

    private final JWTProvider provider;
    private final AuthenticationManager authenticationManager;
    private final UserDetailsService userService;
    private final ControllerExceptionHandler exceptionHandler;

    public JWTConfigurerAdapter(JWTProvider provider,
                                AuthenticationManager authenticationManager,
                                UserDetailsService userService,
                                ControllerExceptionHandler exceptionHandler) {
        this.provider = provider;
        this.authenticationManager = authenticationManager;
        this.userService = userService;
        this.exceptionHandler = exceptionHandler;
    }

    @Override
    public void configure(HttpSecurity http) {
        http.addFilter(new AuthenticationFilter(provider, authenticationManager, userService, exceptionHandler));
        http.addFilter(new ValidationFilter(provider, authenticationManager, exceptionHandler));
    }
}
