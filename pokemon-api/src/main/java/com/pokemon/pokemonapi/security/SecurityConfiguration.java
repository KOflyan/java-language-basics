//package com.pokemon.pokemonapi.security;
//
//import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
//import io.swagger.v3.oas.annotations.security.SecurityRequirement;
//import io.swagger.v3.oas.annotations.security.SecurityScheme;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.AuthenticationProvider;
//import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
//import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
//import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.builders.WebSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
//import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
//
//@Configuration
//@EnableWebSecurity
//@EnableMethodSecurity(securedEnabled = true, jsr250Enabled = true)
//@SecurityScheme(type = SecuritySchemeType.HTTP, name = "bearerAuth", scheme = "bearer")
//@SecurityRequirement(name = "bearerAuth")
//public class SecurityConfiguration {
//
//    public static final String[] AUTH_WHITELIST = {
//            "/v3/api-docs/**", "/configuration/ui/**", "/swagger-resources/**",
//            "/configuration/security/**", "/swagger-ui/**", "/webjars/**",
//            "/login/**", "/logout/**"
//    };
//
//    private final JwtAuthenticationFilter jwtAuthenticationFilter;
//    private final UserDetailsServiceImpl userDetailsService;
//
//    @Autowired
//    public SecurityConfiguration(
//            JwtAuthenticationFilter jwtAuthenticationFilter,
//            UserDetailsServiceImpl userDetailsService
//    ) {
//        this.userDetailsService = userDetailsService;
//        this.jwtAuthenticationFilter = jwtAuthenticationFilter;
//    }
//
//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//        http
//                .csrf(AbstractHttpConfigurer::disable)
//                .cors(AbstractHttpConfigurer::disable)
//                .authorizeHttpRequests((auth) -> auth
//                        .requestMatchers(AUTH_WHITELIST).permitAll()
//                        .anyRequest().authenticated()
//                )
//                .logout((l) -> l.clearAuthentication(true));
//
//        http.addFilterBefore(this.jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
//
//        return http.build();
//    }
//
//
//    @Bean
//    public AuthenticationProvider authenticationProvider() {
//        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
//
//        authenticationProvider.setUserDetailsService(this.userDetailsService);
//        authenticationProvider.setPasswordEncoder(passwordEncoder());
//
//        return authenticationProvider;
//
//    }
//
//    @Bean
//    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
//        return config.getAuthenticationManager();
//    }
//
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//}