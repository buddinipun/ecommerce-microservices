CREATE TABLE roles
(
    id CHAR(36) PRIMARY KEY,

    role_name VARCHAR(50) NOT NULL UNIQUE,

    description VARCHAR(255),

    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,

    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
    ON UPDATE CURRENT_TIMESTAMP
);


CREATE TABLE users_auth
(
    id CHAR(36) PRIMARY KEY,

    user_id CHAR(36) NOT NULL,

    email VARCHAR(255) NOT NULL UNIQUE,

    password_hash VARCHAR(255) NOT NULL,

    account_status VARCHAR(30) NOT NULL,

    email_verified BOOLEAN DEFAULT FALSE,

    failed_login_attempts INT DEFAULT 0,

    last_login_at TIMESTAMP NULL,

    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,

    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
    ON UPDATE CURRENT_TIMESTAMP
);


CREATE TABLE user_roles
(
    id CHAR(36) PRIMARY KEY,

    user_auth_id CHAR(36) NOT NULL,

    role_id CHAR(36) NOT NULL,

    UNIQUE(user_auth_id, role_id),

    FOREIGN KEY(user_auth_id)
        REFERENCES users_auth(id),

    FOREIGN KEY(role_id)
        REFERENCES roles(id)
);


CREATE TABLE refresh_tokens
(
    id CHAR(36) PRIMARY KEY,

    user_auth_id CHAR(36) NOT NULL,

    token VARCHAR(500) NOT NULL,

    expires_at TIMESTAMP NOT NULL,

    revoked BOOLEAN DEFAULT FALSE,

    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,

    FOREIGN KEY(user_auth_id)
        REFERENCES users_auth(id)
);


