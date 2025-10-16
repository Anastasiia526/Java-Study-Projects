CREATE DATABASE carsshop;

USE carsshop;

CREATE TABLE cars(
id INT AUTO_INCREMENT NOT NULL,
mark VARCHAR(30),
model VARCHAR(30),
engine INT,
price DOUBLE,
maxspeed INT,
PRIMARY KEY(id)
);
