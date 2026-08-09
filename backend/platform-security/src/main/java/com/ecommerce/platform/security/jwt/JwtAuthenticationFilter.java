package com.ecommerce.platform.security.jwt;

import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.ecommerce.platform.security.security.UserPrincipal;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter{
	
	private final JwtTokenProvider jwtTokenProvider;
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		 String token = extractToken(request);

	        if (token != null
	                && jwtTokenProvider.validateToken(token)
	                && SecurityContextHolder
	                        .getContext()
	                        .getAuthentication() == null) {

	            authenticateUser(token);
	        }

	        filterChain.doFilter(request, response);
	    }

	    private String extractToken(
	            HttpServletRequest request
	    ) {

	        String header =
	                request.getHeader(
	                        JwtConstants.HEADER_AUTHORIZATION
	                );

	        if (header == null
	                || !header.startsWith(
	                        JwtConstants.TOKEN_PREFIX
	                )) {

	            return null;
	        }

	        return header.substring(
	                JwtConstants.TOKEN_PREFIX.length()
	        );
	    }

	    private void authenticateUser(
	            String token
	    ) {

	        UUID userId =
	                jwtTokenProvider.getUserId(token);

	        String email =
	                jwtTokenProvider.getEmail(token);

	        Set<String> roles =
	                jwtTokenProvider.getRoles(token);

	        Set<String> authorities =
	                jwtTokenProvider.getAuthorities(token);

	        Collection<SimpleGrantedAuthority>
	                grantedAuthorities =
	                buildAuthorities(
	                        roles,
	                        authorities
	                );

	        UserPrincipal principal =
	                UserPrincipal.builder()
	                        .userId(userId)
	                        .email(email)
	                        .password(null)
	                        .authorities(grantedAuthorities)
	                        .build();

	        UsernamePasswordAuthenticationToken authentication =
	                new UsernamePasswordAuthenticationToken(
	                        principal,
	                        null,
	                        grantedAuthorities
	                );

	        SecurityContextHolder
	                .getContext()
	                .setAuthentication(authentication);
	    }

	    private Collection<SimpleGrantedAuthority>
	    buildAuthorities(
	            Set<String> roles,
	            Set<String> authorities
	    ) {

	        if (roles == null && authorities == null) {
	            return Collections.emptyList();
	        }

	        Set<String> roleAuthorities =
	                roles == null
	                        ? Collections.emptySet()
	                        : roles.stream()
	                        .map(role ->
	                                role.startsWith("ROLE_")
	                                        ? role
	                                        : "ROLE_" + role
	                        )
	                        .collect(Collectors.toSet());

	        Set<String> permissions =
	                authorities == null
	                        ? Collections.emptySet()
	                        : authorities;

	        return java.util.stream.Stream.concat(
	                        roleAuthorities.stream(),
	                        permissions.stream()
	                )
	                .distinct()
	                .map(SimpleGrantedAuthority::new)
	                .toList();
	    }
	}