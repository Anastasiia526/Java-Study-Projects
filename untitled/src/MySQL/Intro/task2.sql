CREATE DATABASE MyDB;

USE MyDB;

CREATE TABLE employees
(
id_employee INT AUTO_INCREMENT NOT NULL,
name VARCHAR(30),
phone_number VARCHAR(30),
PRIMARY KEY(id_employee)
);
INSERT INTO employees
(name, phone_number)
VALUES
('Badger', '0660070300');

INSERT INTO employees
(name, phone_number)
VALUES
('Baldwin', '0630070300');

INSERT INTO employees
(name, phone_number)
VALUES
('Balthasar', '0631101011');


CREATE TABLE infoEmployees(
id_employee INT AUTO_INCREMENT NOT NULL,
salary DOUBLE,
position VARCHAR(30),
PRIMARY KEY(id_employee)
);

INSERT INTO infoEmployees
(salary, position)
VALUES
(10001.00, 'manager');

INSERT INTO infoEmployees
(salary, position)
VALUES
(11000.00, 'researcher');


INSERT INTO infoEmployees
(salary, position)
VALUES
(9999.00, 'lab_technician');


CREATE TABLE privateInfoEmployees(
id_employee INT AUTO_INCREMENT NOT NULL,
marital_status VARCHAR(20),
date_of_birth DATE,
place_of_residence VARCHAR(50),
PRIMARY KEY(id_employee));

INSERT INTO privateInfoEmployees
(marital_status, date_of_birth, place_of_residence)
VALUES
('married', '1989-12-15', '15, Travneva street');

INSERT INTO privateInfoEmployees
(marital_status, date_of_birth, place_of_residence)
VALUES
('divorced', '2000-01-01', '68B, Victory Avenue');

INSERT INTO privateInfoEmployees
(marital_status, date_of_birth, place_of_residence)
VALUES
('single', '1990-07-01', '69, street Architects');

SELECT id_employee 
FROM MyDB.infoEmployees
WHERE salary > 10000.00;

UPDATE privateInfoEmployees
SET marital_status = 'married'
WHERE id_employee = 3;