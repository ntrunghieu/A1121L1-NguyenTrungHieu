use quan_ly_khach_hang;

create table customer(
customer_id int auto_increment primary key,
customer_name varchar(50),
customer_age int
);

create table `order`(
order_id int auto_increment primary key,
customer_id int,
order_date date,
total_price double,
foreign key (customer_id) references customer(customer_id)
);

create table product(
product_id int auto_increment primary key,
product_name varchar(100),
product_price double
);

create table order_detail(
order_id int,
product_id int,
order_quantity int,
primary key (order_id, product_id),
foreign key (order_id) references `order`(order_id),
foreign key (product_id) references product(product_id)
);


insert into customer (customer_name,customer_age) 
values("minh quan", 10),
("ngoc oanh", 20),
("hong ha", 50);

insert into `order`(order_date, total_price) 
values("2006/03/21"),
("2006/03/23"),
("2006/03/16");

insert into product(product_name, product_price)
values("may giat", 3),
("tu lanh", 5),
("dieu hoa", 6),
("quat", 1),
("bep dien", 2);

insert into  order_detail(order_quantity)
values(3),(7),(2),(1),(8),(4),(3);




