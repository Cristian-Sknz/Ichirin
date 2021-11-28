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
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Collections;
import java.util.Date;
import java.util.Optional;

@Service
@ToString
public class JWTProvider {

    private final ObjectMapper mapper;
    @Value("${ichirin.authentication.secret}")
    private String secretToken;
    @Value("${ichirin.authentication.expire}")
    private Integer expireTime;

    @Autowired
    public JWTProvider(ObjectMapper mapper) {
        this.mapper = mapper;
    }

    public String createToken(Authentication authentication) {
        OffsetDateTime now = OffsetDateTime.now();
        OffsetDateTime expires = now.plus(getExpireTime(), ChronoUnit.MILLIS);
        var authenticatedUser = (SimpleAuthenticatedUser) authentication.getPrincipal();

        return JWT.create().withSubject(String.valueOf(authenticatedUser.getUserId()))
                .withClaim("model", stringfy(authenticatedUser))
                .withIssuedAt(Date.from(now.toInstant()))
                .withExpiresAt(Date.from(expires.toInstant()))
                .sign(getAlgorithm());
    }

    public Optional<Authentication> getAuthentication(String token) throws JWTVerificationException {
        DecodedJWT decodedJWT = JWT.require(getAlgorithm())
                .build().verify(token);

        var simpleAuthenticatedUser = parse(decodedJWT);
        if (simpleAuthenticatedUser == null) {
            return Optional.empty();
        }

        return Optional.of(new UsernamePasswordAuthenticationToken(simpleAuthenticatedUser, token, Collections.emptyList()));
    }

    private Algorithm getAlgorithm() {
        return Algorithm.HMAC512(secretToken);
    }

    private String stringfy(SimpleAuthenticatedUser authenticatedUser) {
        try {
            return mapper.writeValueAsString(authenticatedUser);
        } catch (Exception ignored) {}
        return null;
    }

    private SimpleAuthenticatedUser parse(DecodedJWT decoded) {
        if (decoded == null || decoded.getSubject() == null) {
            return null;
        }
        try {
            return mapper.readValue(decoded.getClaim("model").asString(), SimpleAuthenticatedUser.class);
        } catch (Exception ignored) {}
        return null;
    }

    public long getExpireTime() {
        return expireTime;
    }
}
