package com.ecommerce.platform.security.service;

import com.ecommerce.platform.security.jwt.JwtClaims;
import com.ecommerce.platform.security.jwt.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TokenService {

    private final JwtTokenProvider
            jwtTokenProvider;

    public String createAccessToken(
            JwtClaims claims
    ) {

        return jwtTokenProvider
                .generateAccessToken(
                        claims
                );

    }

    public String createRefreshToken(
            JwtClaims claims
    ) {

        return jwtTokenProvider
                .generateRefreshToken(
                        claims
                );

    }

}