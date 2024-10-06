package com.api.backend_java.infra.service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

import org.springframework.stereotype.Service;

import com.api.backend_java.adapter.ITokenGateway;
import com.api.backend_java.infra.entity.Customer;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;

@Service
public class TokenService implements ITokenGateway {
	private static final String SECRET = "1";

	public String generateToken(Customer dto) {
		try {
			Algorithm algorithm = Algorithm.HMAC256(SECRET);
			String token = JWT.create().withIssuer("auth-api").withSubject(dto.getCpf())
					.withExpiresAt(genExpirationDate()).sign(algorithm);
			return token;
		} catch (JWTCreationException exception) {
			throw new RuntimeException("Error while generating token", exception);
		}
	}

	public String validateToken(String token) {
		try {
			Algorithm algorithm = Algorithm.HMAC256(SECRET);
			return JWT.require(algorithm).withIssuer("auth-api").build().verify(token).getSubject();
		} catch (JWTVerificationException exception) {
			throw new RuntimeException("Error while generating token", exception);
		}
	}

	private Instant genExpirationDate() {
		return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
	}
}