create database quan_li_dat_hang;
use quan_li_dat_hang;

create table donvi_khach(
ma_dv int primary key auto_increment,
ten_dv varchar(50),
dia_chi varchar(50),
sdt int(30)
);

create table nguoi_dat(
ma_nd int primary key auto_increment,
ma_dv int,
ten_nd varchar(50),
foreign key(ma_dv) references donvi_khach(ma_dv)
);

create table hang(
ma_hang int primary key auto_increment,
ma_nd int,
ma_nn int,
ma_ddg int,
ma_ng int,
ten_hang varchar(50),
dv_tinh varchar(50),
mo_ta varchar(50),
foreign key(ma_nd) references  nguoi_dat(ma_nd),
foreign key(ma_nn) references  nguoi_nhan(ma_nn),
foreign key(ma_ddg) references  noi_giao(ma_ddg),
foreign key(ma_ng) references  nguoi_giao(ma_ng)
);

create table noi_giao(
ma_ddg int primary key auto_increment,
ten_noi_giao varchar(50)
);

create table nguoi_giao(
ma_ng int primary key auto_increment,
ten_ng varchar(50)
);

create table nguoi_nhan(
ma_nn int primary key auto_increment,
ten_nn varchar(50)
);

create table dat_hang(
so_dh int primary key auto_increment,
ma_nd int,
ma_hang int,
ngay_dat date,
so_luong int,
primary key(ma_nd ,ma_hang),
foreign key(ma_nd) references nguoi_dat(ma_nd),
foreign key(ma_hang) references hang(ma_hang)
);

create table giao(
so_pg int primary key auto_increment,
ma_nn int,
ma_ng int,
ma_ddg int,
ma_hang int,
ngay_giao date,
so_luong int,
don_gia double,
primary key(ma_nn,ma_ng,ma_ddg,ma_hang),
foreign key(ma_nn) references nguoi_nhan(ma_nn),
foreign key(ma_ng) references nguoi_giao(ma_ng),
foreign key(ma_ddg) references noi_giao(ma_ddg),
foreign key(ma_hang) references hang(ma_hang)
);
