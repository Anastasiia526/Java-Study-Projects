USE MyJoinsDB;

CREATE VIEW contact_info_employee AS
SELECT phone_employee, adress FROM employee
INNER JOIN personal_info
ON employee.employee_id = personal_info.employee_id;

SELECT * FROM contact_info_employee;

SELECT * FROM personal_info;

CREATE VIEW birthday_phone_unmarried_employee AS
SELECT date_of_birth, phone_employee FROM personal_info
INNER JOIN employee 
ON personal_info.employee_id = employee.employee_id
WHERE personal_info.marital_status LIKE 'unmarried';

DROP VIEW birthday_phone_employee;

SELECT * FROM birthday_phone_unmarried_employee;

CREATE VIEW birthday_phone_manager_employee AS
SELECT date_of_birth, phone_employee FROM personal_info
INNER JOIN employee 
ON personal_info.employee_id = employee.employee_id
INNER JOIN position_salary
ON employee.employee_id = position_salary.employee_id
WHERE position_salary.position_employee LIKE 'manager';

DROP VIEW birthday_phone_manager_employee;

SELECT * FROM birthday_phone_manager_employee;
