create database HangHoa;
use HangHoa;

create table PhieuXuat
(	
	SoPX int primary key,
    NgayXuat date
);

create table NhaCungCap
(
	MaNCC varchar(8) primary key,
    tenNCC varchar(40),
    DiaChi varchar(40)
);

create table PhieuNhap
(
	SoPN int primary key,
    NgayNhap date
);

create table LienLac
(
	SDT varchar(10),
    MaNCC varchar(8),
    primary key(SDT,MaNCC)
);

create table DonDatHang
(
	SoHD int primary key,
    ngayDH date,
    MaNCC varchar(7),
    foreign key (MaNCC) references NhaCungCap(MaNCC)
);

create table VatTu 
(
	MaVTU varchar(7) primary key,
    TenVTU varchar(30)
);

create table PhieuXuat_VatTu
(
	SoPX int primary key,
    MaVTU varchar(7),
    DGXuat int,
    SLXuat int,
    foreign key (SoPX) references PhieuXuat(SoPX),
    foreign key (MaVTU) references VatTu(maVTU)
);

create table NhaCungCap_LienLac
(
	SDT varchar(10),
    MaNCC varchar(8),
    primary key(SDT, MaNCC),
    foreign key (MaNCC) references NhaCungCap(MaNCC)
);

create table VatTu_PhieuNhap
(
	SoPN int,
    MaVTU varchar(7),
    primary key(SoPN,MaVTU),
    DGNhap int,
    SLNhap int,
    foreign key (SoPN) references PhieuNhap(SoPN),
    foreign key(MaVTU) references VatTu(MaVTU)
);


-- RÀNG BUỘC CHO CƠ SỞ DỮ LIỆU 
alter table PhieuXuat_VatTu
add constraint checkSoLuong check (DGXuat >= 0 and  SLXuat >= 0);

alter table VatTu_PhieuNhap
add constraint checkSoLuongNhap check (DGNhap >= 0 and SLNhap >=0)











