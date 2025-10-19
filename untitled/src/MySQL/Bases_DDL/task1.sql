create dataBase HumanResourcesDepartment;
Use HumanResourcesDepartment;
Drop table employee;
Drop table positions;



create table employee
( 
employee_id int auto_increment not null,
Fname varchar(30) not null,
Lname varchar(30) not null,
date_of_bith date,
phone varchar (15) unique,
email varchar(15) unique,
primary key(employee_id) 
);

create table positions
(
position_id int not null auto_increment,
position_name varchar(30),
salary_grade double not null,
primary key(position_id)
);

create table departments
(
department_id int auto_increment not null,
department_name varchar(30) not null,
head_employee_id int,
employee_id int,
foreign key(head_employee_id) references employee(employee_id)
on delete set null,
primary key(department_id)
);

create table contracts
(
contract_id int auto_increment not null,
employee_id int not null,
position_id int not null,
start_date date not null,
end_date date,
contract_type varchar(30),
foreign key(position_id) references positions(position_id)
on update cascade,
foreign key(employee_id) references employee(employee_id)
on delete cascade,
primary key(contract_id)
);

create table salaries
(
salary_id int auto_increment not null,
employee_id int not null,
period_date date not null,
salary_amount double,
deductions double,
bonus double,
foreign key(employee_id) references employee(employee_id)
on delete cascade,
primary key(salary_id)
);

create table vacation
(
vacation_id int auto_increment not null,
employee_id int not null,
start_date date not null,
end_date date not null,
vacation_type varchar(30),
foreign key(employee_id) references employee(employee_id)
on delete cascade,
primary key(vacation_id)
);
