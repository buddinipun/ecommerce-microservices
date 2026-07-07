CREATE TABLE payments
(
    id CHAR(36) PRIMARY KEY,

    order_id CHAR(36),

    user_id CHAR(36),

    payment_method VARCHAR(50),

    payment_status VARCHAR(50),

    amount DECIMAL(12,2),

    currency VARCHAR(10),

    provider_reference VARCHAR(255),

    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);


CREATE TABLE payment_transactions
(
    id CHAR(36) PRIMARY KEY,

    payment_id CHAR(36),

    transaction_type VARCHAR(50),

    transaction_status VARCHAR(50),

    request_payload JSON,

    response_payload JSON,

    processed_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,

    FOREIGN KEY(payment_id)
        REFERENCES payments(id)
);



