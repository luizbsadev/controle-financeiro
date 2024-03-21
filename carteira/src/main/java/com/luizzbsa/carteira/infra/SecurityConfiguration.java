package com.luizzbsa.carteira.infra;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

        @Autowired
        private UserAuthenticationFilter userAuthenticationFilter;

        public static final String [] ENDPOINTS_WITH_AUTHENTICATION_NOT_REQUIRED = {
                "/users/login",
                "/users",


        };

        public static final String [] ENDPOINTS_WITH_AUTHENTICATION_NOT_REQUIRED_PLUS = {
                "/h2-console/**",
                "/h2-console",
                "/v3/",
                "/v3/**",
                "/swagger-ui",
                "/swagger-ui/**",
                "/favicon.ico"
    };


        public static final String [] ENDPOINTS_WITH_AUTHENTICATION_REQUIRED = {

                "/transacoes"
        };



        @Bean
        public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {


            return httpSecurity.csrf(csrf -> csrf.disable())
                    .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                    .headers(httpSecurityHeadersConfigurer -> {
                        httpSecurityHeadersConfigurer.frameOptions(HeadersConfigurer.FrameOptionsConfig::disable);
                    })
                    .authorizeHttpRequests(request -> {
                        request.requestMatchers(ENDPOINTS_WITH_AUTHENTICATION_NOT_REQUIRED).permitAll();
                        request.requestMatchers(ENDPOINTS_WITH_AUTHENTICATION_NOT_REQUIRED_PLUS).permitAll();
                        request.requestMatchers(ENDPOINTS_WITH_AUTHENTICATION_REQUIRED).authenticated();
                        request.anyRequest().denyAll();
                    })
                    .addFilterBefore(userAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
                    .build();
        }

        @Bean
        public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
            return authenticationConfiguration.getAuthenticationManager();
        }

        @Bean
        public PasswordEncoder passwordEncoder() {
            return new BCryptPasswordEncoder();
        }

}