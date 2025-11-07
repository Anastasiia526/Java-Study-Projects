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
foreign key(name_phone_employee_id) references name_phone_employee(id),
foreign key(salary_position_employee_id) references salary_position_employee(id),
foreign key(maritalStatus_dateOfBirth_address_employee_id) references maritalStatus_dateOfBirth_address_employee(id)
);|


DROP procedure addContactInfoEmployee;|

CREATE PROCEDURE addContactInfoEmployee(IN EmName varchar(30), IN EmPhone varchar(30), IN EmSalary double, IN EmPositions varchar(30), IN EmMaritalStatus varchar(30), IN EmDateOfBirth DATE, IN EmAddress varchar (100))

BEGIN
DECLARE em_name_id INT;
DECLARE em_salary_id INT;
DECLARE em_info_id INT;

START TRANSACTION;

INSERT name_phone_employee(name, phone)
VALUES
(EmName, EmPhone);
SET em_name_id =LAST_INSERT_ID();

INSERT salary_position_employee(salary, positions)
VALUES
(EmSalary, EmPositions);
SET em_salary_id = LAST_INSERT_ID();

INSERT maritalStatus_dateOfBirth_address_employee(maritalStatus, dateOfBirth, address)
VALUES
(EmMaritalStatus, EmDateOfBirth, EmAddress);
SET em_info_id = LAST_INSERT_ID();

INSERT company(name_phone_employee_id, salary_position_employee_id, maritalStatus_dateOfBirth_address_employee_id)
VALUES
(em_name_id, em_salary_id, em_info_id);

IF EXISTS (SELECT * FROM name_phone_employee WHERE name = EmName AND id != em_name_id)
THEN
ROLLBACK;

END IF;
COMMIT;
END;|

CALL addContactInfoEmployee('Anastasiia', '380930854428', 45000.00, 'manager', 'unmarried', '1989-03-25', 'Torgova street, 41');|
CALL addContactInfoEmployee('Alexander', '380500011222', 90000.00, 'director', 'married', '1979-12-31', 'Kvitneva street, 35');|

SELECT * FROM name_phone_employee;|