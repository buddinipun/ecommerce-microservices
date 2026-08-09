package com.ecommerce.platform.security.config;

import com.ecommerce.platform.security.jwt.JwtAuthenticationFilter;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Import;
import org.springframework.security.web.SecurityFilterChain;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Import({
    SecurityConfig.class,
    JwtAuthenticationFilter.class,
    JwtAuthenticationEntryPoint.class,
})
class SecurityConfigTest {

    @Autowired
    private ApplicationContext applicationContext;

    @Test
    void shouldLoadSecurityFilterChain() {

        SecurityFilterChain filterChain =
                applicationContext.getBean(
                        SecurityFilterChain.class
                );

        assertNotNull(filterChain);
    }
}