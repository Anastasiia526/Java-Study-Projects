CREATE DATABASE Employee;
USE  Employee;

CREATE table weapons_issue
(
LFMName_officer varchar(30) not null,
platoon int not null,
weapon varchar(10) not null,
issued_weapon varchar(30) 
);

INSERT INTO weapons_issue
(LFMName_officer, platoon, weapon, issued_weapon)
values
('Петров В.А., оф. 205', 222, 'АК-47', 'Буров О.С., майор'),
('Петров В.А., оф. 205', 222, 'Глок20', 'Рибаков Н.Г., майор'),
('Лодарев П.С., оф. 221', 232, 'АК-74', 'Деребанов В.Я., підполковник'),
('Лодарев П.С., оф. 205', 232, 'Глок20', 'Рибаков Н.Г., майор'),
('Іващенко А.А., оф. 201', 212, 'АК-47', 'Буров О.С., майор'),
('Іващенко А.А., оф. 201', 212, 'Глок20', 'Рибаков Н.Г., майор'),
('Духов Р.М.', 200, 'АК-47', 'Буров О.С., майор');

SELECT * FROM weapons_issue;

DROP table weapons_issue;
-- 1NF

CREATE table weapons_issue
(
LFMName_officer varchar(30) not null,
personal_matter varchar(30),
platoon int not null,
weapon varchar(10) not null,
publisher varchar(30),
publisher_title varchar(20) 
);

INSERT INTO weapons_issue
(LFMName_officer, personal_matter, platoon, weapon, publisher, publisher_title)
values
('Петров В.А.', 'оф. 205', 222, 'АК-47', 'Буров О.С.', 'майор'),
('Петров В.А.', 'оф. 205', 222, 'Глок20', 'Рибаков Н.Г.', 'майор'),
('Лодарев П.С.', 'оф. 221', 232, 'АК-74', 'Деребанов В.Я.', 'підполковник'),
('Лодарев П.С.', 'оф. 205', 232, 'Глок20', 'Рибаков Н.Г.', 'майор'),
('Іващенко А.А.', 'оф. 201', 212, 'АК-47', 'Буров О.С.', 'майор'),
('Іващенко А.А.', 'оф. 201', 212, 'Глок20', 'Рибаков Н.Г.', 'майор'),
('Духов Р.М.', 'NULL', 200, 'АК-47', 'Буров О.С.', 'майор');

select * from weapons_issue;

-- 2NF

DROP table weapons_issue;

CREATE table officers
(
officer_id int auto_increment not null,
LFMName_officer varchar(30) not null,
personal_matter varchar(30),
platoon int not null,
primary key (officer_id)
);

DROP table officers;


INSERT INTO officers
(LFMName_officer, personal_matter, platoon)
values
('Петров В.А.', 'оф. 205', 222),
('Лодарев П.С.', 'оф. 221', 232),
('Іващенко А.А.', 'оф. 201', 212),
('Духов Р.М.', 'null', 200);

SELECT * FROM officers;

DROP table publishers;

CREATE table weapon
(weapon_id int auto_increment not null,
weapon varchar(15) not null,
primary key(weapon_id)
);

INSERT INTO weapon
(weapon)
values
('АК-47'),
('Глок20'),
('АК-74');

SELECT * FROM weapon;

DROP table publishers;

CREATE table publishers
(
publisher_id int auto_increment not null,
publisher varchar(30),
publisher_title varchar(20),
primary key (publisher_id)
);

INSERT INTO publishers
(publisher, publisher_title)
values
('Буров О.С.', 'майор'),
('Рибаков Н.Г.', 'майор'),
('Деребанов В.Я.', 'підполковник');

SELECT * FROM publishers;
-- 3NF

create table weapon_Issue(
officer_id int,
weapon_id int,
publisher_id int,
FOREIGN KEY(officer_id) references officers(officer_id),
foreign key(weapon_id) references weapon(weapon_id),
foreign key(publisher_id) references publishers(publisher_id)
);

INSERT into weapon_Issue
(officer_id, weapon_id, publisher_id)
values
(1, 1, 1),
(1, 2, 2),
(2, 3, 3),
(2, 2, 2),
(3, 1, 1),
(3, 2, 2),
(4, 1, 1);

SELECT * FROM weapon_Issue;
