create database if not exists Students;
use sinhVien;

create table Student
(
	IdStudent varchar(30),
    Name nvarchar(50),
    Cccd varchar(10) unique,
    PhoneNumber varchar(10),
    Address varchar(50)
);

create table Class
(
	IdClass nvarchar(7),
    NameClass nvarchar(30)
);

create table Teacher 
(
	IdTeacher nvarchar(50),
    Name nvarchar(45),
    Age int,
    Country nvarchar(40)
)