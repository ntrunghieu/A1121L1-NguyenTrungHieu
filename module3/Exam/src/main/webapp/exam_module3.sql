create database exam_module3;
use exam_module3;
CREATE TABLE patient(
patient_id varchar(20) primary key,
`name` varchar(20) NOT NULL,
day_in date NOT NULL,
date_out date NOT NULL,
reason varchar(100)
);
select * from patient;
CREATE TABLE records(
records_id varchar(20) primary key,
patient_id varchar(20),
foreign key (patient_id) references patient(patient_id)
on delete cascade
);
insert into patient(patient_id,`name`,day_in,date_out,reason) values
('BN-123','Nguyễn Văn C','2019/08/10','2020/08/10','Suy Thận mạn'),
('BN-984','Tôn Nữ D','2020/01/11','2020/08/08','Covid 2019'),
('BN-153','Đoàn Thị E','2017/08/07','2018/08/08','Ung thư phổi'),
('BN-435','Nguyễn Văn A','2016/08/07','2019/08/08','Ung thư gan');
  
insert into records values ('BA-001','BN-435');
insert into records values ('BA-112','BN-123');
insert into records values ('BA-223','BN-984');
insert into records values ('BA-444','BN-153');
insert into records values ('BA-445','BN-153');

select * from patient
left join records on patient.patient_id = records.patient_id;