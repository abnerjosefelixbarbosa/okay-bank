package com.api.backend_java.infra.config;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.api.backend_java.adapter.ITokenGateway;
import com.api.backend_java.infra.repository.ICustomerRepository;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class SecurityFilter extends OncePerRequestFilter {
	@Autowired
	private ITokenGateway tokenGateway;
	@Autowired
	private ICustomerRepository customerRepository;

	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		String token = recoverToken(request);	
        if(token != null){
            String cpf = tokenGateway.validateToken(token);
            Object user = customerRepository.findByCpf(cpf).orElseThrow(() -> {
    			throw new UsernameNotFoundException("cpf not found");
    		});
            UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(user, null, ((AbstractAuthenticationToken) user).getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }
        
        filterChain.doFilter(request, response);
	}

	private String recoverToken(HttpServletRequest request) {
		String authHeader = request.getHeader("Authorization");
		if (authHeader == null) 
			return null;
		return authHeader.replace("Bearer ", "");
	}
}
