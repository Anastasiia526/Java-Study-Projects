Create database Wholesale_warehouse;
Use wholesale_warehouse;

create table suppliers(
supplier_id int auto_increment not null,
company_name varchar(40) not null,
contact_person varchar(30),
phone varchar(30) not null,
email varchar(30) not null unique,
adress varchar(100) not null,
primary key(supplier_id)
);

create table categories (
    category_id int auto_increment,
    category_name varchar(100) not null,
    primary key(category_id)
);

create table products
(
products_id int auto_increment not null,
products_name varchar(30) not null,
description_products varchar(30),
unit_of_measurement varchar(15),
category_id int not null,
supplier_id int not null,
purchase_price double,
selling_price double,
remaining_stock int default 0,
foreign key(category_id) references categories(category_id),
foreign key(supplier_id) references suppliers(supplier_id),
primary key(products_id)
);

create table staff
(
staff_id int auto_increment not null,
first_and_last_name varchar(40) not null,
positions varchar(30),
phone varchar(30) not null,
email varchar(30) not null unique,
primary key(staff_id)
);

create table customers
(
customer_id int auto_increment,
customer_name varchar(70) not null,
contact_person varchar(100) not null,
phone varchar(30),
email varchar(30) unique,
adress varchar(100),
primary key(customer_id)
);

create table orders
(
order_id int auto_increment,
customer_id int not null,
staff_id int,
order_date date not null,
total_amount double,
foreign key (customer_id) references customers(customer_id)
on delete cascade,
foreign key (staff_id) references staff(staff_id)
on delete set null,
primary key(order_id)
);

create table order_details (
order_detail_id int auto_increment,
order_id int not null,
products_id int not null,
quantity int not null,
unit_price double not null,
foreign key (order_id) references orders(order_id)
on delete cascade,
foreign key (products_id) references products(products_id)
on delete cascade,
primary key(order_detail_id)
);

create table deliveries (
delivery_id int auto_increment,
supplier_id int not null,
staff_id int,
delivery_date date not null,
total_cost double,
foreign key (supplier_id) references suppliers(supplier_id)
on delete cascade,
foreign key (staff_id) references staff(staff_id)
on delete set null,
primary key(delivery_id)
);

create table delivery_details (
delivery_detail_id int auto_increment,
delivery_id int not null,
products_id int not null,
quantity int not null,
purchase_price double not null,
foreign key (delivery_id) references deliveries(delivery_id)
on delete cascade,
foreign key (products_id) references products(products_id)
on delete cascade,
primary key(delivery_detail_id)
);