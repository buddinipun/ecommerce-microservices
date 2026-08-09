package com.ecommerce.platform.security.security;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class SecurityUtilsTest {

    @AfterEach
    void tearDown() {

        SecurityContextHolder.clearContext();
    }

    @Test
    void shouldReturnCurrentUser() {

        UUID userId = UUID.randomUUID();

        UserPrincipal principal =
                UserPrincipal.builder()
                        .userId(userId)
                        .email("customer@example.com")
                        .authorities(
                                List.of(
                                        new SimpleGrantedAuthority(
                                                "ROLE_CUSTOMER"
                                        )
                                )
                        )
                        .build();

        UsernamePasswordAuthenticationToken authentication =
                new UsernamePasswordAuthenticationToken(
                        principal,
                        null,
                        principal.getAuthorities()
                );

        SecurityContextHolder
                .getContext()
                .setAuthentication(authentication);

        assertTrue(
                SecurityUtils
                        .getCurrentUser()
                        .isPresent()
        );

        assertEquals(
                userId,
                SecurityUtils.getCurrentUserId()
        );

        assertEquals(
                "customer@example.com",
                SecurityUtils.getCurrentUserEmail()
        );

        assertTrue(
                SecurityUtils.isAuthenticated()
        );
    }

    @Test
    void shouldReturnEmptyWhenUserIsNotAuthenticated() {

        assertTrue(
                SecurityUtils
                        .getCurrentUser()
                        .isEmpty()
        );

        assertNull(
                SecurityUtils.getCurrentUserId()
        );

        assertNull(
                SecurityUtils.getCurrentUserEmail()
        );

        assertFalse(
                SecurityUtils.isAuthenticated()
        );
    }
}
