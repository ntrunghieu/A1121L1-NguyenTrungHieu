create database student_management;
use student_management;
-- tao bang
create table student(
id int auto_increment ,
`name` varchar(50),
age int(3),
country varchar(50)
);

-- them du lieu vao bang

insert into student(`name`, age, country) values('hieu',19,'da nang'),('phuong',19,'da nang'),('quang hieu',19,'da nang');






-- lay du lieu tu bang
select id,`name`,age from student;