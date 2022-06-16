create database exam_module3;
use exam_module3;
-- CREATE TABLE patient(
-- patient_id varchar(20) primary key,
-- `name` varchar(20) NOT NULL,
-- day_in date NOT NULL,
-- date_out date NOT NULL,
-- reason varchar(100)
-- );
-- delete from patient where patient_id = 'BN-435';
-- 	


-- CREATE TABLE records(
-- records_id varchar(20) primary key,
-- patient_id varchar(20),
-- foreign key (patient_id) references patient(patient_id)
-- on delete cascade
-- );

-- select * from records;
-- insert into patient(patient_id,`name`,day_in,date_out,reason) values
-- ('BN-123','Nguyễn Văn C','2019/08/10','2020/08/10','Suy Thận mạn'),
-- ('BN-984','Tôn Nữ D','2020/01/11','2020/08/08','Covid 2019'),
-- ('BN-153','Đoàn Thị E','2017/08/07','2018/08/08','Ung thư phổi'),
-- ('BN-435','Nguyễn Văn A','2016/08/07','2019/08/08','Ung thư gan');
--   select * from patient where `name` like '%n%' ;
--   insert into patient(patient_id,`name`,day_in,date_out,reason) values
-- ('BN-124','Nguyễn Hieu C','2002/03/27','2020/08/10','Suy Thận mạn');
--   
-- insert into records values ('BA-001','BN-435');
-- insert into records values ('BA-112','BN-123');
-- insert into records values ('BA-223','BN-984');
-- insert into records values ('BA-444','BN-153');
-- insert into records values ('BA-445','BN-153');
-- select * from records;
-- select * from patient
-- left join records on patient.patient_id = records.patient_id;




create table sach(
ma_sach varchar(20) primary key,
ten_sach varchar(20),
tac_gia varchar(20),
mo_to varchar(50),
so_luong int(5)
);

create table hoc_sinh(
ma_hs varchar(20) primary key,
ho_ten varchar(20),
lop varchar(20)
);
insert into hoc_sinh value
('HS-001', 'TRUNG HIEU','10A1'),
('HS-002', 'PHUONG','10A1'),
('HS-003', 'AN','10A1');
select * from hoc_sinh; 
create table the_muon_sach(
ma_muon_sach varchar(20) primary key,
ma_sach varchar(20),
ma_hs varchar(20),
trang_thai bit(1),
ngay_muon date,
ngay_tra date,
foreign key(ma_sach) references sach(ma_sach),
foreign key(ma_hs) references hoc_sinh(ma_hs)
);

'Nguyễn Văn C','2019/08/10','2020/08/10','Suy Thận mạn'),
-- ('BN-984','Tôn Nữ D','2020/01/11','2020/08/08','Covid 2019'),
-- ('BN-153','Đoàn Thị E','2017/08/07','2018/08/08','Ung thư phổi'),
-- ('BN-435','Nguyễn Văn A','2016/08/07','2019/08/08','Ung thư gan'
insert into sach value
('S-001','Sổ đỏ','VũTrọng Phụng', 'nhân vật chính là xuân tóc đỏ...', 5),
('S-002','Truyện kiều','VũTrọng Phụng', 'cuộc đời thúy kiều...', 10),
('S-003','Dế mèn','Tô Hoài', 'dế mèn', 15);
select * from sach;
insert into the_muon_sach value
('MS-001','S-001','HS-001','2020/01/11','2020/08/08' );
-- insert into hoc_sinh value;

create procedure xoa_sach (
id_sach varchar(25)
begin
update sach
set so_luong = so_luong - 1,
where sach.ma_sach = id_sach
end //
// DELIMITER ;

call xoa_sach('S-001');