create database furama_management;
create table dich_vu_di_kem(
ma_dich_vu_di_kem int primary key auto_increment,
ten_dich_vu_di_kem varchar(45),
gia double,
don_vi varchar(10),
trang_thai varchar(45)
);

INSERT INTO dich_vu_di_kem(ten_dich_vu_di_kem,gia,don_vi,trang_thai) VALUES 
  ('Karaoke',10000,'giờ','tiện nghi, hiện tại'),
  ('Thuê xe máy',10000,'chiếc','hỏng 1 xe'),
  ('Thuê xe đạp',20000,'chiếc','tốt'),
  ('Buffet buổi sáng',15000,'suất','đầy đủ đồ ăn, tráng miệng'),
  ('Buffet buổi trưa',90000,'suất','đầy đủ đồ ăn, tráng miệng'),
  ('Buffet buổi tối',16000,'suất','đầy đủ đồ ăn, tráng miệng');

select * from dich_vu_di_kem;
create table dich_vu(
ma_dich_vu int primary key auto_increment,
ten_dich_vu varchar(45),
dien_tich int,
chi_phi_thue double,
so_nguoi_toi_da int,
tieu_chuan_phong varchar(45),
mo_ta_tien_nghi_khac varchar(45),
dien_tich_ho_boi double,
so_tang int,
ma_kieu_thue int,
ma_loai_dich_vu int,
foreign key(ma_kieu_thue) references  kieu_thue(ma_kieu_thue),
foreign key(ma_loai_dich_vu) references loai_dich_vu(ma_loai_dich_vu)
);

INSERT INTO  dich_vu(ten_dich_vu,dien_tich,chi_phi_thue,so_nguoi_toi_da,tieu_chuan_phong,mo_ta_tien_nghi_khac,dien_tich_ho_boi,so_tang,ma_kieu_thue,ma_loai_dich_vu) 
VALUES 
  ('Villa Beach Front',25000,10000000,10,'vip','Có hồ bơi',500,4,3,1),
  ('House Princess 01',14000,5000000,7,'vip','Có thêm bếp nướng',null,3,2,2),
  ('Room Twin 01',5000,1000000,2,'normal','Có tivi',null,null,4,3),
  ('Villa No Beach Front',22000,9000000,8,'normal','Có hồ bơi',300,3,3,1),
  ('House Princess 02',10000,4000000,5,'normal','Có thêm bếp nướng',null,2,3,2),
  ('Room Twin 02',3000,900000,2,'normal','Có tivi',null,null,4,3);
  
select * from dich_vu;
create table kieu_thue(
ma_kieu_thue int primary key auto_increment,
ten_kieu_thue varchar(45)
);


INSERT INTO kieu_thue(ten_kieu_thue) VALUES 
  ('year'),
  ('month'),
  ('day'),
  ('hour');
select * from kieu_thue;
create table loai_dich_vu(
ma_loai_dich_vu int primary key auto_increment,
ten_loai_dich_vu varchar(45)
);


INSERT INTO loai_dich_vu(ten_loai_dich_vu) VALUES 
  ('Villa'),
  ('House'),
  ('Room');

create table hop_dong(
ma_hop_dong int primary key auto_increment,
ngay_lam datetime,
ngay_ket_thuc datetime,
tien_dat_coc double,
ma_nhan_vien int,
ma_khach_hang int,
ma_dich_vu int,
foreign key(ma_nhan_vien) references nhan_vien(ma_nhan_vien),
foreign key(ma_khach_hang) references khach_hang(ma_khach_hang),
foreign key(ma_dich_vu) references dich_vu(ma_dich_vu)
);


INSERT INTO hop_dong(ngay_lam,ngay_ket_thuc,tien_dat_coc,ma_nhan_vien,ma_khach_hang,ma_dich_vu) 
VALUES 
  ('2020-12-08','2020-12-08',0,3,1,3),
  ('2020-07-14','2020-07-21',200000,7,3,1),
  ('2021-03-15','2021-03-17',50000,3,4,2),
  ('2021-01-14','2021-01-18',100000,7,5,5),
  ('2021-07-14','2021-07-15',0,7,2,6),
  ('2021-06-01','2021-06-03',0,7,7,6),
  ('2021-09-02','2021-09-05',100000,7,4,4),
  ('2021-06-17','2021-06-18',150000,3,4,1),
  ('2020-11-19','2020-11-19',0,3,4,3),
  ('2021-04-12','2021-04-14',0,10,3,5),
  ('2021-04-25','2021-04-25',0,2,2,1),
  ('2021-05-25','2021-05-27',0,7,10,1);
select * from hop_dong;

create table hop_dong_chi_tiet(
ma_hop_dong_chi_tiet int primary key auto_increment,
ma_hop_dong int,
ma_dich_vu_di_kem int,
so_luong int,
foreign key(ma_hop_dong) references hop_dong(ma_hop_dong),
foreign key(ma_dich_vu_di_kem) references dich_vu_di_kem(ma_dich_vu_di_kem)

);

INSERT INTO hop_dong_chi_tiet(so_luong,ma_hop_dong,ma_dich_vu_di_kem) VALUES 
  (5,14,4),
  (8,14,5),
  (15,14,6),
  (1,15,1),
  (11,15,2),
  (1,13,3),
  (2,13,2),
  (2,18,2);
select * from hop_dong_chi_tiet;

create table vi_tri(
ma_vi_tri int primary key auto_increment,
ten_vi_tri varchar(45)
);

INSERT INTO vi_tri(ten_vi_tri) VALUES 
  ("Quản Lý"),
  ("Nhân Viên");
select * from vi_tri;

create table trinh_do(
ma_trinh_do int primary key auto_increment,
ten_trinh_do varchar(45)
);


INSERT INTO trinh_do(ten_trinh_do) VALUES 
  ('Trung Cấp'),
  ('Cao Đẳng'),
  ('Đại Học'),
  ('Sau Đại Học');

create table bo_phan(
ma_bo_phan int primary key auto_increment,
ten_bo_phan varchar(45)
);

INSERT INTO bo_phan(ten_bo_phan) VALUES 
  ('Sale-Marketing'),
  ('Hành chính'),
  ('Phục vụ'),
  ('Quản lý');

select * from bo_phan;

drop table if exists nhan_vien;
create table nhan_vien(
ma_nhan_vien int primary key auto_increment,
ho_ten varchar(45),
ngay_sinh date,
cmnd varchar(45),
luong DOUBLE,
sdt varchar(45),
email varchar(45),
dia_chi varchar(45),
ma_vi_tri int,
ma_trinh_do int,
ma_bo_phan int,
foreign key(ma_vi_tri) references  vi_tri(ma_vi_tri),
foreign key(ma_trinh_do) references trinh_do(ma_trinh_do),
foreign key(ma_bo_phan) references bo_phan(ma_bo_phan)
);


INSERT INTO nhan_vien(ho_ten,ngay_sinh,cmnd,luong,sdt,email,dia_chi,ma_vi_tri,ma_trinh_do,ma_bo_phan) VALUES 
  ('Nguyễn Văn An','1970-11-07',456231786,10000000,0901234121,'annguyen@gmail.com','295 Nguyễn Tất Thành, Đà Nẵng',1,3,1),
  ('Lê Văn Bình','1997-04-09',654231234,7000000,0934212314,'binhlv@gmail.com','22 Yên Bái, Đà Nẵng',1,2,2),
  ('Hồ Thị Yến','1995-12-12',999231723,14000000,0412352315,'thiyen@gmail.com','K234/11 Điện Biên Phủ, Gia Lai',1,3,2),
  ('Võ Công Toản','1980-04-04',123231365,17000000,0374443232,'toan0404@gmail.com','77 Hoàng Diệu, Quảng Trị',1,4,4),
  ('Nguyễn Bỉnh Phát','1999-12-09',454363232,6000000,0902341231,'phatphat@gmail.com','43 Yên Bái, Đà Nẵng',2,1,1),
  ('Khúc Nguyễn An Nghi','2000-11-08',964542311,7000000,0978653213,'annghi20@gmail.com','294 Nguyễn Tất Thành, Đà Nẵng',2,2,3),
  ('Nguyễn Hữu Hà','1993-01-01',534323231,8000000,0941234553,'nhh0101@gmail.com','4 Nguyễn Chí Thanh, Huế',2,3,2),
  ('Nguyễn Hà Đông','1989-09-03',234414123,9000000,0642123111,'donghanguyen@gmail.com','111 Hùng Vương, Hà Nội',2,4,4),
  ('Tòng Hoang','1982-09-03',256781231,6000000,0245144444,'hoangtong@gmail.com','213 Hàm Nghi, Đà Nẵng',2,4,4),
  ('Nguyễn Công Đạo','1994-01-08',755434343,8000000,0988767111,'nguyencongdao12@gmail.com','6 Hoà Khánh, Đồng Nai',2,3,2);


select * from nhan_vien;

drop table if exists loai_khach;
create table loai_khach(
ma_loai_khach int primary key auto_increment,
ten_loai_khach varchar(45)
);

INSERT INTO loai_khach 
  (ten_loai_khach) 
VALUES 
  ('Diamond'),
  ('Platinium'),
  ('Gold'),
  ('Silver'),
  ('Member');

create table khach_hang(
ma_khach_hang int primary key auto_increment,
ma_loai_khach int,
ho_ten varchar(45),
ngay_sinh date,
gioi_tinh BIT(1),
cmnd varchar(45),
sdt varchar(45),
email varchar(45),
dia_chi varchar(45),
foreign key(ma_loai_khach) references loai_khach(ma_loai_khach)
);

INSERT INTO khach_hang(ho_ten,ngay_sinh,gioi_tinh,cmnd,sdt,email,dia_chi,ma_loai_khach) VALUES 
  ('Nguyễn Thị Hào','1970-11-07',0,643431213,0945423362,'thihao07@gmail.com','23 Nguyễn Hoàng, Đà Nẵng',5),
  ('Phạm Xuân Diệu','1992-08-08',1,865342123,0954333333,'xuandieu92@gmail.com','K77/22 Thái Phiên, Quảng Trị',3),
  ('Trương Đình Nghệ','1990-02-27',1,488645199,0373213122,'nghenhan2702@gmail.com','K323/12 Ông Ích Khiêm, Vinh',1),
  ('Dương Văn Quan','1981-07-08',1,543432111,0490039241,'duongquan@gmail.com','K453/12 Lê Lợi, Đà Nẵng',1),
  ('Hoàng Trần Nhi Nhi','1995-12-09',0,795453345,0312345678,'nhinhi123@gmail.com','224 Lý Thái Tổ, Gia Lai',4),
  ('Tôn Nữ Mộc Châu','2005-12-06',0,732434215,0988888844,'tonnuchau@gmail.com','37 Yên Thế, Đà Nẵng',4),
  ('Nguyễn Mỹ Kim','1984-04-08',0,856453123,0912345698,'kimcuong84@gmail.com','K123/45 Lê Lợi, Hồ Chí Minh',1),
  ('Nguyễn Thị Hào','1999-04-08',0,965656433,0763212345,'haohao99@gmail.com','55 Nguyễn Văn Linh, Kon Tum',3),
  ('Trần Đại Danh','1994-07-01',1,432341235,0643343433,'danhhai99@gmail.com','24 Lý Thường Kiệt, Quảng Ngãi',1),
  ('Nguyễn Tâm Đắc','1989-07-01',1,344343432,0987654321,'dactam@gmail.com','22 Ngô Quyền, Đà Nẵng',2);
  set foreign_key_checks =0;
-- set sql_safe_updates = 1;
truncate table khach_hang;
set foreign_key_checks =1;
 -- set sql_safe_updates = 1;
select * from khach_hang;
select * from vi_tri;

-- 2.Hiển thị thông tin của tất cả nhân viên có trong hệ thống có tên bắt đầu là một trong các ký tự “H”, “T” hoặc “K” và có tối đa 15 kí tự.
select * from nhan_vien 
 where ho_ten like "H%" or ho_ten like"K%" or ho_ten like"T%" and length(ho_ten)<16;
 -- where (ho_ten like "T%" and length(ho_ten)<15)or (ho_ten like"K%"and length(ho_ten)<15)or (ho_ten like"H%"and length(ho_ten)<15);

-- 3.Hiển thị thông tin của tất cả khách hàng có độ tuổi từ 18 đến 50 tuổi và có địa chỉ ở “Đà Nẵng” hoặc “Quảng Trị”.

select  ma_khach_hang, ho_ten from khach_hang;
-- where (datediff(current_date(),ngay_sinh)/365 between 18 and 50) and (dia_chi like "%Đà Nẵng% " or dia_chi like "%Quảng Trị%");

-- 4.Đếm xem tương ứng với mỗi khách hàng đã từng đặt phòng bao nhiêu lần.
 -- Kết quả hiển thị được sắp xếp tăng dần theo số lần đặt phòng của khách hàng.
 -- Chỉ đếm những khách hàng nào có Tên loại khách hàng là “Diamond”.
 select khach_hang.ma_khach_hang, khach_hang.ho_ten, count(hop_dong.ma_khach_hang) as so_lan_dat
 from khach_hang
 join hop_dong on khach_hang.ma_khach_hang=hop_dong.ma_khach_hang
 where khach_hang.ma_loai_khach=1
 group by hop_dong.ma_khach_hang
 order by so_lan_dat;
 -- join loai_khach on hop_dong.ma_loai_khach=loai_khach.ma_loai_khach
 
 select * from hop_dong;

-- 5.Hiển thị ma_khach_hang, ho_ten, ten_loai_khach, ma_hop_dong, ten_dich_vu, ngay_lam_hop_dong, ngay_ket_thuc, tong_tien
-- (Với tổng tiền được tính theo công thức như sau: Chi Phí Thuê + Số Lượng * Giá, với Số Lượng và Giá là từ bảng dich_vu_di_kem, hop_dong_chi_tiet) 
-- cho tất cả các khách hàng đã từng đặt phòng. (những khách hàng nào chưa từng đặt phòng cũng phải hiển thị ra).
select  khach_hang.ma_khach_hang, khach_hang.ho_ten, loai_khach.ten_loai_khach,hop_dong. ma_hop_dong, dich_vu.ten_dich_vu, hop_dong.ngay_lam, hop_dong.ngay_ket_thuc,
 sum(chi_phi_thue+so_luong*gia) as tong_tien from khach_hang;


select khach_hang.ma_khach_hang, ho_ten, ten_loai_khach,hop_dong.ma_hop_dong, ten_dich_vu, ngay_lam, ngay_ket_thuc, 
sum(dich_vu.chi_phi_thue + ifnull(gia * hop_dong_chi_tiet.so_luong,0)) as tong_tien from loai_khach
left join khach_hang on loai_khach.ma_loai_khach  = khach_hang.ma_loai_khach
left join hop_dong on khach_hang.ma_khach_hang =  hop_dong.ma_khach_hang
left join hop_dong_chi_tiet on hop_dong.ma_hop_dong = hop_dong_chi_tiet.ma_hop_dong
left join dich_vu_di_kem on hop_dong_chi_tiet.ma_dich_vu_di_kem = dich_vu_di_kem.ma_dich_vu_di_kem
left join dich_vu on hop_dong.ma_dich_vu = dich_vu.ma_dich_vu
group by  hop_dong.ma_hop_dong
order by khach_hang.ma_khach_hang;

-- 6.
select dich_vu.ma_dich_vu, dich_vu.ten_dich_vu, dich_vu.dien_tich, dich_vu.chi_phi_thue, loai_dich_vu.ten_loai_dich_vu 
from loai_dich_vu
left join dich_vu on loai_dich_vu.ma_loai_dich_vu=dich_vu.ma_loai_dich_vu
left join hop_dong on dich_vu.ma_dich_vu = hop_dong.ma_dich_vu
where dich_vu.ten_dich_vu 
 not in (select dich_vu.ten_dich_vu 
from dich_vu
 join hop_dong on dich_vu.ma_dich_vu = hop_dong.ma_dich_vu
 where hop_dong.ngay_lam between   '2021-01-01' and '2021-03-31'
)
group by dich_vu.ma_dich_vu
order by dich_vu.ma_dich_vu;
  
-- 7.
select dich_vu.ma_dich_vu, dich_vu.ten_dich_vu, dich_vu.dien_tich, dich_vu.so_nguoi_toi_da, dich_vu.chi_phi_thue, loai_dich_vu.ten_loai_dich_vu 
from loai_dich_vu
left join dich_vu on loai_dich_vu.ma_loai_dich_vu=dich_vu.ma_loai_dich_vu
left join hop_dong on dich_vu.ma_dich_vu=hop_dong.ma_dich_vu
where dich_vu.ten_dich_vu 
in ( select dich_vu.ten_dich_vu 
from dich_vu
left join hop_dong on dich_vu.ma_dich_vu=hop_dong.ma_dich_vu
where (year(hop_dong.ngay_lam)='2020')
)
group by dich_vu.ma_dich_vu
order by dich_vu.ma_dich_vu;


-- 8.
-- cach 1
select distinct ho_ten from khach_hang;
-- cach 2
select ho_ten from khach_hang group by ho_ten;
-- cach 3
select ho_ten from khach_hang union 
select ho_ten from khach_hang;

-- 9.
select month(hop_dong.ngay_lam) as thang, count(hop_dong.ma_hop_dong) as tong_so_hop_dong
from hop_dong
where year(hop_dong.ngay_lam)=2021
group by month(hop_dong.ngay_lam)
order by hop_dong.ngay_lam;

-- 10.
select hop_dong.ma_hop_dong, hop_dong.ngay_lam, ngay_ket_thuc, tien_dat_coc, sum(coalesce(hop_dong_chi_tiet.so_luong,0)) as so_luong_dich_vu_di_kem 
from hop_dong
left join hop_dong_chi_tiet on hop_dong.ma_hop_dong = hop_dong_chi_tiet.ma_hop_dong_chi_tiet
left join dich_vu_di_kem on hop_dong_chi_tiet.ma_dich_vu_di_kem = dich_vu_di_kem.ma_dich_vu_di_kem
group by hop_dong.ma_hop_dong;

-- 11.
select  dich_vu_di_kem.ma_dich_vu_di_kem, dich_vu_di_kem.ten_dich_vu_di_kem,loai_khach.ten_loai_khach,khach_hang.dia_chi
from dich_vu_di_kem
join hop_dong_chi_tiet on dich_vu_di_kem.ma_dich_vu_di_kem = hop_dong_chi_tiet.ma_dich_vu_di_kem
join hop_dong on hop_dong_chi_tiet.ma_hop_dong = hop_dong.ma_hop_dong
join khach_hang on hop_dong.ma_khach_hang = khach_hang.ma_khach_hang
join loai_khach on khach_hang.ma_loai_khach = loai_khach.ma_loai_khach
where (loai_khach.ten_loai_khach="Diamond" and ((khach_hang.dia_chi like "%Vinh") or (khach_hang.dia_chi like "%Quảng Ngãi"))); 

-- 12.
select hop_dong.ma_hop_dong, nhan_vien.ho_ten, khach_hang.ho_ten, khach_hang.sdt, dich_vu.ma_dich_vu , dich_vu.ten_dich_vu,sum(ifnull( hop_dong_chi_tiet.so_luong ,0)) as so_luong, hop_dong.tien_dat_coc
from hop_dong
left join nhan_vien on hop_dong.ma_nhan_vien = nhan_vien.ma_nhan_vien
left join khach_hang on hop_dong.ma_khach_hang = khach_hang.ma_khach_hang
left join dich_vu on hop_dong.ma_dich_vu = dich_vu.ma_dich_vu
left join hop_dong_chi_tiet on hop_dong.ma_hop_dong = hop_dong_chi_tiet.ma_hop_dong
where hop_dong.ngay_lam between '2020-10-01 00:00:00' and '2020-12-31 23:59:59'
group by hop_dong.ma_hop_dong;


-- 13.
select dich_vu_di_kem.ma_dich_vu_di_kem, dich_vu_di_kem.ten_dich_vu_di_kem, sum(ifnull( hop_dong_chi_tiet.so_luong ,0)) as so_lan_dung_nhieu_nhat
from dich_vu_di_kem
join hop_dong_chi_tiet on dich_vu_di_kem.ma_dich_vu_di_kem = hop_dong_chi_tiet.ma_dich_vu_di_kem
join hop_dong on hop_dong_chi_tiet.ma_hop_dong = hop_dong.ma_hop_dong
group by hop_dong_chi_tiet.ma_dich_vu_di_kem
having so_lan_dung_nhieu_nhat >= all (select sum(ifnull( hop_dong_chi_tiet.so_luong ,0)) from hop_dong_chi_tiet group by hop_dong_chi_tiet.ma_dich_vu_di_kem);


-- 14.
select hd.ma_hop_dong, ldv.ten_loai_dich_vu, dvdk.ten_dich_vu_di_kem, count(hdct.ma_dich_vu_di_kem) as so_lan_su_dung 
from hop_dong hd
inner join hop_dong_chi_tiet hdct on hd.ma_hop_dong=hdct.ma_hop_dong
inner join dich_vu_di_kem dvdk on hdct.ma_dich_vu_di_kem=dvdk.ma_dich_vu_di_kem
inner join dich_vu dv on hd.ma_dich_vu = dv.ma_dich_vu
inner join loai_dich_vu ldv on dv.ma_loai_dich_vu=ldv.ma_loai_dich_vu
group by dvdk.ma_dich_vu_di_kem
having  so_lan_su_dung =2
order by hd.ma_hop_dong;

-- 15.
select nhan_vien.ma_nhan_vien, nhan_vien.ho_ten as ho_ten_nhan_vien, trinh_do.ma_trinh_do, bo_phan.ten_bo_phan, nhan_vien.sdt, nhan_vien.dia_chi
from nhan_vien
join hop_dong on nhan_vien.ma_nhan_vien = hop_dong.ma_nhan_vien
left join trinh_do on trinh_do.ma_trinh_do = nhan_vien.ma_trinh_do
left join bo_phan on bo_phan.ma_bo_phan = nhan_vien.ma_bo_phan
where hop_dong.ngay_lam between "2020-01-01" and "2021-12-31"
group by hop_dong.ma_nhan_vien
-- mới chỉ lập được tối đa 3 hợp đồng từ năm 2020 đến 2021
having count(hop_dong.ma_nhan_vien) <= 3 
order by nhan_vien.ma_nhan_vien;


-- 16.

set sql_safe_updates = 0;
delete from nhan_vien 
where nhan_vien.ma_nhan_vien in (
select nhan_vien.ma_nhan_vien
from nhan_vien
where nhan_vien.ma_nhan_vien not in (
select nhan_vien.ma_nhan_vien
from nhan_vien
join hop_dong on nhan_vien.ma_nhan_vien = hop_dong.ma_nhan_vien
where (hop_dong.ngay_lam between "2019-01-01" and "2021-12-31") ));
set sql_safe_updates = 1;
select * from nhan_vien;

set sql_safe_updates = 0;
delete from nhan_vien
where nhan_vien.ma_nhan_vien not in 
(select distinct ma_nhan_vien from hop_dong
where year(ngay_lam) between 2020 and 2021);
set sql_safe_updates = 1;
select * from nhan_vien;


-- 17.
 set sql_safe_updates = 0 ;
 
 update khach_hang
 set loai_khach.ma_loai_khach = 1
 where khach_hang.ma_khach_hang in (
 select khach_hang.ma_khach_hang from (
 select khach_hang.ma_khach_hang, khach_hang.ho_ten from hop_dong
 left join khach_hang on hop_dong.ma_khach_hang = khach_hang.ma_khach_hang
 left join loai_khach on khach_hang.ma_loai_khach = loai_khach.ma_loai_khach
 left join hop_dong_chi_tiet on hop_dong.ma_hop_dong = hop_dong_chi_tiet.ma_hop_dong
 left join dich_vu_di_kem on hop_dong_chi_tiet.ma_dich_vu_di_kem = dich_vu_di_kem.ma_dich_vu_di_kem
 group by khach_hang.ma_loai_khach
 having khach_hang.ma_loai_khach = 2 and sum(dich_vu.chi_phi_thue+ ifnull(hop_dong_chi_tiet.so_luong*dich_vu_di_kem.gia,0 ) ) > 10000000)as t);
set sql_safe_updates = 1;
select khach_hang.ma_khach_hang, khach_hang.ho_ten, khach_hang.ma_loai_khach from hop_dong
 left join khach_hang on hop_dong.ma_khach_hang = khach_hang.ma_khach_hang
 left join loai_khach on khach_hang.ma_loai_khach = loai_khach.ma_loai_khach
 left join hop_dong_chi_tiet on hop_dong.ma_hop_dong = hop_dong_chi_tiet.ma_hop_dong
 left join dich_vu_di_kem on hop_dong_chi_tiet.ma_dich_vu_di_kem = dich_vu_di_kem.ma_dich_vu_di_kem
 group by khach_hang.ma_khach_hang;


set sql_safe_updates = 0;
update khach_hang
set loai_khach.ma_loai_khach = 1
where ma_khach_hang not in (select khach_hang.ma_khach_hang from 
(select khach_hang.ma_khach_hang, khach_hang.ho_ten
 from loai_khach left join khach_hang on loai_khach.ma_loai_khach=khach_hang.ma_loai_khach
 left join hop_dong on khach_hang.ma_khach_hang=hop_dong.ma_khach_hang
 left join hop_dong_chi_tiet on hop_dong.ma_hop_dong = hop_dong_chi_tiet.ma_hop_dong
 left join dich_vu on hop_dong.ma_dich_vu = dich_vu.ma_dich_vu
 left join dich_vu_di_kem on hop_dong_chi_tiet.ma_dich_vu_di_kem=dich_vu_di_kem.ma_dich_vu_di_kem
 group by khach_hang.ma_loai_khach
 having khach_hang.ma_loai_khach = 2 and  sum(dich_vu.chi_phi_thue+coalesce(hop_dong_chi_tiet.so_luong*dich_vu_di_kem.gia,0))>10000000) as t);
set sql_safe_updates = 1;


select khach_hang.ma_khach_hang, khach_hang.ho_ten, loai_khach.ma_loai_khach, loai_khach.ten_loai_khach 
from loai_khach left join khach_hang on loai_khach.ma_loai_khach=khach_hang.ma_loai_khach
 left join hop_dong on khach_hang.ma_khach_hang=hop_dong.ma_khach_hang
 left join hop_dong_chi_tiet on hop_dong.ma_hop_dong = hop_dong_chi_tiet.ma_hop_dong
 left join dich_vu on hop_dong.ma_dich_vu = dich_vu.ma_dich_vu
 left join dich_vu_di_kem on hop_dong_chi_tiet.ma_dich_vu_di_kem=dich_vu_di_kem.ma_dich_vu_di_kem
 group by khach_hang.ma_khach_hang;
 
 -- 18.	Xóa những khách hàng có hợp đồng trước năm 2021 (chú ý ràng buộc giữa các bảng).
 set sql_safe_updates = 0;
 set foreign_key_checks =0;
 delete from khach_hang
 where khach_hang.ma_khach_hang in (
 select khach_hang.ma_khach_hang from (
 select khach_hang.ma_khach_hang from khach_hang 
 join hop_dong on khach_hang.ma_khach_hang = hop_dong.ma_khach_hang
 where year(ngay_lam)  < 2021 ) as t );
 set foreign_key_checks =1;
 set sql_safe_updates = 1;
 
 
 -- 19.	Cập nhật giá cho các dịch vụ đi kèm được sử dụng trên 10 lần trong năm 2020 lên gấp đôi.
 set sql_safe_updates = 0;
update dich_vu_di_kem set dich_vu_di_kem.gia = dich_vu_di_kem.gia*2
where ma_dich_vu_di_kem in (select * from 
(select dich_vu_di_kem.ma_dich_vu_di_kem
from hop_dong 
inner join hop_dong_chi_tiet on hop_dong.ma_hop_dong = hop_dong_chi_tiet.ma_hop_dong
inner join dich_vu_di_kem on hop_dong_chi_tiet.ma_dich_vu_di_kem = dich_vu_di_kem.ma_dich_vu_di_kem
where year(hop_dong.ngay_lam)=2020
group by  hop_dong_chi_tiet.ma_dich_vu_di_kem
having sum(hop_dong_chi_tiet.so_luong) >10) as temp);
set sql_safe_updates = 1;

select dich_vu_di_kem.ma_dich_vu_di_kem, dich_vu_di_kem.ten_dich_vu_di_kem, hop_dong_chi_tiet.so_luong, dich_vu_di_kem.gia
from hop_dong 
inner join hop_dong_chi_tiet on hop_dong.ma_hop_dong = hop_dong_chi_tiet.ma_hop_dong
inner join dich_vu_di_kem on hop_dong_chi_tiet.ma_dich_vu_di_kem = dich_vu_di_kem.ma_dich_vu_di_kem
 group by  hop_dong_chi_tiet.ma_dich_vu_di_kem
order by hop_dong_chi_tiet.ma_dich_vu_di_kem;
 
 -- 20.
 select ma_nhan_vien, ho_ten, email, sdt, ngay_sinh, dia_chi, "nhan vien" as loai
from nhan_vien
union all
select ma_khach_hang, ho_ten, email, sdt, ngay_sinh, dia_chi, "khach hang" as loai
from khach_hang;

-- 21.
create view v_nhanvien as
select nhan_vien.* from nhan_vien inner join
hop_dong on nhan_vien.ma_nhan_vien=hop_dong.ma_hop_dong
where nhan_vien.dia_chi = "Hải Châu" and date(hop_dong.ngay_lam)="2019-12-12"
group by hop_dong.ma_nhan_vien
having sum(hop_dong.ma_nhan_vien) > 10;
select * from v_nhanvien;
