CREATE TABLE inventory
(
    id CHAR(36) PRIMARY KEY,

    product_id VARCHAR(100),

    sku VARCHAR(100),

    available_quantity INT,

    reserved_quantity INT,

    reorder_level INT,

    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE inventory_reservations
(
    id CHAR(36) PRIMARY KEY,

    order_id CHAR(36),

    product_id VARCHAR(100),

    reserved_quantity INT,

    reservation_status VARCHAR(30),

    reserved_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);


CREATE TABLE inventory_movements
(
    id CHAR(36) PRIMARY KEY,

    product_id VARCHAR(100),

    sku VARCHAR(100),

    movement_type VARCHAR(30),

    quantity INT,

    reference_id VARCHAR(100),

    remarks VARCHAR(255),

    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);


