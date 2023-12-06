create database sinhvien;
use sinhvien;

create table if not exists loai(
  id bigint primary key auto_increment,
  ten varchar(255)
);

create table if not exists sinhvien(
  id bigint primary key auto_increment,
  masv varchar(255),
  ten varchar(255),
  loai_id bigint,
  foreign key(loai_id) references loai(id)  on delete cascade
);