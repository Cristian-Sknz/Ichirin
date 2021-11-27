package me.skiincraft.ichirin.security.filter;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import me.skiincraft.ichirin.configuration.ControllerExceptionHandler;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;

public class ValidationFilter extends BasicAuthenticationFilter {

    public ValidationFilter(AuthenticationManager authenticationManager, ControllerExceptionHandler resolver) {
        super(authenticationManager, resolver);
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        String authorization = request.getHeader("Authorization");
        if (!isValidHeader(authorization)) {
            chain.doFilter(request, response);
            return;
        }
        try {
            var token = authorization.substring("Bearer ".length());
            var authenticationToken = getAuthenticationToken(token);
            SecurityContextHolder.getContext().setAuthentication(authenticationToken);
            chain.doFilter(request, response);
        } catch (Exception e) {
            SecurityContextHolder.clearContext();
            getExceptionHandler().handleAuthenticationException(request, response, e);
        }
    }

    public ControllerExceptionHandler getExceptionHandler() {
        return (ControllerExceptionHandler) getAuthenticationEntryPoint();
    }

    public UsernamePasswordAuthenticationToken getAuthenticationToken(String token) {
        String user = JWT.require(Algorithm.HMAC512(AuthenticationFilter.TEMPORARY_TOKEN))
                .build()
                .verify(token)
                .getSubject();

        return (user == null) ? null : new UsernamePasswordAuthenticationToken(user, null, Collections.emptyList());
    }

    private boolean isValidHeader(String header) {
        return header != null && header.startsWith("Bearer");
    }
}