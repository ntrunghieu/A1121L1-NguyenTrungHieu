create database if not exists quan_ly_don_hang;
use quan_ly_don_hang;

create table nha_cc(
ma_ncc int auto_increment PRIMARY KEY,
ten_ncc varchar(100),
dia_chi varchar(300),
so_dt varchar(20) unique
);

create table so_dt(
so_dt varchar(20) PRIMARY KEY,
ma_ncc int,
foreign key (ma_ncc) references nha_cc(ma_ncc)
);

create table don_dh(
so_hd int auto_increment primary key,
ngay_dh date,
ma_ncc int,
foreign key (ma_ncc) references nha_cc(ma_ncc)
);

create table vat_tu(
ma_vtu int auto_increment primary key,
ten_vtu varchar(100)
);

create table don_dh_vat_tu(
so_hd int,
ma_vtu int,
primary key (so_hd,ma_vtu),
foreign key (so_hd) references don_dh(so_hd),
foreign key (ma_vtu) references vat_tu(ma_vtu)
);

create table phieu_nhap(
so_pn int auto_increment primary key,
ngay_nhap date
);

create table vat_tu_phieu_nhap(
ma_vtu int,
so_pn int,
don_gia_nhap int,
so_luong_nhap int,
primary key (ma_vtu,so_pn),
foreign key (ma_vtu) references vat_tu(ma_vtu),
foreign key (so_pn) references phieu_nhap(so_pn)
);

create table phieu_xuat(
so_px int auto_increment primary key,
ngay_xuat date
);

create table vat_tu_tao_phieu_xuat(
ma_vtu int,
so_px int,
don_gia_xuat int,
so_luong_xuat int,
primary key (ma_vtu,so_px),
foreign key (ma_vtu) references vat_tu(ma_vtu),
foreign key (so_px) references phieu_xuat(so_px)
);