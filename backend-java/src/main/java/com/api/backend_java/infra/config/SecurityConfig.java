package com.api.backend_java.infra.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.api.backend_java.adapter.ICustomerGateway;

@Configuration
@EnableMethodSecurity
@EnableWebSecurity
public class SecurityConfig {
	@Autowired
	private ICustomerGateway customerGateway;
	@Autowired
	private SecurityFilter securityFilter;

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
	
	@Bean
	public UserDetailsService userDetailsService() {
		return customerGateway;
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public AuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
		daoAuthenticationProvider.setUserDetailsService(userDetailsService());
		daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
		return daoAuthenticationProvider;
	}
	
	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration auth) throws Exception {
		return auth.getAuthenticationManager();
	}

	private static final AntPathRequestMatcher[] AUTH_WHITELIST = { 
			AntPathRequestMatcher.antMatcher("/h2-console/**"),
			AntPathRequestMatcher.antMatcher("/v1/auth/**"),
			AntPathRequestMatcher.antMatcher("/v3/api-docs/**"),
			AntPathRequestMatcher.antMatcher("/v3/api-docs.yaml"),
			AntPathRequestMatcher.antMatcher("/swagger-ui/**"),
			AntPathRequestMatcher.antMatcher("/swagger-ui.html"),
			AntPathRequestMatcher.antMatcher("/customers/create"),
			AntPathRequestMatcher.antMatcher("/customers/login")
	};
}