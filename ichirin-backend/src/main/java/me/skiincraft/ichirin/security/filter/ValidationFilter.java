package me.skiincraft.ichirin.security.filter;

import com.auth0.jwt.exceptions.JWTVerificationException;
import me.skiincraft.ichirin.configuration.ControllerExceptionHandler;
import me.skiincraft.ichirin.security.JWTProvider;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ValidationFilter extends BasicAuthenticationFilter {

    private final JWTProvider provider;

    public ValidationFilter(JWTProvider provider,
                            AuthenticationManager authenticationManager,
                            ControllerExceptionHandler resolver) {
        super(authenticationManager, resolver);
        this.provider = provider;
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
            var authenticationToken = provider.getAuthentication(token)
                    .orElseThrow(() -> new JWTVerificationException("Houve um problema ao verificar este usuário"));

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

    private boolean isValidHeader(String header) {
        return header != null && header.startsWith("Bearer");
    }
}