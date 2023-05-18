-- soft_uni Problem 1
USE soft_uni;

SELECT 
    `first_name`, `last_name`
FROM
    employees
WHERE
    `first_name` LIKE 'Sa%'
ORDER BY `employee_id`;

-- Problem 2
SELECT 
    `first_name`, `last_name`
FROM
    employees
WHERE
    `last_name` LIKE '%ei%'
ORDER BY `employee_id`;

-- Problem 3
SELECT 
    `first_name`
FROM
    employees
WHERE
    (`department_id` IN (3 , 10))
        AND (EXTRACT(YEAR FROM `hire_date`) BETWEEN '1995' AND '2005')
ORDER BY `employee_id`;

-- Problem 4
SELECT 
    `first_name`, `last_name`
FROM
    employees
WHERE
    `job_title` NOT LIKE '%engineer%'
ORDER BY `employee_id`;

-- Problem 5
SELECT 
    `name`
FROM
    towns
WHERE
    CHAR_LENGTH(`name`) IN (5 , 6)
ORDER BY `name`;

-- Problem 6
SELECT 
    *
FROM
    towns
WHERE
    `name` REGEXP '^[MKBE]'
ORDER BY `name`;

-- Problem 7
SELECT 
    *
FROM
    towns
WHERE
    `name` NOT LIKE 'R%'
        AND `name` NOT LIKE 'B%'
        AND `name` NOT LIKE 'D%'
ORDER BY `name`;

-- Problem 8
CREATE VIEW v_employees_hired_after_2000 AS
    SELECT 
        `first_name`, `last_name`
    FROM
        employees
    WHERE
        YEAR(`hire_date`) > 2000;

SELECT 
    *
FROM
    v_employees_hired_after_2000;

-- Problem 9
SELECT 
    `first_name`, `last_name`
FROM
    employees
WHERE
    CHAR_LENGTH(`last_name`) = 5;

-- geography Problem 10
USE geography;

SELECT 
    `country_name`, `iso_code`
FROM
    countries
WHERE
    `country_name` LIKE '%A%A%A%'
ORDER BY `iso_code`;

-- Problem 11
SELECT 
    p.`peak_name`,
    r.`river_name`,
    LOWER(CONCAT(LEFT(p.`peak_name`,
                        LENGTH(p.`peak_name`) - 1),
                    r.`river_name`)) AS `mix`
FROM
    peaks AS p,
    rivers AS r
WHERE
    LOWER(RIGHT(p.`peak_name`, 1)) = LOWER(LEFT(r.`river_name`, 1))
ORDER BY `mix`;

-- diablo Problem 12
USE diablo;

SELECT 
    `name`, DATE_FORMAT(`start`, '%Y-%m-%d') AS `start`
FROM
    games
WHERE
    YEAR(`start`) IN (2011 , 2012)
ORDER BY `start` , `name`
LIMIT 50;

-- Problem 13
SELECT 
    `user_name`,
    SUBSTRING(`email`,
        LOCATE('@', `email`) + 1) AS `email provider`
FROM
    users
ORDER BY `email provider` , `user_name`;

-- Problem 14
SELECT 
    `user_name`, `ip_address`
FROM
    users
WHERE
    `ip_address` LIKE '___.1%.%.___'
ORDER BY `user_name`;

-- Problem 15
SELECT 
    `name` AS `game`,
    CASE
        WHEN HOUR(`start`) BETWEEN 0 AND 11 THEN 'Morning'
        WHEN HOUR(`start`) BETWEEN 12 AND 17 THEN 'Afternoon'
        ELSE 'Evening'
    END AS `Part of the Day`,
    CASE
        WHEN `duration` <= 3 THEN 'Extra Short'
        WHEN `duration` BETWEEN 4 AND 6 THEN 'Short'
        WHEN `duration` BETWEEN 7 AND 10 THEN 'Long'
        ELSE 'Extra Long'
    END AS `Duration`
FROM
    games;
    
-- orders Problem 16
USE orders;

SELECT 
    `product_name`,
    `order_date`,
    DATE_ADD(`order_date`, INTERVAL 3 DAY) AS `pay_due`,
    DATE_ADD(`order_date`, INTERVAL 1 MONTH) AS `deliver_due`
FROM
    orders;