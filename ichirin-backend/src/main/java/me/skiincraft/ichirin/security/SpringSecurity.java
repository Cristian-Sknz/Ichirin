package me.skiincraft.ichirin.security;

import me.skiincraft.ichirin.configuration.ControllerExceptionHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.access.hierarchicalroles.RoleHierarchy;
import org.springframework.security.access.hierarchicalroles.RoleHierarchyImpl;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.access.expression.DefaultWebSecurityExpressionHandler;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.List;

@EnableWebSecurity
public class SpringSecurity extends WebSecurityConfigurerAdapter {

    private final UserDetailsService userService;
    private final ControllerExceptionHandler exceptionHandler;
    private final JWTProvider provider;

    @Autowired
    public SpringSecurity(UserDetailsService userService,
                          ControllerExceptionHandler exceptionHandler,
                          JWTProvider provider) {
        super();
        this.userService = userService;
        this.exceptionHandler = exceptionHandler;
        this.provider = provider;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService).passwordEncoder(passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.formLogin().disable();
        http.cors();

        http.authorizeRequests()
                .antMatchers(HttpMethod.POST, "/login", "/signup").permitAll()
                .anyRequest().authenticated();
        http.apply(new JWTConfigurerAdapter(provider, authenticationManager(), userService, exceptionHandler));

        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        http.exceptionHandling().authenticationEntryPoint(exceptionHandler);
    }


    @Bean
    public RoleHierarchy roleHierarchy() {
        RoleHierarchyImpl roleHierarchy = new RoleHierarchyImpl();
        roleHierarchy.setHierarchy("ROLE_ADMIN > ROLE_EDITOR \n ROLE_EDITOR > ROLE_USER");
        return roleHierarchy;
    }

    @Bean
    public DefaultWebSecurityExpressionHandler defaultWebSecurityExpressionHandler() {
        var expressionHandler = new DefaultWebSecurityExpressionHandler();
        expressionHandler.setRoleHierarchy(roleHierarchy());
        return expressionHandler;
    }

    /**
     * O CORS est?? configurado para permitir todas as origens.
     * Para funcionar no container docker isso ter?? que ser habilitado,
     * pois, n??o ?? poss??vel configurar o endere??o dinamicamente (colocando o nome do container e porta).
     *
     * Caso queira permitir origens limitadas use como o exemplo:
     * configuration.setAllowedOrigins(List.of("http://localhost:3000"));
     */
    @Bean
    public CorsFilter corsFilter() {
        var configuration = new CorsConfiguration();
        var source = new UrlBasedCorsConfigurationSource();

        configuration.setAllowCredentials(true);
        configuration.addAllowedHeader("*");
        configuration.addAllowedMethod("*");
        configuration.setAllowedOriginPatterns(List.of("*"));

        configuration.setMaxAge(3600L);

        source.registerCorsConfiguration("/**", configuration);
        return new CorsFilter(source);
    }

    @Bean
    public AuthenticationEntryPoint authenticationEntryPoint() {
        return exceptionHandler;
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
