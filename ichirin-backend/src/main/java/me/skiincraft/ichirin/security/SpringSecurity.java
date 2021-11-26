package me.skiincraft.ichirin.security;

import me.skiincraft.ichirin.configuration.ControllerExceptionHandler;
import me.skiincraft.ichirin.security.filter.AuthenticationFilter;
import me.skiincraft.ichirin.security.filter.ValidationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@EnableWebSecurity
public class SpringSecurity extends WebSecurityConfigurerAdapter {

    private final UserDetailsService userService;
    private final ControllerExceptionHandler exceptionHandler;

    @Autowired
    public SpringSecurity(UserDetailsService userService, ControllerExceptionHandler exceptionHandler) {
        super();
        this.userService = userService;
        this.exceptionHandler = exceptionHandler;
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
                .antMatchers(HttpMethod.POST, "/login", "/signin").permitAll()
                .anyRequest().authenticated();

        http.addFilter(new AuthenticationFilter(authenticationManager(), userService, exceptionHandler));
        http.addFilter(new ValidationFilter(authenticationManager(), exceptionHandler));

        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        http.exceptionHandling().authenticationEntryPoint(exceptionHandler);
    }

    @Bean
    public CorsConfigurationSource corsConfiguration() {
        final UrlBasedCorsConfigurationSource corsConfigurationSource = new UrlBasedCorsConfigurationSource();
        CorsConfiguration corsConfiguration = new CorsConfiguration().applyPermitDefaultValues();
        corsConfigurationSource.registerCorsConfiguration("/**", corsConfiguration);
        return corsConfigurationSource;
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
