package com.ecommerce.platform.security.jwt;

import lombok.Builder;
import lombok.Getter;

import java.util.Set;
import java.util.UUID;

@Getter
@Builder
public class JwtClaims {

    private UUID userId;

    private String email;

    private Set<String> roles;

    private Set<String> authorities;

}