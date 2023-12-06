create database fruitDB;

CREATE TABLE fruitTBL (
  ID INT PRIMARY KEY AUTO_INCREMENT,
  Name VARCHAR(50)
);

insert into fruitTBL
	(Name)
values
	('Dừa'),
    ('Xoài'),
    ('Ổi'),
    ('Mận'),
    ('Khoai');
    
select * from fruitTBL;

CREATE TABLE patientTBL (
  id INT PRIMARY KEY AUTO_INCREMENT,
  `name` VARCHAR(50),
  hospitalFee double
);

insert into patientTBL
	(`name`,hospitalFee)
values
	('NGUYEN TRUNG HIEU',213),
    ('VO HONG HANH',322),
    ('LUONG TUAN',544),
    ('ANH TU',5443),
    ('NGUYET TRANG',655);
    
    select * from patientTBL;
    