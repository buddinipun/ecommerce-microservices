package com.ecommerce.platform.security.jwt;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.util.ReflectionTestUtils;

import java.util.Set;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class JwtTokenProviderTest {

    private JwtProperties jwtProperties;

    private JwtTokenProvider jwtTokenProvider;

    private UUID userId;

    @BeforeEach
    void setUp() {

        jwtProperties = new JwtProperties();

        jwtProperties.setSecret(
                "this-is-a-test-secret-key-that-is-long-enough-for-hs256"
        );

        jwtProperties.setAccessTokenExpirationMs(
                900000
        );

        jwtProperties.setRefreshTokenExpirationMs(
                604800000
        );

        jwtTokenProvider =
                new JwtTokenProvider(jwtProperties);

        ReflectionTestUtils.invokeMethod(
                jwtTokenProvider,
                "init"
        );

        userId = UUID.randomUUID();
    }

    @Test
    void shouldGenerateValidAccessToken() {

        JwtClaims claims =
                JwtClaims.builder()
                        .userId(userId)
                        .email("customer@example.com")
                        .roles(Set.of("CUSTOMER"))
                        .authorities(
                                Set.of(
                                        "PRODUCT_READ",
                                        "ORDER_CREATE"
                                )
                        )
                        .build();

        String token =
                jwtTokenProvider
                        .generateAccessToken(claims);

        assertNotNull(token);

        assertTrue(
                jwtTokenProvider.validateToken(token)
        );
    }

    @Test
    void shouldExtractUserIdFromToken() {

        JwtClaims claims =
                JwtClaims.builder()
                        .userId(userId)
                        .email("customer@example.com")
                        .roles(Set.of("CUSTOMER"))
                        .authorities(Set.of("PRODUCT_READ"))
                        .build();

        String token =
                jwtTokenProvider
                        .generateAccessToken(claims);

        UUID extractedUserId =
                jwtTokenProvider.getUserId(token);

        assertEquals(
                userId,
                extractedUserId
        );
    }

    @Test
    void shouldExtractEmailFromToken() {

        JwtClaims claims =
                JwtClaims.builder()
                        .userId(userId)
                        .email("customer@example.com")
                        .roles(Set.of("CUSTOMER"))
                        .authorities(Set.of("PRODUCT_READ"))
                        .build();

        String token =
                jwtTokenProvider
                        .generateAccessToken(claims);

        assertEquals(
                "customer@example.com",
                jwtTokenProvider.getEmail(token)
        );
    }

    @Test
    void shouldExtractRolesFromToken() {

        JwtClaims claims =
                JwtClaims.builder()
                        .userId(userId)
                        .email("customer@example.com")
                        .roles(Set.of("CUSTOMER"))
                        .authorities(Set.of("PRODUCT_READ"))
                        .build();

        String token =
                jwtTokenProvider
                        .generateAccessToken(claims);

        assertEquals(
                Set.of("CUSTOMER"),
                jwtTokenProvider.getRoles(token)
        );
    }

    @Test
    void shouldExtractAuthoritiesFromToken() {

        JwtClaims claims =
                JwtClaims.builder()
                        .userId(userId)
                        .email("customer@example.com")
                        .roles(Set.of("CUSTOMER"))
                        .authorities(
                                Set.of(
                                        "PRODUCT_READ",
                                        "ORDER_CREATE"
                                )
                        )
                        .build();

        String token =
                jwtTokenProvider
                        .generateAccessToken(claims);

        assertEquals(
                Set.of(
                        "PRODUCT_READ",
                        "ORDER_CREATE"
                ),
                jwtTokenProvider.getAuthorities(token)
        );
    }

    @Test
    void shouldRejectInvalidToken() {

        assertFalse(
                jwtTokenProvider.validateToken(
                        "invalid.jwt.token"
                )
        );
    }

    @Test
    void shouldGenerateRefreshToken() {

        JwtClaims claims =
                JwtClaims.builder()
                        .userId(userId)
                        .email("customer@example.com")
                        .roles(Set.of("CUSTOMER"))
                        .authorities(Set.of("PRODUCT_READ"))
                        .build();

        String token =
                jwtTokenProvider
                        .generateRefreshToken(claims);

        assertNotNull(token);

        assertTrue(
                jwtTokenProvider.validateToken(token)
        );

        assertEquals(
                JwtConstants.REFRESH_TOKEN,
                jwtTokenProvider
                        .getClaims(token)
                        .get(
                                JwtConstants.CLAIM_TOKEN_TYPE,
                                String.class
                        )
        );
    }
}
