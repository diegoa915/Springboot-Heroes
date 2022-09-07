package com.capacitacion.api.security.config;

import javax.servlet.http.HttpServletResponse;

import com.capacitacion.api.filter.LoginFilter;
import com.capacitacion.api.jwt.JwtAuthFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import com.capacitacion.api.filter.LoginFilter;
import com.capacitacion.api.jwt.JwtAuthFilter;

@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfiguration {

    @Autowired
    @Lazy
    private LoginFilter loginFilter;

    @Autowired
    private JwtAuthFilter jwtAuthFilter;


    @Bean
    UserDetailsService userDetailsService() {
        var userDt = new InMemoryUserDetailsManager();/* In-memory data-store */

        userDt.createUser(User.builder().username("user").password("{noop}user").roles("USER").build());
        userDt.createUser(User.builder().username("admin").password("{noop}admin").roles("USER", "ADMIN").build());
        return userDt;
    }


    @Bean
    AuthenticationManager authenticationManager(UserDetailsService userDetailsService) {
        var daoAuth = new DaoAuthenticationProvider();
        daoAuth.setUserDetailsService(userDetailsService);
        return new ProviderManager(daoAuth);
    }


    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http.csrf().disable();
        http.authorizeHttpRequests().anyRequest().authenticated();
        http.addFilterAt(loginFilter, BasicAuthenticationFilter.class);
        http.addFilterAfter(jwtAuthFilter, BasicAuthenticationFilter.class);
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);/* Token-based authentication does not require session */


        http.exceptionHandling()

                .accessDeniedHandler((request, response, accessDeniedException) -> {

                    response.setStatus(HttpServletResponse.SC_FORBIDDEN);
                    response.getWriter().print(accessDeniedException.getMessage());/* Define your own message */
                }).authenticationEntryPoint((request, response, authException) -> {

                    response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                    response.getWriter().print(authException.getMessage());/* Define your own message */

                });

        return http.build();

    }
}
