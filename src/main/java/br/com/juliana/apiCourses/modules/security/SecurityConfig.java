package br.com.juliana.apiCourses.modules.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableMethodSecurity
public class SecurityConfig {

  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    return http.csrf(csrf -> csrf.disable())
    .authorizeHttpRequests(auth ->  auth
                  .requestMatchers(HttpMethod.POST, "/course/").permitAll()
                  .requestMatchers(HttpMethod.GET,"/course/").permitAll()
                  .requestMatchers(HttpMethod.GET,"/course/{id}").permitAll()
                  .requestMatchers(HttpMethod.GET,"/course/search/{name}").permitAll()
                  .requestMatchers(HttpMethod.GET,"/course/find/{category}").permitAll()
                  .requestMatchers(HttpMethod.PUT, "/course/{id}").permitAll()
                  .requestMatchers(HttpMethod.PATCH,"/course/{id}/active").permitAll()
                  .requestMatchers(HttpMethod.DELETE, "/course/{id}").permitAll()

                  .anyRequest().permitAll()
                  
                  
     )   
     .build();
  }
}
