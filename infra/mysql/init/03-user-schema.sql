CREATE TABLE users
(
    id CHAR(36) PRIMARY KEY,

    first_name VARCHAR(100),

    last_name VARCHAR(100),

    email VARCHAR(255) UNIQUE,

    phone VARCHAR(30),

    gender VARCHAR(20),

    birth_date DATE,

    status VARCHAR(30),

    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,

    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
    ON UPDATE CURRENT_TIMESTAMP
);


CREATE TABLE user_addresses
(
    id CHAR(36) PRIMARY KEY,

    user_id CHAR(36) NOT NULL,

    address_type VARCHAR(30),

    address_line1 VARCHAR(255),

    address_line2 VARCHAR(255),

    city VARCHAR(100),

    state VARCHAR(100),

    postal_code VARCHAR(30),

    country VARCHAR(100),

    is_default BOOLEAN,

    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,

    FOREIGN KEY(user_id)
        REFERENCES users(id)
);



