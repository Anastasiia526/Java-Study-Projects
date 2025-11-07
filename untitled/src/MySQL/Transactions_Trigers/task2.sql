DELIMITER |
CREATE database MyFunkDB;|
USE MyFunkDB;|
DROP database MyFunkDB;|

CREATE table name_phone_employee(
id INT not null auto_increment PRIMARY KEY,
name VARCHAR(30),
phone VARCHAR(30)
);|

CREATE table salary_position_employee(
id INT not null auto_increment PRIMARY KEY,
salary DOUBLE NOT NULL,
positions VARCHAR(30)
);|

CREATE table maritalStatus_dateOfBirth_address_employee(
id INT auto_increment not null PRIMARY KEY,
maritalStatus VARCHAR(30),
dateOfBirth DATE,
address VARCHAR(100)
);|

CREATE table company(
id INT auto_increment NOT NULL PRIMARY KEY,
name_phone_employee_id INT,
salary_position_employee_id INT,
maritalStatus_dateOfBirth_address_employee_id INT,
foreign key(name_phone_employee_id) references name_phone_employee(id) ON DELETE CASCADE,
foreign key(salary_position_employee_id) references salary_position_employee(id) ON DELETE CASCADE,
foreign key(maritalStatus_dateOfBirth_address_employee_id) references maritalStatus_dateOfBirth_address_employee(id) ON DELETE CASCADE
);|

INSERT INTO name_phone_employee
(name, phone)
values
('Alexander', 380500011222),
('Anastasiia', 380680645245),
('Maxim', 3806611155639);|

INSERT INTO salary_position_employee
(salary, positions)
values
(90000.00, 'director'),
(45000.00, 'manager'),
(35000.00, 'worker');|

INSERT INTO maritalStatus_dateOfBirth_address_employee
(maritalStatus, dateOfBirth, address)
values
('married', '1979-12-31', 'Kvitneva street, 35'),
('unmarried', '1989-03-25', 'Torgova street, 41'),
('unmarried', '1995-07-29', 'Literaturna street, 15');|

INSERT INTO company
(name_phone_employee_id, salary_position_employee_id, maritalStatus_dateOfBirth_address_employee_id)
values
(1, 1, 3),
(2, 2, 2),
(3, 3, 1);|


DROP TRIGGER deleteSalaryPositionsEmployee;|

CREATE TRIGGER deleteSalaryPositionsEmployee
BEFORE DELETE ON name_phone_employee
FOR EACH ROW
BEGIN

DECLARE emp_salary_id INT;
DECLARE emp_info_id INT;
    
SELECT salary_position_employee_id, maritalStatus_dateOfBirth_address_employee_id
INTO emp_salary_id, emp_info_id
FROM company
WHERE name_phone_employee_id = OLD.id;

DELETE FROM company WHERE name_phone_employee_id = OLD.id;
DELETE FROM salary_position_employee WHERE id = emp_salary_id;
DELETE FROM maritalStatus_dateOfBirth_address_employee WHERE id = emp_info_id;

END;|


DELETE FROM name_phone_employee WHERE id = 1;

