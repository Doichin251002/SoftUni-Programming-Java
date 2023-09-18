CREATE DATABASE online_stores;
USE online_stores;

CREATE TABLE brands
(
    id   INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(40) NOT NULL UNIQUE
);

CREATE TABLE categories
(
    id   INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(40) NOT NULL UNIQUE
);

CREATE TABLE reviews
(
    id           INT PRIMARY KEY AUTO_INCREMENT,
    content      TEXT,
    rating       DEC(10, 2)  NOT NULL,
    picture_url  VARCHAR(80) NOT NULL,
    published_at DATETIME    NOT NULL

);

CREATE TABLE products
(
    id                INT PRIMARY KEY AUTO_INCREMENT,
    name              VARCHAR(40) NOT NULL,
    price             DEC(19, 2)  NOT NULL,
    quantity_in_stock INT,
    description       TEXT,
    brand_id          INT         NOT NULL,
    category_id       INT         NOT NULL,
    review_id         INT,
    CONSTRAINT fk_products_brands FOREIGN KEY (brand_id) REFERENCES brands (id),
    CONSTRAINT fk_products_categories FOREIGN KEY (category_id) REFERENCES categories (id),
    CONSTRAINT fk_products_reviews FOREIGN KEY (review_id) REFERENCES reviews (id)

);

CREATE TABLE customers
(
    id            INT PRIMARY KEY AUTO_INCREMENT,
    first_name    VARCHAR(20) NOT NULL,
    last_name     VARCHAR(20) NOT NULL,
    phone         VARCHAR(30) NOT NULL UNIQUE,
    address       VARCHAR(60) NOT NULL,
    discount_card BIT(1) DEFAULT FALSE

);

CREATE TABLE orders
(
    id             INT PRIMARY KEY AUTO_INCREMENT,
    order_datetime DATETIME NOT NULL,
    customer_id    INT      NOT NULL,
    CONSTRAINT fk_orders_customers FOREIGN KEY (customer_id) REFERENCES customers (id)

);

CREATE TABLE orders_products
(
    order_id   INT NOT NULL,
    product_id INT NOT NULL,
    CONSTRAINT fk__orders_products__orders FOREIGN KEY (order_id) REFERENCES orders (id),
    CONSTRAINT fk__orders_products__products FOREIGN KEY (product_id) REFERENCES products (id)

);

INSERT INTO reviews (content, rating, picture_url, published_at)
SELECT LEFT(p.description, 15), (p.price / 8), REVERSE(p.name), DATE('2010-10-10')
FROM products p
WHERE p.id >= 5;

UPDATE products
SET quantity_in_stock = quantity_in_stock - 5
WHERE quantity_in_stock BETWEEN 60 AND 70;

DELETE
FROM customers
WHERE id NOT IN ( SELECT customer_id FROM orders );

SELECT *
FROM categories
ORDER BY name DESC;

SELECT id, brand_id, name, quantity_in_stock
FROM products
WHERE price > 1000
  AND quantity_in_stock < 30
ORDER BY quantity_in_stock, id;

SELECT id, content, rating, picture_url, published_at
FROM reviews
WHERE content LIKE 'My%'
  AND CHAR_LENGTH(content) > 61
ORDER BY rating DESC;

SELECT CONCAT_WS(' ', c.first_name, c.last_name) AS full_name, c.address, order_datetime
FROM customers c
         JOIN orders o ON c.id = o.customer_id
WHERE YEAR(o.order_datetime) <= 2018
ORDER BY full_name DESC;

SELECT COUNT(p.category_id) AS items_count, c.name, SUM(p.quantity_in_stock) AS total_quantity
FROM products p
         JOIN categories c ON c.id = p.category_id
GROUP BY p.category_id
ORDER BY items_count DESC, total_quantity
LIMIT 5;

CREATE FUNCTION udf_customer_products_count(name VARCHAR(30)) RETURNS INT
    DETERMINISTIC
BEGIN
    RETURN ( SELECT COUNT(product_id)
             FROM orders_products op
                      JOIN orders o ON o.id = op.order_id
                      JOIN customers c ON c.id = o.customer_id
             WHERE c.first_name LIKE name );
END;

SELECT c.first_name, c.last_name, udf_customer_products_count('Shirley') AS `total_products`
FROM customers c
WHERE c.first_name = 'Shirley';

CREATE PROCEDURE udp_reduce_price(category_name VARCHAR(50))
BEGIN
    DECLARE current_category_id INT;
    SET current_category_id = ( SELECT id FROM categories WHERE name = category_name );

    UPDATE products p JOIN reviews r ON r.id = p.review_id JOIN categories c ON c.id = p.category_id
    SET p.price = p.price - p.price * 0.3
    WHERE r.rating < 4
      AND category_id = current_category_id;
END;

CALL udp_reduce_price ('Phones and tablets');