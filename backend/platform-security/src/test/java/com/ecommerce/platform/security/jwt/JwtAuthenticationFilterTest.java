package com.ecommerce.platform.security.jwt;

import com.ecommerce.platform.security.security.UserPrincipal;
import jakarta.servlet.FilterChain;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Set;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class JwtAuthenticationFilterTest {

    @Mock
    private JwtTokenProvider jwtTokenProvider;

    @Mock
    private FilterChain filterChain;

    private JwtAuthenticationFilter filter;

    private UUID userId;

    @BeforeEach
    void setUp() {

        filter =
                new JwtAuthenticationFilter(
                        jwtTokenProvider
                );

        userId = UUID.randomUUID();

        SecurityContextHolder.clearContext();
    }

    @AfterEach
    void tearDown() {

        SecurityContextHolder.clearContext();
    }

    @Test
    void shouldAuthenticateValidJwt() throws Exception {

        String token = "valid-token";

        when(
                jwtTokenProvider.validateToken(token)
        ).thenReturn(true);

        when(
                jwtTokenProvider.getUserId(token)
        ).thenReturn(userId);

        when(
                jwtTokenProvider.getEmail(token)
        ).thenReturn("customer@example.com");

        when(
                jwtTokenProvider.getRoles(token)
        ).thenReturn(
                Set.of("CUSTOMER")
        );

        when(
                jwtTokenProvider.getAuthorities(token)
        ).thenReturn(
                Set.of("PRODUCT_READ")
        );

        MockHttpServletRequest request =
                new MockHttpServletRequest();

        request.addHeader(
                JwtConstants.HEADER_AUTHORIZATION,
                JwtConstants.TOKEN_PREFIX + token
        );

        MockHttpServletResponse response =
                new MockHttpServletResponse();

        filter.doFilter(
                request,
                response,
                filterChain
        );

        assertNotNull(
                SecurityContextHolder
                        .getContext()
                        .getAuthentication()
        );

        UserPrincipal principal =
                (UserPrincipal)
                        SecurityContextHolder
                                .getContext()
                                .getAuthentication()
                                .getPrincipal();

        assertEquals(
                userId,
                principal.getUserId()
        );

        assertEquals(
                "customer@example.com",
                principal.getEmail()
        );

        verify(filterChain)
                .doFilter(request, response);
    }

    @Test
    void shouldNotAuthenticateInvalidJwt()
            throws Exception {

        String token = "invalid-token";

        when(
                jwtTokenProvider.validateToken(token)
        ).thenReturn(false);

        MockHttpServletRequest request =
                new MockHttpServletRequest();

        request.addHeader(
                JwtConstants.HEADER_AUTHORIZATION,
                JwtConstants.TOKEN_PREFIX + token
        );

        MockHttpServletResponse response =
                new MockHttpServletResponse();

        filter.doFilter(
                request,
                response,
                filterChain
        );

        assertNull(
                SecurityContextHolder
                        .getContext()
                        .getAuthentication()
        );

        verify(filterChain)
                .doFilter(request, response);
    }

    @Test
    void shouldContinueWhenAuthorizationHeaderMissing()
            throws Exception {

        MockHttpServletRequest request =
                new MockHttpServletRequest();

        MockHttpServletResponse response =
                new MockHttpServletResponse();

        filter.doFilter(
                request,
                response,
                filterChain
        );

        assertNull(
                SecurityContextHolder
                        .getContext()
                        .getAuthentication()
        );

        verify(filterChain)
                .doFilter(request, response);
    }
}
