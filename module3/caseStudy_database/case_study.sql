create database furama_management;
use furama_management;
create table nhan_vien(
manhanvien int primary key auto_increment,
ho_ten varchar(45),
ngay_sinh date,
cmnd varchar(45),
luong DOUBLE,
sdt varchar(45),
email varchar(45),
dia_chi varchar(45),
ma_vi_tri int,
ma_trinh_do int,
ma_bo_phan int
);
create table khach_hang(
ma_kh int primary key,
ma_loai_khach int,
ho_ten varchar(45),
ngay_sinh date,
gioi_tinh BIT(1),
cmnd varchar(45),
sdt varchar(45),
email varchar(45),
dia_chi varchar(45)
);

insert into nhan_vien(ho_ten ,ngay_sinh ,cmnd ,
luong ,sdt ,email ,dia_chi ,ma_vi_tri, 
ma_trinh_do ,ma_bo_phan ) values ('trung hieu','2002-03-27',2309123,23,2342,'hieu@ád',
'ngo quyen', 23412,2134,222);