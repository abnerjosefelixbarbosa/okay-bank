package com.org.back_end_java.infra.config;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.org.back_end_java.infra.repository.ICustomerRepository;
import com.org.back_end_java.infra.service.ITokenService;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class SecurityFilter extends OncePerRequestFilter {
	 @Autowired
	 private ITokenService tokenService;
	 @Autowired
	 private ICustomerRepository customerRepository;

	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) 
			throws ServletException, IOException {
        var token = this.recoverToken(request);	
        if(token != null){
            var cpf = tokenService.validateToken(token);
            var user = customerRepository.findByCpf(cpf).orElseThrow(() -> {
    			throw new UsernameNotFoundException("Login not found");
    		});
            var authentication = new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }
        
        filterChain.doFilter(request, response);
	}
	
	private String recoverToken(HttpServletRequest request){
        var authHeader = request.getHeader("Authorization");
        if(authHeader == null) { 
        	return null;
        }
        return authHeader.replace("Bearer ", "");
    }
}