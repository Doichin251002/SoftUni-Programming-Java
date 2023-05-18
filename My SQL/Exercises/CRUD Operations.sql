-- soft_uni Problem 1
USE soft_uni;

SELECT 
    *
FROM
    departments
ORDER BY `department_id`;

-- Problem 2
SELECT 
    `name`
FROM
    departments
ORDER BY `department_id`;

-- Problem 3
SELECT 
    `first_name`, `last_name`, `salary`
FROM
    employees
ORDER BY `employee_id`;

-- Problem 4
SELECT 
    `first_name`, `middle_name`, `last_name`
FROM
    employees
ORDER BY `employee_id`;

-- Problem 5
SELECT 
    CONCAT(`first_name`,
            '.',
            `last_name`,
            '@softuni.bg') AS full_email_address
FROM
    employees;

-- Problem 6
SELECT DISTINCT
    `salary`
FROM
    employees;

-- Problem 7
SELECT 
    `employee_id` AS `id`,
    `first_name` AS `First Name`,
    `last_name` AS `Last Name`,
    `middle_name` AS `Middle Name`,
    `job_title` AS `Job Title`,
    `department_id` AS `Dept ID`,
    `manager_id` AS `Mngr ID`,
    `hire_date` AS `Hire Date`,
    `salary`,
    `address_id`
FROM
    employees
WHERE
    `job_title` = 'Sales Representative';

-- Problem 8
SELECT 
    `first_name`, `last_name`, `job_title`
FROM
    employees
WHERE
    `salary` BETWEEN 20000 AND 30000
ORDER BY `employee_id`;

-- Problem 9
SELECT 
    CONCAT(`first_name`,
            ' ',
            `middle_name`,
            ' ',
            `last_name`) AS `Full Name`
FROM
    employees
WHERE
    `salary` IN (25000 , 14000, 12500, 23600);

-- Problem 10
SELECT 
    `first_name`, `last_name`
FROM
    employees
WHERE
    `manager_id` IS NULL;

-- Problem 11
SELECT 
    `first_name`, `last_name`, `salary`
FROM
    employees
WHERE
    `salary` > 50000
ORDER BY `salary` DESC;

-- Problem 12
SELECT 
    `first_name`, `last_name`
FROM
    employees
ORDER BY `salary` DESC
LIMIT 5;

-- Problem 13
SELECT 
    `first_name`, `last_name`
FROM
    employees
WHERE
    NOT `department_id` = 4;

-- Problem 14
SELECT 
    *
FROM
    employees
ORDER BY `salary` DESC , `first_name` ASC , `last_name` DESC , `middle_name` ASC , `employee_id` ASC;
 
 -- Problem 15
CREATE VIEW v_employees_salaries AS
    SELECT 
        `first_name`, `last_name`, `salary`
    FROM
        employees;
    
-- Problem 16
CREATE VIEW v_employees_job_titles AS
    SELECT 
        CONCAT_WS(' ',
                `first_name`,
                `middle_name`,
                `last_name`) AS full_name,
        `job_title`
    FROM
        employees;

-- Problem 17
SELECT DISTINCT
    `job_title`
FROM
    employees
ORDER BY `job_title`;

-- Problem 18
SELECT 
    *
FROM
    projects
ORDER BY `start_date` , `name` , `project_id`
LIMIT 10;

-- Problem 19
SELECT 
    `first_name`, `last_name`, `hire_date`
FROM
    employees
ORDER BY `hire_date` DESC
LIMIT 7;

-- Problem 20
UPDATE employees 
SET 
    `salary` = `salary` * 1.12
WHERE
    `department_id` IN (1 , 2, 4, 11);

SELECT 
    `salary`
FROM
    employees;

-- geography Problem 21
USE geography;

SELECT 
    `peak_name`
FROM
    peaks
ORDER BY `peak_name`;

-- Problem 22
SELECT 
    `country_name`, `population`
FROM
    countries
WHERE
    continent_code LIKE 'EU'
ORDER BY `population` DESC , `country_name`
LIMIT 30;

-- Problem 23
SELECT 
    `country_name`,
    `country_code`,
    IF(`currency_code` = 'EUR',
        'Euro',
        'Not Euro') AS 'currency'
FROM
    countries
ORDER BY `country_name`;

-- diablo Problem 24
USE diablo;

SELECT 
    `name`
FROM
    characters
ORDER BY `name`;