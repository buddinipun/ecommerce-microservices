package com.ecommerce.platform.security.jwt;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Getter
@Setter
@ConfigurationProperties(prefix = "application.security.jwt")
public class JwtProperties {

	private String secret;
	private long accessTokenExpirationMs;
	private long refreshTokenExpirationMs;

}
