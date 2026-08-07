package com.ecommerce.platform.security.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Optional;
import java.util.UUID;

public final class SecurityUtils {

    private SecurityUtils() {
    }

    public static Optional<UserPrincipal>
    getCurrentUser() {

        Authentication authentication =
                SecurityContextHolder
                        .getContext()
                        .getAuthentication();

        if (authentication == null) {
            return Optional.empty();
        }

        Object principal =
                authentication.getPrincipal();

        if (principal instanceof UserPrincipal user) {
            return Optional.of(user);
        }

        return Optional.empty();
    }

    public static UUID getCurrentUserId() {

        return getCurrentUser()
                .map(UserPrincipal::getUserId)
                .orElse(null);
    }

    public static String getCurrentUserEmail() {

        return getCurrentUser()
                .map(UserPrincipal::getEmail)
                .orElse(null);
    }

    public static boolean isAuthenticated() {

        return getCurrentUser().isPresent();
    }

}
