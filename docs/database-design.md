##### MySQL databases #########
1. auth-service → auth_db

- Stores authentication and authorization data only.

Tables -
    users_auth
    roles
    user_roles
    refresh_tokens (optional but recommended)

2. user-service → user_db

- Stores customer profile and address data.

Tables -
    users
    user_addresses

3. order-service → order_db

- Stores order and order line data.

Tables -
    orders
    order_items
    order_status_history

4. inventory-service → inventory_db

- Stores stock and inventory movement data.

Tables -
    inventory
    inventory_reservations
    inventory_movements

5. payment-service → payment_db

- Stores payment transactions and payment attempts.

Tables -
    payments
    ayment_transactions

##### MongoDB databases #######

1. product-service → product_db

Collections:
    products
    categories

2. cart-service → cart_db

Collections:
    carts