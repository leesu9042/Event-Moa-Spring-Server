package com.example.eventmoa.global.config;


import com.example.eventmoa.global.error.GlobalExceptionFilter;
import com.example.eventmoa.global.filter.JwtTokenFilter;
import com.example.eventmoa.global.security.jwt.JwtProvider;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.CorsConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;



@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    private final JwtProvider jwtProvider;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http)throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable)
                .cors(CorsConfigurer::disable)
                .sessionManagement(configurer -> configurer.sessionCreationPolicy(SessionCreationPolicy.STATELESS))

                .authorizeHttpRequests(auth ->
                        auth
                                .requestMatchers("/auth/login", "/auth/reissue").permitAll()
                                .requestMatchers("/swagger-ui/index.html",
                                        // Swagger 허용 URL
                                        "/v2/api-docs", "/v3/api-docs", "/v3/api-docs/**", "/swagger-resources",
                                        "/swagger-resources/**", "/configuration/ui", "/configuration/security", "/swagger-ui/**",
                                        "/webjars/**", "/swagger-ui.html").permitAll()
                                .requestMatchers("/department/**","/test/hello").authenticated()
                                .requestMatchers("/auth/**").authenticated()
                                .requestMatchers("/dong/**").authenticated()
                                .anyRequest().permitAll()
                )
                .addFilterBefore(new JwtTokenFilter(jwtProvider), UsernamePasswordAuthenticationFilter.class)
                .addFilterBefore(new GlobalExceptionFilter(), JwtTokenFilter.class);
        return http.build();
    }
}