CREATE DATABASE quan_ly_diem_thi;
use quan_ly_diem_thi;

create table hoc_sinh(
ma_hs varchar(20) PRIMARY KEY,
ten_hs varchar(50),
ngay_sinh date,
gioi_tinh varchar(10),
lop varchar(20)
);

create table mon_hoc(
ma_mh varchar(20) PRIMARY KEY,
ten_mh varchar(50)
);

create table bang_diem(
ma_hs varchar(20),
ma_mh varchar(20),
diem_thi int,
ngay_kt date,
PRIMARY KEY(ma_hs, ma_mh),
FOREIGN KEY(ma_hs) references hoc_sinh(ma_hs),
FOREIGN KEY(ma_mh) references mon_hoc(ma_mh)
);

create table giang_vien(
ma_gv varchar(20) PRIMARY KEY,
ten_gv varchar(50),
sdt_gv varchar(20)
);

alter table mon_hoc add ma_gv varchar(20);
alter table mon_hoc add constraint FK_ma_gv foreign key(ma_gv) references giang_vien(ma_gv);