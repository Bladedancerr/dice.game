package com.lasha.dice.game.config;

import com.lasha.dice.game.security.JwtFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig
{
    private final JwtFilter jwtFilter;

    @Autowired
    public SecurityConfig (JwtFilter jwtFilter)
    {
        this.jwtFilter = jwtFilter;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity security) throws Exception
    {
        security.csrf(customizer -> customizer.disable())
                .authorizeHttpRequests(customizer -> customizer.requestMatchers("/api/user/**", "/api/user/register", "/api/user/login", "/api/table/**" , "/api/table/create", "/api/table/join").permitAll().anyRequest().authenticated())
                .httpBasic(basic -> basic.disable())
                .sessionManagement(customizer -> customizer.sessionCreationPolicy(org.springframework.security.config.http.SessionCreationPolicy.STATELESS))
                .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);
        return security.build();
    }
}
