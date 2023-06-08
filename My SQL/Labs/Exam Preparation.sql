CREATE DATABASE restaurant_db;
USE restaurant_db;

# Task 1. Table Design
CREATE TABLE products
(
    id    INT PRIMARY KEY AUTO_INCREMENT,
    name  VARCHAR(30)    NOT NULL UNIQUE,
    type  VARCHAR(30)    NOT NULL,
    price DECIMAL(10, 2) NOT NULL
);

CREATE TABLE clients
(
    id         INT PRIMARY KEY AUTO_INCREMENT,
    first_name VARCHAR(50) NOT NULL,
    last_name  VARCHAR(50) NOT NULL,
    birthdate  DATE        NOT NULL,
    card       VARCHAR(50),
    review     TEXT
);

CREATE TABLE tables
(
    id       INT PRIMARY KEY AUTO_INCREMENT,
    floor    INT NOT NULL,
    reserved TINYINT(1),
    capacity INT NOT NULL
);

CREATE TABLE waiters
(
    id         INT PRIMARY KEY AUTO_INCREMENT,
    first_name VARCHAR(50) NOT NULL,
    last_name  VARCHAR(50) NOT NULL,
    email      VARCHAR(50) NOT NULL,
    phone      VARCHAR(50),
    salary     DECIMAL(10, 2)
);

CREATE TABLE orders
(
    id           INT PRIMARY KEY AUTO_INCREMENT,
    table_id     INT  NOT NULL,
    waiter_id    INT  NOT NULL,
    order_time   TIME NOT NULL,
    payed_status TINYINT(1)
);

CREATE TABLE orders_clients
(
    order_id  INT,
    client_id INT
);

CREATE TABLE orders_products
(
    order_id   INT,
    product_id INT
);

ALTER TABLE orders
    ADD CONSTRAINT fk_orders_waiters FOREIGN KEY (waiter_id) REFERENCES waiters (id);

ALTER TABLE orders
    ADD CONSTRAINT fk_orders_tables FOREIGN KEY (table_id) REFERENCES tables (id);

ALTER TABLE orders_products
    ADD CONSTRAINT fk__orders_products__orders FOREIGN KEY (order_id) REFERENCES orders (id),
    ADD CONSTRAINT fk__orders_products__products FOREIGN KEY (product_id) REFERENCES products (id);

ALTER TABLE orders_clients
    ADD CONSTRAINT fk__orders_clients__orders FOREIGN KEY (order_id) REFERENCES orders (id),
    ADD CONSTRAINT fk__orders_clients__clients FOREIGN KEY (client_id) REFERENCES clients (id);

# Task 2. Insert
INSERT INTO products(name, type, price) ( SELECT CONCAT(last_name, ' specialty'), 'Cocktail', CEILING(salary * 0.01)
                                          FROM waiters
                                          WHERE id > 6 );

# Task 3. Update
UPDATE orders
SET table_id = table_id - 1
WHERE id BETWEEN 12 AND 23;

# Task 4. Delete
DELETE
FROM waiters w
WHERE ( SELECT COUNT(*) FROM orders o WHERE o.waiter_id = w.id ) = 0;

# Task 5. Clents
SELECT *
FROM clients
ORDER BY birthdate DESC, id DESC;

# Task 6. Birthdate
SELECT first_name, last_name, birthdate, review
FROM clients
WHERE card IS NULL
  AND YEAR(birthdate) BETWEEN 1978 AND 1993
ORDER BY last_name DESC, id
LIMIT 5;

# Task 7. Accounts
SELECT CONCAT(last_name, first_name, CHARACTER_LENGTH(first_name), 'Restaurant') AS username,
       REVERSE(SUBSTRING(email, 2, 12))                                          AS password
FROM waiters
WHERE salary IS NOT NULL
ORDER BY `password` DESC;

# Task 8. Top from menu
SELECT product_id, p.name, ( SELECT COUNT(*) FROM orders_products op1 WHERE op1.product_id = op.product_id ) AS `count`
FROM orders_products op
         JOIN products p ON p.id = op.product_id
GROUP BY product_id, p.name
HAVING `count` >= 5
ORDER BY `count` DESC, p.name;

# Task 9. Availability
SELECT t.id,
       capacity,
       COUNT(oc.client_id)           AS count_clients,
       (CASE WHEN capacity > COUNT(oc.client_id) THEN 'Free seats'
             WHEN capacity = COUNT(oc.client_id) THEN 'Full'
             ELSE 'Extra seats' END) AS availability
FROM tables t
         JOIN orders o ON t.id = o.table_id
         JOIN orders_clients oc ON o.id = oc.order_id
WHERE t.floor = 1
GROUP BY t.id
ORDER BY t.id DESC;

# Task 10. Extract bill
CREATE FUNCTION udf_client_bill(full_name VARCHAR(50)) RETURNS DECIMAL(10, 2)
    DETERMINISTIC
BEGIN
    DECLARE current_client_id INT;
    SET current_client_id = ( SELECT id FROM clients WHERE CONCAT_WS(' ', first_name, last_name) = full_name );

    RETURN ( SELECT SUM(p.price)
             FROM orders_products op
                      JOIN products p ON op.product_id = p.id
                      JOIN orders_clients oc ON op.order_id = oc.order_id
             WHERE oc.client_id = current_client_id );
END;

SELECT c.first_name, c.last_name, udf_client_bill('Silvio Blyth') AS 'bill'
FROM clients c
WHERE c.first_name = 'Silvio'
  AND c.last_name = 'Blyth';

# Task 11. Happy hour
CREATE PROCEDURE udp_happy_hour(type VARCHAR(50))
BEGIN
    DECLARE lower_limit_price DECIMAL(10, 2);
    SET lower_limit_price = 10;

    UPDATE products p SET price = price - price * 0.2 WHERE p.type LIKE type AND price >= lower_limit_price;
END;

CALL udp_happy_hour ('Cognac');