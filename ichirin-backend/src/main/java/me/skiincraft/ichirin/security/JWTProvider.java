package me.skiincraft.ichirin.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.ToString;
import me.skiincraft.ichirin.models.SimpleAuthenticatedUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.Optional;

@Service
@ToString
public class JWTProvider {

    private final ObjectMapper mapper;
    private final UserDetailsService userService;

    @Value("${ichirin.authentication.secret}")
    private String secretToken;
    @Value("${ichirin.authentication.expire}")
    private Integer expireTime;

    @Autowired
    public JWTProvider(UserDetailsService service, ObjectMapper mapper) {
        this.mapper = mapper;
        this.userService = service;
    }

    public String createToken(Authentication authentication) {
        OffsetDateTime now = OffsetDateTime.now();
        OffsetDateTime expires = now.plus(getExpireTime(), ChronoUnit.MILLIS);
        var authenticatedUser = (SimpleAuthenticatedUser) authentication.getPrincipal();

        return JWT.create().withSubject(String.valueOf(authenticatedUser.getUserId()))
                .withClaim("email", authenticatedUser.getEmail())
                .withIssuedAt(Date.from(now.toInstant()))
                .withExpiresAt(Date.from(expires.toInstant()))
                .sign(getAlgorithm());
    }

    public Optional<Authentication> getAuthentication(String token) throws JWTVerificationException {
        DecodedJWT decodedJWT = JWT.require(getAlgorithm())
                .build().verify(token);

        var simpleAuthenticatedUser = loadUser(decodedJWT);
        if (simpleAuthenticatedUser == null) {
            return Optional.empty();
        }

        return Optional.of(createAuthenticationToken(simpleAuthenticatedUser, token));
    }

    private UsernamePasswordAuthenticationToken createAuthenticationToken(SimpleAuthenticatedUser user, String token) {
        return new UsernamePasswordAuthenticationToken(user, token, user.getAuthorities());
    }

    private Algorithm getAlgorithm() {
        return Algorithm.HMAC512(secretToken);
    }

    private SimpleAuthenticatedUser loadUser(DecodedJWT decoded) {
        try {
            return (SimpleAuthenticatedUser) userService.loadUserByUsername(decoded.getClaim("email").asString());
        } catch (Exception ignored) {}
        return null;
    }

    public long getExpireTime() {
        return expireTime;
    }
}
