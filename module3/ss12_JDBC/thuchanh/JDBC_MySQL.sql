create database JDBC;
create table users (
 id  int(3) NOT NULL AUTO_INCREMENT,
 name varchar(120) NOT NULL,
 email varchar(220) NOT NULL,
 country varchar(120),
 PRIMARY KEY (id)
);

create table permission(
id int(11) primary key,
name varchar(50)
);

create table user_Permision(

permision_id int(11),

user_id int(11)

);
insert into permission(id, name) values(1, 'add');

insert into permission(id, name) values(2, 'edit');

insert into permission(id, name) values(3, 'delete');

insert into permission(id, name) values(4, 'view');

select * from permission;

insert into users(name, email, country) values('Minh','minh@codegym.vn','Viet Nam');
insert into users(name, email, country) values('Kante','kante@che.uk','Kenia');
select * from users;
select * from users where country like '%v%';

DELIMITER //
create procedure get_user_by_id(in num int(11))
begin
	SELECT * FROM users WHERE id = num;
end //
// DELIMITER ;
call get_user_by_id(20);
select*from users 
