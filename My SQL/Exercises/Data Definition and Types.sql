CREATE DATABASE minions;
USE minions;

# Query 1. Create Tables
CREATE TABLE minions (
    `id` INT PRIMARY KEY AUTO_INCREMENT,
    `name` VARCHAR(50),
    `age` INT
);

CREATE TABLE towns (
    `id` INT PRIMARY KEY AUTO_INCREMENT,
    `name` VARCHAR(50)
);

# Query 2. Alter Minions Table
ALTER TABLE minions
ADD COLUMN`town_id` INT;

ALTER TABLE minions
ADD CONSTRAINT `fk_minions_towns`
FOREIGN KEY minions(`town_id`)
REFERENCES towns(`id`);

# Query 3. Insert Records in Both Tables
INSERT INTO towns(`id`, `name`) 
VALUES (1, 'Sofia'),
(2, 'Plovdiv'),
(3, 'Varna');

INSERT INTO minions(`id`, `name`, `age`, `town_id`)
VALUES (1, 'Kevin', 22, 1),
(2, 'Bob', 15, 3),
(3, 'Steward', null, 2);

SELECT 
    *
FROM
    minions;

# Query 4. Truncate Table Minions
TRUNCATE TABLE minions;

# Query 5. Drop All Tables
DROP TABLES minions, towns;

# Query 6. Create Table People
CREATE TABLE people (
    `id` INT PRIMARY KEY AUTO_INCREMENT,
    `name` VARCHAR(200) NOT NULL,
    `picture` BLOB,
    `height` DOUBLE(10 , 2 ),
    `weight` DOUBLE(10 , 2 ),
    `gender` CHAR(1) NOT NULL,
    `birthdate` DATE NOT NULL,
    `biography` TEXT
);

INSERT INTO people(`name`, `gender`, `birthdate`)
VALUES 
('test', 'm', DATE(now())),
('test1', 'f', DATE(now())),
('test2', 'm', DATE(now())),
('test3', 'f', DATE(now())),
('test4', 'f', DATE(now()));

SELECT 
    *
FROM
    people;

# Query 7. Create Table Users
CREATE TABLE users (
    `id` INT PRIMARY KEY AUTO_INCREMENT,
    `username` VARCHAR(30) NOT NULL,
    `password` VARCHAR(26) NOT NULL,
    `profile_picture` BLOB,
    `last_login_time` DATETIME,
    `is_deleted` BOOLEAN
);

INSERT INTO users(`username`, `password`)
VALUES
('test', 'test'),
('test1', 'test'),
('test2', 'test'),
('test3', 'test'),
('test5', 'test');

SELECT 
    *
FROM
    users;

# Query 8. Change Primary Key
ALTER TABLE users
DROP PRIMARY KEY,
ADD CONSTRAINT pk_users2
PRIMARY KEY users(`id`, `username`);

# Query 9. Set Default Value of a Field
ALTER TABLE users
CHANGE COLUMN `last_login_time`
`last_login_time` DATETIME DEFAULT NOW();

# Query 10. Set Unique Field
ALTER TABLE users
DROP PRIMARY KEY,
ADD CONSTRAINT pk_users
PRIMARY KEY users(`id`),
CHANGE COLUMN `username`
`username` VARCHAR(30) UNIQUE;

# Query 11. Movies Database
CREATE DATABASE movies;
USE movies;

CREATE TABLE directors (
    `id` INT PRIMARY KEY AUTO_INCREMENT,
    `director_name` VARCHAR(50) NOT NULL,
    `notes` TEXT
);

INSERT INTO directors(`director_name`)
VALUES
('test'),
('test1'),
('test2'),
('test3'),
('test4');

CREATE TABLE genres (
    `id` INT PRIMARY KEY AUTO_INCREMENT,
    `genre_name` VARCHAR(50) NOT NULL,
    `notes` TEXT
);

INSERT INTO genres(`genre_name`)
VALUES
('test'),
('test1'),
('test2'),
('test3'),
('test4');

CREATE TABLE categories (
    `id` INT PRIMARY KEY AUTO_INCREMENT,
    `category_name` VARCHAR(50) NOT NULL,
    `notes` TEXT
);

INSERT INTO categories(`category_name`)
VALUES
('test'),
('test1'),
('test2'),
('test3'),
('test4');

CREATE TABLE movies (
    `id` INT PRIMARY KEY AUTO_INCREMENT,
    `title` VARCHAR(50) NOT NULL,
    `director_id` INT,
    `copyright_year` YEAR,
    `length` DOUBLE(10 , 2 ),
    `genre_id` INT,
    `category_id` INT,
    `rating` DOUBLE(2 , 2 ),
    `notes` TEXT,
    FOREIGN KEY (`director_id`)
        REFERENCES directors (`id`),
    FOREIGN KEY (`genre_id`)
        REFERENCES genres (`id`),
    FOREIGN KEY (`category_id`)
        REFERENCES categories (`id`)
);

INSERT INTO movies(`title`, `director_id`, `genre_id`, `category_id`)
VALUES
('test', 1, 2, 3),
('test1', 1, 2, 5),
('test2', 1, 2, 4),
('test3', 1, 2, 3),
('test4', 1, 2, 3);

SELECT 
    *
FROM
    movies;
    
# Query 12. Car Rental Database
CREATE DATABASE car_rental;
use car_rental;

CREATE TABLE categories (
    `id` INT PRIMARY KEY AUTO_INCREMENT,
    `category` VARCHAR(20) NOT NULL,
    `daily_rate` DOUBLE,
    `weekly_rate` DOUBLE,
    `monthly_rate` DOUBLE,
    `weekend_rate` DOUBLE
);
    
INSERT INTO categories (`category`)
VALUES
('test1'),
('test2'),
('test3');

CREATE TABLE cars (
    id INT PRIMARY KEY AUTO_INCREMENT,
    plate_number VARCHAR(20) NOT NULL,
    make VARCHAR(20),
    model VARCHAR(20),
    car_year YEAR,
    category_id INT NOT NULL,
    doors INT,
    picture BLOB,
    car_condition VARCHAR(100),
    available BOOLEAN DEFAULT TRUE
);

INSERT INTO cars (`plate_number`, `category_id`)
VALUES
('test1', 1),
('test2', 2),
('test3', 3);

CREATE TABLE employees (
    id INT PRIMARY KEY AUTO_INCREMENT,
    first_name VARCHAR(20) NOT NULL,
    last_name VARCHAR(20) NOT NULL,
    title VARCHAR(20),
    notes TEXT
);

INSERT INTO employees (`first_name`, `last_name`)
VALUES
('Test1', 'test1'),
('Test2', 'test2'),
('Test3', 'test3');

CREATE TABLE customers (
    id INT PRIMARY KEY AUTO_INCREMENT,
    driver_licence_number VARCHAR(50) NOT NULL,
    full_name VARCHAR(60),
    address VARCHAR(50),
    city VARCHAR(40),
    zip_code VARCHAR(10),
    notes TEXT
);

INSERT INTO customers (`driver_licence_number`, `full_name`)
VALUES
('test1', 'Test1'),
('test2', 'Test2'),
('test3', 'Test3');

CREATE TABLE rental_orders (
    id INT PRIMARY KEY AUTO_INCREMENT,
    employee_id INT NOT NULL,
    customer_id INT NOT NULL,
    car_id INT NOT NULL,
    car_condition VARCHAR(50),
    tank_level INT,
    kilometrage_start DOUBLE,
    kilometrage_end DOUBLE,
    total_kilometrage DOUBLE,
    start_date DATE,
    end_date DATE,
    total_days INT,
    rate_applied DOUBLE,
    tax_rate DOUBLE,
    order_status VARCHAR(20),
    notes TEXT
);

INSERT INTO rental_orders (`employee_id`, `customer_id`, `car_id`)
VALUES
(1, 2, 3),
(1, 2, 3),
(1, 2, 3);

# Query 13. Basic Insert
CREATE DATABASE soft_uni;
USE soft_uni;

CREATE TABLE towns (
    `id` INT PRIMARY KEY AUTO_INCREMENT,
    `name` VARCHAR(30) NOT NULL
);

CREATE TABLE addresses (
    `id` INT PRIMARY KEY AUTO_INCREMENT,
    `address_text` TEXT,
    `town_id` INT
);

CREATE TABLE departments (
    `id` INT PRIMARY KEY AUTO_INCREMENT,
    `name` VARCHAR(50)
);

CREATE TABLE employees (
    `id` INT PRIMARY KEY AUTO_INCREMENT,
    `first_name` VARCHAR(30) NOT NULL,
    `middle_name` VARCHAR(30) NOT NULL,
    `last_name` VARCHAR(30) NOT NULL,
    `job_title` VARCHAR(40),
    `department_id` INT NOT NULL,
    `hire_date` DATETIME DEFAULT NOW(),
    `salary` DOUBLE(6 , 2 ) NOT NULL,
    `address_id` INT,
    FOREIGN KEY (`department_id`)
        REFERENCES departments (`id`),
    FOREIGN KEY (`address_id`)
        REFERENCES addresses (`id`)
);

INSERT INTO towns(`name`)
VALUES
('Sofia'),
('Plovdiv'),
('Varna'),
('Burgas');

INSERT INTO departments(`name`)
VALUES
('Engineering'),
('Sales'),
('Marketing'),
('Software Development'),
('Quality Assurance');

INSERT INTO employees(`first_name`,`middle_name`,`last_name`, `job_title`, `department_id`, `hire_date`, `salary`)
VALUES
('Ivan', 'Ivanov', 'Ivanov', '.NET Developer', 4, '2013-02-01 00:00:00', 3500.00),
('Petar', 'Petrov', 'Petrov', 'Senior Engineer', 1, '2004-03-02 00:00:00', 4000.00),
('Maria', 'Petrova', 'Ivanova', 'Intern', 5, '2016-08-28 00:00:00', 525.25),
('Georgi', 'Terziev', 'Ivanov', 'CEO', 2, '2007-12-09 00:00:00', 3000.00),
('Peter', 'Pan', 'Pan', 'Intern', 3, '2016-08-28 00:00:00', 599.88);

SELECT 
    *
FROM
    employees;

# Query 14. Basic Select All Fields, 
# Query 15. Basic Select All Fields and Order Them
# Query 16. Basic Select Some Fields
SELECT 
    `name`
FROM
    towns AS t
ORDER BY t.name;
SELECT 
    `name`
FROM
    departments AS d
ORDER BY d.name;
SELECT 
    `first_name`, `last_name`, `job_title`, `salary`
FROM
    employees AS e
ORDER BY e.salary DESC;

# Query 17. Increase Employees Salary
UPDATE employees 
SET 
    salary = salary * 1.1;

SELECT 
    salary
FROM
    employees;