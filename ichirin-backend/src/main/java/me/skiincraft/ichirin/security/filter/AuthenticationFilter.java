package me.skiincraft.ichirin.security.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import me.skiincraft.ichirin.configuration.ControllerExceptionHandler;
import me.skiincraft.ichirin.models.AuthenticationModel;
import me.skiincraft.ichirin.models.SimpleAuthenticatedUser;
import me.skiincraft.ichirin.security.JWTProvider;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;

public class AuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    private final ObjectMapper mapper;
    private final UserDetailsService userService;
    private final ControllerExceptionHandler resolver;
    private final JWTProvider provider;

    public AuthenticationFilter(JWTProvider provider,
                                AuthenticationManager authenticationManager,
                                UserDetailsService userService,
                                ControllerExceptionHandler resolver) {
        super(authenticationManager);
        this.provider = provider;
        this.mapper = new ObjectMapper();
        this.userService = userService;
        this.resolver = resolver;
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest req, HttpServletResponse res) throws AuthenticationException {
        AuthenticationManager authenticationManager = getAuthenticationManager();

        var userByUsername = (SimpleAuthenticatedUser) userService.loadUserByUsername(obtainUsername(req));
        var authentication = new UsernamePasswordAuthenticationToken(userByUsername, obtainPassword(req), Collections.emptyList());
        return authenticationManager.authenticate(authentication);
    }


    @Override
    protected void successfulAuthentication(HttpServletRequest request,
                                            HttpServletResponse response,
                                            FilterChain chain, Authentication authResult) throws IOException {

        String token = provider.createToken(authResult);

        response.setContentType("application/json");
        response.setStatus(HttpStatus.ACCEPTED.value());
        response.setCharacterEncoding("UTF-8");
        mapper.writeValue(response.getWriter(), new AuthenticationModel(token, provider.getExpireTime()));
    }

    @Override
    protected void unsuccessfulAuthentication(HttpServletRequest request,
                                              HttpServletResponse response,
                                              AuthenticationException failed) throws IOException {
        resolver.commence(request, response, failed);
    }
}