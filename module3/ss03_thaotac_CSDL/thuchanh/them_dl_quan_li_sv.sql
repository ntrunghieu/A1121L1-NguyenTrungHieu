
use quan_ly_sinh_vien;

create table class(
class_id int auto_increment PRIMARY KEY,
class_name varchar(60) not null,
start_date datetime not null,
`status` bit 
);

create table student(
student_id int auto_increment PRIMARY KEY,
student_name varchar(30) not null,
address varchar(50),
phone varchar(20),
`status` bit,
class_id int not null,
FOREIGN KEY (class_id) references class(class_id)
);

create table `subject`(
sub_id int auto_increment PRIMARY KEY,
sub_name varchar(30) not null,
credit tinyint not null default 1,
check (credit>=1),
`status` bit default 1
);

create table mark(
mark_id int auto_increment PRIMARY KEY,
sub_id int not null,
student_id int not null ,
mark float default 0,
check (mark between 0 and 100),
exam_time tinyint default 1,
FOREIGN KEY (sub_id) references `subject`(sub_id),
FOREIGN KEY (student_id) references student(student_id)
);

-- them du lieu vao class
INSERT INTO class (`class_name`, `start_date`, `status`) VALUES ('A1', '2008-12-20', 1);
INSERT INTO class (`class_name`, `start_date`, `status`) VALUES ('A2', '2008-12-22', 1);
INSERT INTO class (`class_name`,`start_date`, `status`) VALUES ('B3',current_date,0);

-- them du lieu vao class
insert into student(student_name, address, phone, Status, class_id) values('hieu','da nang', 0702656987,1,1);
insert into student(student_name, address, phone, Status, class_id) values('phuong','hai phong', 0905669556,1,1);
insert into student(student_name, address, phone, Status, class_id) values('quang hieu','ha noi', 0912384,0,2);
insert into student(student_name, address, phone, Status, class_id) values('thang','da nang', 091232384,1,2);
-- them du lieu vao subject
insert into `subject`(sub_name,credit,`status`) values( 'CF', 5, 1),
													 ( 'C', 6, 1),
													 ( 'HDJ', 5, 1),
													 ( 'RDBMS', 10, 1);


INSERT INTO mark(sub_id, student_id, mark, exam_time)
VALUES (1, 2, 8, 1),
       (2, 3, 12, 1);
       
select * from `mark`;
