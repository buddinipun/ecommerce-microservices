CREATE TABLE orders
(
    id CHAR(36) PRIMARY KEY,

    order_number VARCHAR(50) UNIQUE,

    user_id CHAR(36) NOT NULL,

    order_status VARCHAR(30),

    payment_status VARCHAR(30),

    currency VARCHAR(10),

    subtotal DECIMAL(12,2),

    discount DECIMAL(12,2),

    tax DECIMAL(12,2),

    shipping DECIMAL(12,2),

    total DECIMAL(12,2),

    shipping_address JSON,

    billing_address JSON,

    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);


CREATE TABLE order_items
(
    id CHAR(36) PRIMARY KEY,

    order_id CHAR(36),

    product_id VARCHAR(100),

    product_name VARCHAR(255),

    sku VARCHAR(100),

    unit_price DECIMAL(12,2),

    quantity INT,

    line_total DECIMAL(12,2),

    FOREIGN KEY(order_id)
        REFERENCES orders(id)
);


CREATE TABLE order_status_history
(
    id CHAR(36) PRIMARY KEY,

    order_id CHAR(36),

    old_status VARCHAR(30),

    new_status VARCHAR(30),

    remarks VARCHAR(255),

    changed_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,

    FOREIGN KEY(order_id)
        REFERENCES orders(id)
);


