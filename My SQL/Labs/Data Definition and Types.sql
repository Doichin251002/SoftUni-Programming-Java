CREATE DATABASE gamebar;
USE gamebar;

# Query 1. Create Tables
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

# Query 2. Insert Data in Tables
INSERT INTO employees(`first_name`, `last_name`)
VALUES
('test1', 'Test1'),
('test2', 'Test2'),
('test3', 'Test3');

# Query 3. Alter Tables
ALTER TABLE employees
ADD COLUMN `middle_name` VARCHAR(20) NOT NULL;

# Query 4. Adding Constraints
ALTER TABLE products
ADD CONSTRAINT `fk_products_categories`
FOREIGN KEY (`category_id`)
REFERENCES categories(`id`);

# Query 5. Modifying Columns
ALTER TABLE employees
MODIFY `middle_name` VARCHAR(100);