package com.example.securitypractice.config;

import com.example.securitypractice.security.JwtAuthenticationFilter;
import com.example.securitypractice.security.RestAuthenticationEntryPoint;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import static org.springframework.security.config.Customizer.withDefaults;

//import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
@Configuration
public class SecurityConfig {
    private final JwtAuthenticationFilter jwtAuthenticationFilter;
    private final RestAuthenticationEntryPoint authenticationEntryPoint;
    public SecurityConfig(JwtAuthenticationFilter jwtAuthenticationFilter, RestAuthenticationEntryPoint authenticationEntryPoint){
        this.jwtAuthenticationFilter = jwtAuthenticationFilter;
        this.authenticationEntryPoint = authenticationEntryPoint;
    }
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        http.csrf(csrf -> csrf.disable())
                .exceptionHandling(exception -> exception.authenticationEntryPoint(authenticationEntryPoint))
                .authorizeHttpRequests(auth -> auth
                .requestMatchers("/register", "/login").permitAll()   // Anyone can access registration, even if they are not logged in. /login: Because someone who isn't authenticated must be able to access /login in order to obtain their JWT.
                .requestMatchers("/hello").authenticated()
                .requestMatchers("/admin").hasRole("ADMIN")
        .anyRequest().permitAll()
        )
        .formLogin(form -> form.disable())
//        .formLogin(withDefaults())
                .logout(logout -> logout.logoutSuccessUrl("/hello"))
                .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }
//    @Bean
//    public UserDetailsService userDetailsService(PasswordEncoder passwordEncoder){
//        UserDetails user = User.builder().username("abdullah").password(passwordEncoder.encode("12345")).roles("USER").build();
//        UserDetails admin = User.builder().username("admin").password(passwordEncoder.encode("admin123")).roles("ADMIN").build();
//        return new InMemoryUserDetailsManager(user, admin);
////        return new InMemoryUserDetailsManager(user);
//    }
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
