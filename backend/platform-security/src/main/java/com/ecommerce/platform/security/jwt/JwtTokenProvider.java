package com.ecommerce.platform.security.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.Set;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class JwtTokenProvider {

	private final JwtProperties jwtProperties;

	private SecretKey secretKey;

	@PostConstruct
	public void init() {

		this.secretKey = Keys.hmacShaKeyFor(jwtProperties.getSecret().getBytes(StandardCharsets.UTF_8));
	}

	public String generateAccessToken(JwtClaims claims) {

		return generateToken(claims, JwtConstants.ACCESS_TOKEN, jwtProperties.getAccessTokenExpirationMs());
	}

	public String generateRefreshToken(JwtClaims claims) {

		return generateToken(claims, JwtConstants.REFRESH_TOKEN, jwtProperties.getRefreshTokenExpirationMs());
	}

	private String generateToken(JwtClaims claims, String tokenType, long expiration) {

		Date now = new Date();

		Date expiryDate = new Date(now.getTime() + expiration);

		return Jwts.builder()

				.subject(claims.getUserId().toString())

				.claim(JwtConstants.CLAIM_EMAIL, claims.getEmail())

				.claim(JwtConstants.CLAIM_ROLES, claims.getRoles())

				.claim(JwtConstants.CLAIM_AUTHORITIES, claims.getAuthorities())

				.claim(JwtConstants.CLAIM_TOKEN_TYPE, tokenType)

				.issuedAt(now)

				.expiration(expiryDate)

				.signWith(secretKey)

				.compact();
	}

	public boolean validateToken(String token) {

		try {

			Jwts.parser().verifyWith(secretKey).build().parseSignedClaims(token);

			return true;

		} catch (Exception ex) {

			return false;

		}

	}

	public Claims getClaims(String token) {

		return Jwts.parser().verifyWith(secretKey).build().parseSignedClaims(token).getPayload();

	}

	public UUID getUserId(String token) {

		return UUID.fromString(getClaims(token).getSubject());

	}

	public String getEmail(String token) {

		return getClaims(token).get(JwtConstants.CLAIM_EMAIL, String.class);

	}

	@SuppressWarnings("unchecked")
	public Set<String> getRoles(String token) {

		return Set.copyOf(

				getClaims(token).get(JwtConstants.CLAIM_ROLES, java.util.List.class)

		);

	}
	
	@SuppressWarnings("unchecked")
	public Set<String> getAuthorities(
	        String token
	) {

	    java.util.List<String> values =
	            getClaims(token)
	                    .get(
	                            JwtConstants.CLAIM_AUTHORITIES,
	                            java.util.List.class
	                    );

	    if (values == null) {
	        return Set.of();
	    }

	    return Set.copyOf(values);
	}

}