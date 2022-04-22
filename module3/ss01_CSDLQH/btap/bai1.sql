use student_management;
create table class (
id int primary key auto_increment,
name varchar(50)
);

create table teacher (
id int  primary key auto_increment ,
name varchar(50),
age int(11),
country varchar(50)
);

insert into class(`name`) values('duong'),('sua') ;

insert into teacher(`name`, age, country) values('chanh',28,'dn'),('chien',22,'dn'),('trung',35,'dn') ;
truncate teacher;
truncate class;
select * from teacher;
select * from class;
