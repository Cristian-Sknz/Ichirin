package me.skiincraft.ichirin.security.filter;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.fasterxml.jackson.databind.ObjectMapper;
import me.skiincraft.ichirin.configuration.ControllerExceptionHandler;
import me.skiincraft.ichirin.data.AuthenticationModel;
import me.skiincraft.ichirin.models.user.IchirinUser;
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

import java.time.OffsetDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Collections;
import java.util.Date;

public class AuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    public static String TEMPORARY_TOKEN = "dcb231c1-6c71-43ff-91dc-9c66b6ce7e5d";
    private final ObjectMapper mapper;
    private final UserDetailsService userService;
    private final ControllerExceptionHandler resolver;

    public AuthenticationFilter(AuthenticationManager authenticationManager,
                                UserDetailsService userService,
                                ControllerExceptionHandler resolver) {
        super(authenticationManager);
        this.mapper = new ObjectMapper();
        this.userService = userService;
        this.resolver = resolver;
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest req, HttpServletResponse res) throws AuthenticationException {
        AuthenticationManager authenticationManager = getAuthenticationManager();

        IchirinUser userByUsername = (IchirinUser) userService.loadUserByUsername(obtainUsername(req));
        var authentication = new UsernamePasswordAuthenticationToken(userByUsername, obtainPassword(req), Collections.emptyList());
        return authenticationManager.authenticate(authentication);
    }


    @Override
    protected void successfulAuthentication(HttpServletRequest request,
                                            HttpServletResponse response,
                                            FilterChain chain, Authentication authResult) throws IOException {

        IchirinUser userDetails = (IchirinUser) authResult.getPrincipal();
        var tokenExpireTime = OffsetDateTime.now().plus(1, ChronoUnit.HOURS);
        var token = JWT.create()
                .withSubject(userDetails.getUsername())
                .withExpiresAt(Date.from(tokenExpireTime.toInstant()))
                .sign(Algorithm.HMAC512(TEMPORARY_TOKEN));

        response.setContentType("application/json");
        response.setStatus(HttpStatus.ACCEPTED.value());
        response.setCharacterEncoding("UTF-8");
        mapper.writeValue(response.getWriter(), new AuthenticationModel(token, tokenExpireTime));
    }

    @Override
    protected void unsuccessfulAuthentication(HttpServletRequest request,
                                              HttpServletResponse response,
                                              AuthenticationException failed) throws IOException {
        resolver.commence(request, response, failed);
    }
}