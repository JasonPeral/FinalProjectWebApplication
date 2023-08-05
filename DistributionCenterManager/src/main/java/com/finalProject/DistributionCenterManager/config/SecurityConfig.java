package com.finalProject.DistributionCenterManager.config;


//import com.finalProject.DistributionCenterManager.models.User;
//import com.finalProject.DistributionCenterManager.repository.UserRepository;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpMethod;
//import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.boot.autoconfigure.security.servlet.PathRequest.toH2Console;

//@Configuration
//@EnableMethodSecurity
public class SecurityConfig {
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//
//    @Bean
//    public UserDetailsService userDetailsService(UserRepository userRepository) {
//        return username -> {
//            User user = userRepository.findByUsername(username);
//            if (user != null) {
//                return user;
//            }
//            throw new UsernameNotFoundException(username);
//        };
//    }
//
//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//        http
//                .authorizeHttpRequests()
//                .requestMatchers(toH2Console()).permitAll()
//                .requestMatchers("/api/v1/store")
//                .hasRole("USER")
//                .anyRequest().permitAll()
//
//                // Make H2-Console non-secured; for debug purposes
//                // Allow pages to be loaded in frames from the same origin; needed for
//                // H2-Console
//                .and()
//                .headers()
//                .frameOptions();
//
//        http.csrf().disable();
//        return http.build();
//    }

}
