create database Quan_Li_Ban_Hang;
use Quan_Li_Ban_Hang;

create table Customer 
(
	cID varchar(7)primary key,
    cName varchar(30),
    cAge int
);


create table `Order`
(
	oID varchar(7) primary key,
    cID varchar(7),
    oDate date,
    oTotalPrice int,
    foreign key(cID) references Customer(cID)
);
create table Product
(
	pID varchar(7) primary key,
    pName varchar(30),
    pPrice int
);

create table OrderDetail 
(
	oID varchar(7),
    pID varchar(7),
    odQTY int,
    primary key(oID,pID),
    foreign key (oID) references `Order`(oID),
    foreign key(pID) references Product(pID)
);

insert into Customer 
values 
	('1',N'Minh Quan',10),
    ('2',N'Ngoc Oanh',20),
    ('3',N'Hong Ha',50);


insert into `Order`
values 
	(1,1,'2006-3-21',null),
    (2,2,'2006-3-23',null),
    (3,1,'2006-3-16',null);
    
insert into Product
values 
	(1,N'May Giat',3),
	(2,N'Tu Lanh',5),
	(3,N'Dieu Hoa',7),
	(4,N'Quat',1),
	(5,N'Bep dien',2);
    
insert into OrderDetail
values
	(1,1,3),
	(1,3,7),
    (1,4,2),
    (2,1,1),
    (3,1,8),
    (2,5,4),
    (2,3,3);
    
    
-- câu 1: Hiển thị các thông tin  gồm oID, oDate, oPrice của tất cả các hóa đơn trong bảng Order
select oID, oDate,oTotalPrice
from `Order`;


-- câu 2: Hiển thị danh sách các khách hàng đã mua hàng, và danh sách sản phẩm được mua bởi các khách
select distinct c.cID,c.cName,c.cAge,p.*
from `Order` o
join Customer c on c.cID = o.cID
join OrderDetail od on od.oID = o.oID
join Product p on p.pID = od.pID;

-- câu 3: Hiển thị tên những khách hàng không mua bất kỳ một sản phẩm nào
select c.*
from Customer c
where c.cID not in (select cID  from `Order`);


-- câu 4: Hiển thị mã hóa đơn, ngày bán và giá tiền của từng hóa đơn (giá một hóa đơn được tính bằng tổng giá bán của từng loại
select distinct o.oID,o.oDate,sum(od.odQTY) as GiaCuaHoaDon
from `Order` o
join OrderDetail od on od.oID = o.oID
group by od.oID;
-- câu 5: mặt hàng xuất hiện trong hóa đơn. Giá bán của từng loại được tính = odQTY*pPrice)
select distinct o.oID,sum(p.pPrice*od.odQTY) as GiaCuaTungLoai -- cái này có phải là tính tổng tiền  teho từng mặt hàng
from `Order` o
join OrderDetail od on od.oID = o.oID
join Product p on p.pID = od.pID
group by od.oID;








