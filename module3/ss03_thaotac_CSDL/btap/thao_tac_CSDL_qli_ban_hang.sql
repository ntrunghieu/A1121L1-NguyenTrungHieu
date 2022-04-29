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
insert into customer (customer_name,customer_age)
values("hieu", 17);

insert into `order`(order_date, total_price) 
values("2006/03/21",null),
("2006/03/23",null),
("2006/03/16",null);

insert into product(product_name, product_price)
values("may giat", 3),
("tu lanh", 5),
("dieu hoa", 6),
("quat", 1),
("bep dien", 2);
insert into product(product_name, product_price)
values("tivi", 7);

insert into order_detail
values(1,1,3),(1,3,7),(1,4,2),(2,1,1),(3,1,8),(2,5,4),(2,3,3);

-- Hiển thị các thông tin  gồm oID, oDate, oPrice của tất cả các hóa đơn trong bảng Order
select order_id,order_date,total_price from `order`;
select * from customer;
select * from product;
select * from `order`;

-- Hiển thị danh sách các khách hàng đã mua hàng, và danh sách sản phẩm được mua bởi các khách
select customer.customer_name,product.product_name, product.product_price from customer 
inner join  `order` on customer.customer_id=`order`.customer_id
inner join  order_detail on `order`.order_id=order_detail.order_id
inner join product on order_detail.product_id=product.product_id;

-- Hiển thị mã hóa đơn, ngày bán và giá tiền của từng hóa đơn
-- (giá một hóa đơn được tính bằng tổng giá bán của từng loại mặt hàng xuất hiện trong hóa đơn. Giá bán của từng loại được tính = odQTY*pPrice)
select `order`.order_id, `order`.order_date,  sum(order_detail.order_quantity*product.product_price) as total_price
from `order`
inner join order_detail on `order`.order_id=order_detail.order_id
inner join product on order_detail.product_id=product.product_id
group by `order`.order_id;

select customer_name from customer 
left join `order` on customer.customer_id = `order`.customer_id
where `order`.customer_id is not null;

