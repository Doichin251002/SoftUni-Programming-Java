CREATE DATABASE gamebar;
USE gamebar;

-- Problem 1
CREATE TABLE employees(
`id` INT PRIMARY KEY AUTO_INCREMENT,
`first_name` VARCHAR(20) NOT NULL,
`last_name` VARCHAR(20) NOT NULL
);

CREATE TABLE categories(
`id` INT PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(20) NOT NULL
);

CREATE TABLE products(
`id` INT PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(20) NOT NULL,
`category_id` INT NOT NULL
);

-- Problem 2
INSERT INTO employees(`first_name`, `last_name`)
VALUES
('test1', 'Test1'),
('test2', 'Test2'),
('test3', 'Test3');

-- Problem 3
ALTER TABLE employees
ADD COLUMN `middle_name` VARCHAR(20) NOT NULL;

-- Problem 4
ALTER TABLE products
ADD CONSTRAINT `fk_products_categories`
FOREIGN KEY (`category_id`)
REFERENCES categories(`id`);

-- Problem 5
ALTER TABLE employees
MODIFY `middle_name` VARCHAR(100);