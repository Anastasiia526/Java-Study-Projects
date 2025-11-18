USE ShopDB;
DROP table customers;

CREATE TABLE Customers
	(

	FName varchar(15) NOT NULL,
	LName varchar(15) NOT NULL,
	MName varchar(15) NULL,
	Address1 varchar(50) NOT NULL,
	Address2 varchar(50) NULL,
	City char(10) NOT NULL,
	Phone char(12) NOT NULL UNIQUE,
	DateInSystem date NULL
	);

ALTER table customers
ADD column customerNo int auto_increment not null,
ADD primary key(customerNo);

CREATE INDEX customerNo ON customers(customerNo);

CREATE INDEX city ON customers(city);

INSERT Customers 
(LName, FName, MName, Address1, Address2, City, Phone,DateInSystem)
VALUES
('Круковский','Анатолій','Петрович','Лужна 15',NULL,'Харків','(092)3212211','2009-11-20');
INSERT Customers 
(LName, FName, MName, Address1, Address2, City, Phone,DateInSystem)
VALUES
('Дурнєв','Віктор','Вікторович','Зелінська 10',NULL,'Київ','(067)4242132','2010-03-08');
INSERT Customers 
(LName, FName, MName, Address1, Address2, City, Phone,DateInSystem)
VALUES
('Унакій','Зігмунд','Федорович','Дегтяревська 5',NULL,'Київ','(092)7612343','2010-08-17');
INSERT Customers 
(LName, FName, MName, Address1, Address2, City, Phone,DateInSystem)
VALUES
('Левченко','Віталий','Вікторович','Глущенка 5','Драйзера 12','Київ','(053)3456788','2010-08-20');
INSERT Customers 
(LName, FName, MName, Address1, Address2, City, Phone,DateInSystem)
VALUES
('Вижлецов','Олег','Олегович','Київская 3','Одеська 8','Чернігів','(044)2134212','2010-09-18');

SELECT * FROM customers;
explain SELECT * FROM customers WHERE city IN ('Київ');


CREATE TABLE Customers
	(
	CustomerNo int auto_increment not null,
	FName varchar(15) NOT NULL,
	LName varchar(15) NOT NULL,
	MName varchar(15) NULL,
	Address1 varchar(50) NOT NULL,
	Address2 varchar(50) NULL,
	City char(10) NOT NULL,
	Phone char(12) NOT NULL UNIQUE,
	DateInSystem date NULL,
    primary key(customerno)
	);
    
    CREATE INDEX customerNo ON customers(customerNo);
    
    SHOW INDEXES FROM customers;
    
    SELECT * FROM customers;
    explain SELECT * FROM customers WHERE customerNo IN (3);