create DATABASE human_resources_department;
use human_resources_department;

CREATE table employee
(
employee_id int auto_increment not null,
Last_Name varchar(30) not null,
First_Name varchar(30) not null,
date_of_bith date,
phone varchar (15) unique,
email varchar(15) unique,
primary key(employee_id)
);

create table HR_specialists
(
hr_id int auto_increment not null,
employee_id int,
Last_Name varchar(30) not null,
First_Name varchar(30) not null,
primary key(hr_id)
);

create table positions
(
position_id int not null auto_increment,
position_name varchar(30),
salary_grade double not null,
salary_min double not null,
salary_max double not null,
primary key(position_id)
);

create table employee_position
(
employee_id int,
hr_id int,
position_id int,
foreign key(employee_id) references employee(employee_id),
foreign key(hr_id) references HR_specialists(hr_id),
foreign key(position_id) references positions(position_id)
);
