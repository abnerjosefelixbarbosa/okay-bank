package com.api.backend_java.infra.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableMethodSecurity
@EnableWebSecurity
public class SecurityConfig {

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		return http.csrf((csrf) -> csrf.disable())
		.headers((header) -> {
			header.frameOptions((frame) -> {
				frame.sameOrigin();
			});
		})
		.cors(Customizer.withDefaults()).authorizeHttpRequests((auth) -> {
			auth.requestMatchers(AUTH_WHITELIST).permitAll();
			auth.anyRequest().authenticated();
		})
		.sessionManagement((session) -> {
			session.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		})
		.httpBasic(Customizer.withDefaults())
	    .addFilterBefore(securityFilter, UsernamePasswordAuthenticationFilter.class)
	    .build();
	}
}