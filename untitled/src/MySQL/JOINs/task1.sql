CREATE database MyJoinsDB;

USE MyJoinsDB;

CREATE table employee
(
employee_id int auto_increment not null,
FLName_employee varchar(40) not null,
phone_employee varchar(30) not null,
primary key(employee_id)
);

INSERT INTO employee
(FLName_employee, phone_employee)
values
('Homer Simpson', '0501231122'),
('Marjorie Simpson', '0504564455'),
('Bartholomew Simpson','0665341619'),
('Peter Griffin','0954451245'),
('Fred Flintstone','0681652593');

DROP table employee;

CREATE table position_salary
(
position_id int auto_increment not null,
employee_id int,
position_employee varchar(40) not null,
salary_employee double not null,
foreign key(employee_id) references employee(employee_id),
primary key(position_id)
);

DROP table position_salary;

INSERT INTO position_salary
(employee_id, position_employee, salary_employee)
values
(1, 'chief_executive_officer', 100000.00),
(2, 'director', 70020.00),
(3, 'manager', 40000.00),
(4, 'manager', 47000.00),
(5, 'worker', 38000.00);

CREATE TABLE personal_info
(
personal_info_id int auto_increment not null,
employee_id int,
marital_status varchar(15) not null,
date_of_birth varchar(20),
adress varchar(100) not null,
foreign key(employee_id) references employee(employee_id),
primary key(personal_info_id)
);


DROP table personal_info;

INSERT INTO personal_info
(employee_id, marital_status, date_of_birth, adress)
values
(1, 'married', 'May 12, 1956', '742 Evergreen Terrace, Springfield'),
(2, 'married', 'March 19, 1956', '742 Evergreen Terrace, Springfield'),
(3, 'unmarried', 'April 1, 1979.', '742 Evergreen Terrace, Springfield'),
(4, 'married', 'July 10, 1965', '31 Spooner Street, Quahog, Rhode Island'),
(5, 'unmarried', '1960', 'Bedrock');

SELECT FLName_employee, phone_employee, adress FROM employee
INNER JOIN personal_info
ON employee.employee_id = personal_info.personal_info_id;

Select FLName_employee, date_of_birth, phone_employee From personal_info
inner join employee
ON personal_info.personal_info_id = employee.employee_id
where not marital_status = 'married';

SELECT FLName_employee, date_of_birth, phone_employee From personal_info
INNER JOIN employee
ON personal_info.personal_info_id = employee.employee_id
INNER JOIN position_salary
ON personal_info.personal_info_id = position_salary.position_id
WHERE position_employee like 'manager';
