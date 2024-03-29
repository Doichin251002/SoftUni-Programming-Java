# Query 1. One-To-One Relationship
CREATE TABLE people (
    `person_id` INT PRIMARY KEY AUTO_INCREMENT,
    `first_name` VARCHAR(30) NOT NULL,
    `salary` DECIMAL(7 , 2),
    `passport_id` INT NOT NULL UNIQUE
    
);

CREATE TABLE passports (
    `passport_id` INT PRIMARY KEY AUTO_INCREMENT,
    `passport_number` VARCHAR(10) NOT NULL UNIQUE
);

ALTER TABLE people
ADD CONSTRAINT fk_people_passports 
FOREIGN KEY (`passport_id`)
REFERENCES passports (`passport_id`);

ALTER TABLE passports
AUTO_INCREMENT 100;

INSERT INTO passports(`passport_id`, `passport_number`)
VALUES
(101, 'N34FG21B'),
(102, 'K65LO4R7'),
(103, 'ZE657QP2');

SELECT * FROM passports;

INSERT INTO people
VALUES
(1, 'Roberto', 43300.00, 102),
(2, 'Tom', 56100.00, 103),
(3, 'Yana', 60200.00, 101);

SELECT * FROM people;

# Query 2. One-To-Many Relationship
CREATE TABLE manufacturers (
    `manufacturer_id` INT PRIMARY KEY AUTO_INCREMENT,
    `name` VARCHAR(30) UNIQUE NOT NULL,
    `established_on` DATE NOT NULL
);

CREATE TABLE models (
`model_id` INT PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(30) NOT NULL,
`manufacturer_id` INT NOT NULL,
CONSTRAINT fk_models_manufacturers FOREIGN KEY (`manufacturer_id`) REFERENCES manufacturers(`manufacturer_id`)
);

ALTER TABLE models
AUTO_INCREMENT = 101;

INSERT INTO manufacturers(`name`, `established_on`)
VALUES
('BMW', '1916-03-01'),
('Tesla', '2003-01-01'),
('Lada', '1966-05-01');

INSERT INTO models(`name`, `manufacturer_id`)
VALUES
('X1', 1),
('i6', 1),
('Model S', 2),
('Model X', 2),
('Model 3', 2),
('Nova', 3);

# Query 3. Many-To-Many Relationship
CREATE TABLE students (
    `student_id` INT PRIMARY KEY AUTO_INCREMENT,
    `name` VARCHAR(30) NOT NULL
);

CREATE TABLE exams (
    `exam_id` INT PRIMARY KEY AUTO_INCREMENT,
    `name` VARCHAR(30) NOT NULL
)  AUTO_INCREMENT=101;

CREATE TABLE students_exams (
    `student_id` INT,
    `exam_id` INT,
    CONSTRAINT pk_students_exams PRIMARY KEY (`student_id` , `exam_id`),
    CONSTRAINT fk_students_exams FOREIGN KEY (`student_id`)
        REFERENCES students (`student_id`),
    CONSTRAINT fk_exams_students FOREIGN KEY (`exam_id`)
        REFERENCES exams (`exam_id`)
);

INSERT INTO students(`name`)
VALUES
('Mila'),
('Toni'),
('Ron');

INSERT INTO exams(`name`)
VALUES
('Spring MVC'),
('Neo4j'),
('Oracle 11g');

INSERT INTO students_exams(`student_id`, `exam_id`)
VALUES
(1, 101),
(1, 102),
(2, 101),
(3, 103),
(2, 102),
(2, 103);

# Query 4. Self-Referencing
CREATE TABLE teachers(
`teacher_id` INT PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(30),
`manager_id` INT
);

ALTER TABLE teachers AUTO_INCREMENT = 101;

INSERT INTO teachers(`teacher_id`, `name`, `manager_id`)
VALUES
(101, 'John', NULL),
(102, 'Maya', 106),
(103, 'Silvia', 106),
(104, 'Ted', 105),
(105, 'Mark', 101),
(106, 'Greta', 101);

ALTER TABLE teachers
ADD CONSTRAINT fk_teachers_manager_id FOREIGN KEY (`manager_id`) REFERENCES teachers(`teacher_id`);

# Query 5. Online Store Database
CREATE TABLE item_types(
`item_type_id` INT(11) PRIMARY KEY,
`name` VARCHAR(50)
);

CREATE TABLE items(
`item_id` INT(11) PRIMARY KEY,
`name` VARCHAR(50),
`item_type_id` INT(11),
CONSTRAINT fk_items_item_types FOREIGN KEY (`item_type_id`) REFERENCES item_types(`item_type_id`)
);

CREATE TABLE cities(
`city_id` INT(11) PRIMARY KEY,
`name` VARCHAR(50)
);

CREATE TABLE customers(
`customer_id` INT(11) PRIMARY KEY,
`name` VARCHAR(50),
`birthday` DATE,
`city_id` INT(11),
CONSTRAINT fk_customers_cities FOREIGN KEY (`city_id`) REFERENCES cities(`city_id`)
);

CREATE TABLE orders(
`order_id` INT(11) PRIMARY KEY,
`customer_id` INT(11),
CONSTRAINT fk_orders_customers FOREIGN KEY (`customer_id`) REFERENCES customers(`customer_id`)
);

CREATE TABLE order_items(
`order_id` INT(11),
`item_id` INT(11),
CONSTRAINT pk_order_items PRIMARY KEY (`order_id`, `item_id`),
CONSTRAINT fk_order_items_orders FOREIGN KEY(`order_id`) REFERENCES orders(`order_id`),
CONSTRAINT fk_order_items_items FOREIGN KEY(`item_id`) REFERENCES items(`item_id`)
);

# Query 6. University Database
CREATE TABLE subjects(
`subject_id` INT(11) PRIMARY KEY AUTO_INCREMENT,
`subject_name` VARCHAR(50) NOT NULL
);

CREATE TABLE majors(
`major_id` INT(11) PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(50)
);

CREATE TABLE students(
`student_id` INT(11) PRIMARY KEY AUTO_INCREMENT,
`student_number` VARCHAR(12) NOT NULL,
`student_name` VARCHAR(50) NOT NULL,
`major_id` INT(11) NOT NULL,
CONSTRAINT fk_students_majors FOREIGN KEY (`major_id`) REFERENCES majors(`major_id`)
);

CREATE TABLE payments(
`payment_id` INT(11) PRIMARY KEY AUTO_INCREMENT,
`payment_date` DATE,
`payment_amount` DECIMAL(8, 2),
`student_id` INT(11) NOT NULL,
CONSTRAINT fk_payments_students FOREIGN KEY (`student_id`) REFERENCES students(`student_id`)
);

CREATE TABLE agenda(
`student_id` INT(11),
`subject_id` INT(11),
CONSTRAINT pk_agenda PRIMARY KEY (`student_id`, `subject_id`),
CONSTRAINT fk_agenda_students FOREIGN KEY (`student_id`) REFERENCES students(`student_id`),
CONSTRAINT fk_agenda_subjects FOREIGN KEY (`subject_id`) REFERENCES subjects(`subject_id`)
);

# Query 9. Peaks in Rila
USE geography;

SELECT `mountain_range`, `peak_name`, `elevation` AS `peak_elevation`
FROM mountains AS m
JOIN peaks AS p ON p.`mountain_id` = m.`id`
WHERE `mountain_range` = 'Rila'
ORDER BY `peak_elevation` DESC;