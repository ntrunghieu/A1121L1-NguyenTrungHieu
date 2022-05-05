create database demo;
use demo;

-- Tạo bảng Products
create table products(
id int primary key auto_increment,
product_code varchar(20),
product_name varchar(45),
product_price double,
product_amount int,
product_description varchar(45),
product_status varchar(45)
);

-- chen du lieu
insert into products(product_code,product_name,product_price,product_amount,product_description,product_status)
values 
('F2G1', 'Ferrari 250 GT0 1963', 76.0, 6, 'made in Italia', 'import'),
('AMV', 'Aston Martin Victor', 58.5, 35, 'made in England', 'import'),
('MBB', 'Mulliner Bacalar Bentley', 42.0, 16, 'made in England', 'import'),
('VRL', 'Veneno Roader Lamborghini', 36.7, 62, 'made in Italia', 'import'),
('VP', 'Vinfast President', 25.0, 99, 'made in Vietnam', 'export');

-- lay thong tin tu bang products
 explain select * from products where product_name = "Vinfasst President";

-- Tạo Unique Index trên bảng Products (sử dụng cột productCode để tạo chỉ mục)
create unique index products_index
on products(product_code);

-- Tạo Composite Index trên bảng Products (sử dụng 2 cột productName và productPrice)
create index products_name_price
on  products(product_name, product_price);

-- Sử dụng câu lệnh EXPLAIN để biết được câu lệnh SQL 
explain select * from products where product_name = "Vinfasst President";

-- xoa index 
drop index products_name_price on products;

-- Tạo view lấy về các thông tin: productCode, productName, productPrice, productStatus từ bảng products.
create view products_view as
select products.product_code, products.product_name, products.product_price, products.product_status
from products;

-- lay du lieu tu view
select * from products_view;

-- Tiến hành sửa đổi view
create or replace view products_view as 
select product_code, product_name, product_price, product_status
from products;
select * from products_view;

-- Tiến hành xoá view
drop view products_view;

-- Tạo store procedure lấy tất cả thông tin của tất cả các sản phẩm trong bảng product
 DELIMITER //
create procedure get_infor_product()
begin
	select * from products;
end //
// DELIMITER ;
call get_infor_product();
-- Tạo store procedure thêm một sản phẩm mới
DELIMITER //
create procedure add_new_products(
product_code varchar(20),
product_name varchar(45),
product_price double,
product_amount int,
product_description varchar(45),
product_status varchar(45))
begin

	insert into products(product_code,product_name,product_price,product_amount,product_description,product_status)
    values
    (product_code,product_name,product_price,product_amount,product_description,product_status);

end //
// DELIMITER ;
call add_new_products('MB', 'Maybach', 66.0, 16,'made in Germany', 'import');
select * from products;
-- Tạo store procedure sửa thông tin sản phẩm theo id
DELIMITER //
create procedure edit_products (
id int ,
product_code varchar(25),
product_name varchar(50),
product_price double,
product_amount int,
product_description varchar(50),
product_status varchar(50))
begin
update products
set product_code = product_code,
product_name = product_name,
product_price = product_price,
product_amount = product_amount,
product_description = product_description,
product_status = product_status
where products.id = id;
end; 
// DELIMITER ;
call edit_products(5, 'RRS', 'Rolls-Royce Sweptail', 120.0, 9,'made in England', 'import');
select * from products;
-- Tạo store procedure xoá sản phẩm theo id
delimiter //
-- drop procedure del_by_id //
create procedure del_by_id(
id int
)
begin
delete from products
where products.id = id;
end //
// delimiter ;

call del_by_id(4);
select * from products;






