package com.ecommerce.platform.security.jwt;

public class JwtConstants {

	private JwtConstants() {
	}

	public static final String TOKEN_PREFIX = "Bearer ";

	public static final String HEADER_AUTHORIZATION = "Authorization";

	public static final String CLAIM_USER_ID = "userId";

	public static final String CLAIM_EMAIL = "email";

	public static final String CLAIM_ROLES = "roles";

	public static final String CLAIM_AUTHORITIES = "authorities";

	public static final String TOKEN_TYPE = "JWT";

	public static final String CLAIM_TOKEN_TYPE = "tokenType";

	public static final String ACCESS_TOKEN = "ACCESS";

	public static final String REFRESH_TOKEN = "REFRESH";

}
