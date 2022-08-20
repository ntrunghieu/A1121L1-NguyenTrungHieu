create database exam2;
use exam2;
create table product(
name_product varchar(45),
price int(12),
quantity int(5),
color varchar(35),
category_id int,
foreign key(category_id)  references category(id_category)
);
insert into product 
values
('iphone11',799,12,'purple,yellow,green',1);
select * from product;
select * from product where name_product ='iphone11' ;
create table category(
id_category int auto_increment primary key,
name_category varchar(45)
);
insert into category(name_category)
values
('Phone'),
('Television');
select * from category;