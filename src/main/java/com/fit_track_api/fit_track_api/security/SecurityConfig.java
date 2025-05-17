package com.fit_track_api.fit_track_api.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@EnableWebSecurity
@Configuration
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();  // or Pbkdf2PasswordEncoder or another implementation
    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.addAllowedOrigin("http://localhost:5173"); // Allow your frontend's origin
        configuration.addAllowedMethod("*"); // Allow all HTTP methods (GET, POST, etc.)
        configuration.addAllowedHeader("*"); // Allow all headers
        configuration.setAllowCredentials(true); // Allow credentials (like cookies or authorization headers)
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration); // Apply CORS configuration to all endpoints
        return source;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .csrf(AbstractHttpConfigurer::disable)
                .cors(cors -> cors.configurationSource(corsConfigurationSource())) // Apply CORS configuration
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers(
                                "/login/**",
                                "/oauth2/**",
                                "/api/users/**",
                                "/api/workoutPost/**",
                                "/api/achievements/**",
                                "/api/comment/**",
                                "/api/questions/**",
                                "/api/workoutPlan/**",
                                "/api/workoutPlans/**",
                                "/api/**"
                        ).permitAll()  // Public endpoints
                        .anyRequest().authenticated()  // Secure other endpoints
                )
                .oauth2Login(oauth2 -> oauth2
                        .loginPage("/login/google")
                        .defaultSuccessUrl("/loginSuccess", true)
                        .failureUrl("/loginFailure")
                )
                .logout(logout -> logout
                        .logoutUrl("/logout") // Define the logout URL
                        .logoutSuccessUrl("/api/users/login") // Redirect to homepage after logout
                        .invalidateHttpSession(true) // Invalidate the session on logout
                        .clearAuthentication(true) // Clear authentication information
                        .deleteCookies("JSESSIONID") // Delete the JSESSIONID cookie after logout
                        .permitAll()); // Allow everyone to access logout functionality

        return httpSecurity.build();
    }
}
