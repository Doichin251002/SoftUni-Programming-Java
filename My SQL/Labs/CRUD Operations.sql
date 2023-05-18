USE hotel;

-- Problem 1
SELECT 
    `id` AS 'No.',
    `first_name` AS 'First name',
    `last_name` AS 'Last name',
    `job_title` AS 'Job title'
FROM
    employees
ORDER BY `id`;

-- Problem 2
SELECT 
    `id` AS 'No.',
    CONCAT_WS(`first_name`, `last_name`) AS 'Full name',
    `job_title` AS 'Job title',
    `salary` AS 'Salary'
FROM
    employees
WHERE
    `salary` > 1000
ORDER BY `id`;

-- Problem 3
UPDATE employees
SET `salary` = `salary` + 100
WHERE `job_title` = 'Manager';

SELECT `salary`
FROM employees;

-- Problem 4
CREATE VIEW v_top_paid_employee AS
SELECT *
FROM employees
ORDER BY `salary` DESC
LIMIT 1;

-- Problem 5
SELECT * 
FROM employees
WHERE `department_id` = 4 AND `salary` >= 1000
ORDER BY `id`;

-- Problem 6
DELETE FROM employees
WHERE `department_id` = 1 
OR`department_id` = 2;

SELECT * 
FROM employees
ORDER BY `id`;