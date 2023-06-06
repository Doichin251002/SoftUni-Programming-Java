USE soft_uni;
# Query 1. Employees with Salary Above 35000
CREATE PROCEDURE usp_get_employees_salary_above_35000()
BEGIN
    DECLARE upper_limit INT;
    SET upper_limit = 35000;
    SELECT first_name, last_name 
    FROM employees 
    WHERE salary > upper_limit 
    ORDER BY first_name, last_name, employee_id;
END;

CALL usp_get_employees_salary_above_35000();

# Query 2. Employees with Salary Above Number
CREATE PROCEDURE usp_get_employees_salary_above(salary_limit DECIMAL(19, 4))
BEGIN
    SELECT first_name, last_name
    FROM employees
    WHERE salary >= salary_limit
    ORDER BY first_name, last_name, employee_id;
END;

SET @salary_limit = 45000;
CALL usp_get_employees_salary_above(@salary_limit);

# Query 3. Town Names Starting With
CREATE PROCEDURE usp_get_towns_starting_with(letter VARCHAR(50))
BEGIN
    SELECT name FROM towns WHERE name LIKE CONCAT(letter, '%') ORDER BY name;
END;

SET @town_letter = 'B';
CALL usp_get_towns_starting_with(@town_letter);

# Query 4. Employees from Town
CREATE PROCEDURE usp_get_employees_from_town(town VARCHAR(50))
BEGIN
    SELECT e.first_name, e.last_name
    FROM employees AS e
             JOIN addresses a ON a.address_id = e.address_id
             JOIN towns t ON t.town_id = a.town_id
    WHERE t.name = town
    ORDER BY e.first_name, e.last_name, e.employee_id;
END;

SET @town_name = 'Sofia';
CALL usp_get_employees_from_town(@town_name);

# Query 5. Salary Level Function
CREATE FUNCTION ufn_get_salary_level(salary DECIMAL(19, 4)) RETURNS VARCHAR(7)
    DETERMINISTIC
BEGIN
    RETURN (CASE WHEN salary < 30000 THEN 'Low' WHEN salary <= 50000 THEN 'Average' ELSE 'High' END);
END;

SET @salary = 50000;
SELECT ufn_get_salary_level(@salary);

# Query 6. Employees by Salary Level
CREATE PROCEDURE usp_get_employees_by_salary_level(salary_level VARCHAR(7))
BEGIN
    SELECT first_name, last_name
    FROM employees
    WHERE ( SELECT ufn_get_salary_level(salary) = salary_level )
    ORDER BY first_name DESC, last_name DESC;
END;

SET @salary_level = 'High';
CALL usp_get_employees_by_salary_level(@salary_level);

# Query 7. Define Function
CREATE FUNCTION ufn_is_word_comprised(set_of_letters VARCHAR(50), word VARCHAR(50)) RETURNS INT
    DETERMINISTIC
BEGIN
    RETURN word REGEXP CONCAT('^[', set_of_letters, ']+$');
END;

SET @set_of_letters = 'Nikolay';
SET @word = 'Nik';
SELECT ufn_is_word_comprised(@set_of_letters, @word);

# Query 8. Find Full Name
CREATE PROCEDURE usp_get_holders_full_name()
BEGIN
    SELECT CONCAT_WS(' ', first_name, last_name) AS full_name 
    FROM account_holders 
    ORDER BY full_name, id;
END;

CALL usp_get_holders_full_name();

# Query 9. People with Balance Higher Than
CREATE PROCEDURE usp_get_holders_with_balance_higher_than(salary DECIMAL(19, 4))
BEGIN
    SELECT first_name, last_name
    FROM account_holders
             JOIN accounts a ON account_holders.id = a.account_holder_id
    GROUP BY account_holder_id
    HAVING SUM(a.balance) > salary
    ORDER BY account_holders.id;
END;

SET @salary_limit = 7000;
CALL usp_get_holders_with_balance_higher_than(@salary_limit);

# Query 10. Future Value Function
CREATE FUNCTION ufn_calculate_future_value(sum DECIMAL(19, 4), yearly_interest_rate DECIMAL(4, 2), years INT) RETURNS DECIMAL(19, 4)
    DETERMINISTIC
BEGIN
    RETURN sum * (POW((1 + yearly_interest_rate), years));
END;

SET @initial_sum = 1000;
SET @yearly_interest_rate = 0.5;
SET @years = 5;

SELECT ufn_calculate_future_value(@initial_sum, @yearly_interest_rate, @years);

# Query 11. Calculating Interest
CREATE PROCEDURE usp_calculate_future_value_for_account(account_id INT, interest_rate DECIMAL(19, 4))
BEGIN
    SELECT a.id,
           ah.first_name,
           ah.last_name,
           a.balance AS currency_balance,
           ( SELECT ufn_calculate_future_value(a.balance, interest_rate, 5) ) AS balance_in_5_years
    FROM account_holders AS ah
             JOIN accounts a ON ah.id = a.account_holder_id
    WHERE a.id = account_id;
END;

SET @account_id_1 = 1;
SET @yearly_interest_rate = 0.1;

CALL usp_calculate_future_value_for_account(@account_id_1, @yearly_interest_rate);

# Query 12. Deposit Money
CREATE PROCEDURE usp_deposit_money(account_id INT, money_amount DECIMAL(19, 4))
BEGIN
    START TRANSACTION;
    IF (money_amount <= 0) THEN
        ROLLBACK;
    ELSE
        UPDATE accounts 
        SET balance = balance + money_amount 
        WHERE id = account_id;
    END IF;
END;

SET @money_amount = 10;

CALL usp_deposit_money(@account_id_1, @money_amount);

SELECT *
FROM accounts
WHERE id = @account_id_1;

# Query 13. Withdraw Money
CREATE PROCEDURE usp_withdraw_money(account_id INT, money_amount DECIMAL(19, 4))
BEGIN
    START TRANSACTION;
    IF (( SELECT (balance - money_amount) 
			FROM accounts 
			WHERE id = account_id ) < 0) 
        OR (money_amount <= 0) THEN
        ROLLBACK;
    ELSE
        UPDATE accounts 
        SET balance = balance - money_amount 
        WHERE id = account_id;
    END IF;
END;

CALL usp_withdraw_money(@account_id_1, @money_amount);

SELECT *
FROM accounts
WHERE id = @account_id_1;

# Query 14. Money Transfer
CREATE PROCEDURE usp_transfer_money(from_account_id INT, to_account_id INT, money_amount DECIMAL(19, 4))
BEGIN
    START TRANSACTION;
    IF (from_account_id NOT IN ( SELECT id FROM accounts )) OR (to_account_id NOT IN ( SELECT id FROM accounts )) OR
       (( SELECT (balance - money_amount) FROM accounts WHERE id = from_account_id ) < 0) OR (money_amount <= 0) THEN
        ROLLBACK;
    ELSE
        UPDATE accounts 
        SET balance = balance - money_amount 
        WHERE id = from_account_id;
        
        UPDATE accounts 
        SET balance = balance + money_amount 
        WHERE id = to_account_id;
    END IF;
END;

SET @account_id_2 = 2;

CALL usp_transfer_money(@account_id_1, @account_id_2, @money_amount);

SELECT *
FROM accounts
WHERE id IN (1, 2);

# Query 15. Log Accounts Trigger
CREATE TABLE logs
(
    log_id     INT PRIMARY KEY AUTO_INCREMENT,
    account_id INT,
    old_sum    DECIMAL(19, 4),
    new_sum    DECIMAL(19, 4)
);

CREATE TRIGGER tr_balance_updated
    AFTER UPDATE
    ON accounts
    FOR EACH ROW
BEGIN
    IF (old.balance <> new.balance) THEN
        INSERT logs(account_id, old_sum, new_sum) 
        VALUE (old.id, old.balance, new.balance);
    END IF;
END;

CALL usp_transfer_money(1, 2, 10);
CALL usp_transfer_money(2, 1, 10);

SELECT *
FROM logs;

# Query 16. Emails Trigger
CREATE TABLE notification_emails
(
    id        INT PRIMARY KEY AUTO_INCREMENT,
    recipient INT,
    subject   TEXT,
    body      TEXT
);

CREATE TRIGGER tr_notification_emails
    AFTER INSERT
    ON logs
    FOR EACH ROW
BEGIN
    INSERT INTO notification_emails(recipient, subject, body) 
	VALUES (new.account_id,
    CONCAT('Balance change for account: ', new.account_id),
    CONCAT_WS(' ', 'On', DATE_FORMAT(NOW(), '%b %d %y at %r'), 
    'your balance was changed from', new.old_sum, 'to', new.new_sum));
END;

SELECT * FROM notification_emails;