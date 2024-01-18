create database demo;
use demo;

create table Product 
(
	Id int,
    ProductCode varchar(7),
    ProductName varchar(50),
    ProductPrice int,
    ProductAmount int,
    ProductDescription varchar(40),
    ProductStatus varchar(20)
);
INSERT INTO Product (Id, ProductCode, ProductName, ProductPrice, ProductAmount, ProductDescription, ProductStatus)
VALUES
(1, 'P001', 'Laptop', 1000, 50, 'High-performance laptop', 'In Stock'),
(2, 'P002', 'Smartphone', 500, 100, 'Latest smartphone model', 'In Stock'),
(3, 'P003', 'Headphones', 80, 200, 'Over-ear headphones', 'In Stock'),
(4, 'P004', 'Tablet', 300, 30, 'Portable tablet device', 'Out of Stock'),
(5, 'P005', 'Camera', 600, 40, 'Digital camera with advanced features', 'In Stock'),
(6, 'P006', 'Printer', 150, 25, 'Color laser printer', 'In Stock'),
(7, 'P007', 'Mouse', 20, 150, 'Wireless computer mouse', 'In Stock'),
(8, 'P008', 'Keyboard', 30, 100, 'Mechanical gaming keyboard', 'Out of Stock'),
(9, 'P009', 'External Hard Drive', 80, 50, '1TB external storage', 'In Stock'),
(10, 'P010', 'Monitor', 200, 20, '24-inch HD monitor', 'In Stock'),
(11, 'P011', 'Graphics Card', 400, 10, 'High-end graphics processing unit', 'Out of Stock'),
(12, 'P012', 'Router', 50, 30, 'Wireless internet router', 'In Stock'),
(13, 'P013', 'Speakers', 70, 50, 'Stereo speakers for computer', 'In Stock'),
(14, 'P014', 'Webcam', 40, 40, 'HD webcam for video conferencing', 'In Stock'),
(15, 'P015', 'SSD', 120, 15, 'Fast solid-state drive', 'In Stock');
INSERT INTO Product (Id, ProductCode, ProductName, ProductPrice, ProductAmount, ProductDescription, ProductStatus)
VALUES
(16, 'P016', 'Smartwatch', 120, 50, 'Fitness tracking smartwatch', 'In Stock'),
(17, 'P017', 'Printer Ink', 15, 80, 'Black ink cartridge', 'In Stock'),
(18, 'P018', 'Gaming Console', 300, 20, 'Latest gaming console', 'Out of Stock'),
(19, 'P019', 'Wireless Earbuds', 50, 120, 'Bluetooth earbuds', 'In Stock'),
(20, 'P020', 'Smart TV', 700, 15, '4K Ultra HD Smart TV', 'In Stock'),
(21, 'P021', 'Digital Watch', 40, 100, 'Digital wristwatch', 'In Stock'),
(22, 'P022', 'USB Flash Drive', 10, 200, '32GB USB flash drive', 'In Stock'),
(23, 'P023', 'External DVD Drive', 25, 30, 'USB DVD/CD-ROM drive', 'Out of Stock'),
(24, 'P024', 'WiFi Extender', 30, 40, 'Wireless network range extender', 'In Stock'),
(25, 'P025', 'Desk Lamp', 15, 60, 'LED desk lamp', 'In Stock'),
(26, 'P026', 'Power Bank', 25, 70, 'Portable phone charger', 'In Stock'),
(27, 'P027', 'Bluetooth Speaker', 60, 25, 'Portable wireless speaker', 'In Stock'),
(28, 'P028', 'External SSD', 150, 10, 'High-speed external solid-state drive', 'In Stock'),
(29, 'P029', 'Cordless Phone', 40, 30, 'DECT cordless telephone', 'In Stock'),
(30, 'P030', 'GPS Navigator', 80, 15, 'Car GPS navigation system', 'In Stock'),
-- Add 15 more rows with unique data
(31, 'P031', 'Digital Camera', 400, 20, 'Professional DSLR camera', 'Out of Stock'),
(32, 'P032', 'Wireless Gaming Mouse', 50, 35, 'High-performance gaming mouse', 'In Stock'),
(33, 'P033', 'Compact Refrigerator', 120, 10, 'Mini fridge for personal use', 'In Stock'),
(34, 'P034', 'Smart Thermostat', 80, 15, 'WiFi-enabled home thermostat', 'In Stock'),
(35, 'P035', '3D Printer', 500, 5, 'Desktop 3D printer', 'Out of Stock'),
(36, 'P036', 'Bluetooth Ear Muffs', 30, 40, 'Wireless earmuffs with built-in speakers', 'In Stock'),
(37, 'P037', 'Solar Power Bank', 40, 25, 'Portable solar charger for devices', 'In Stock'),
(38, 'P038', 'Fitness Tracker', 60, 30, 'Health and fitness monitoring device', 'In Stock'),
(39, 'P039', 'External Webcam', 35, 25, 'HD webcam for computers', 'In Stock'),
(40, 'P040', 'Portable Scanner', 50, 15, 'Handheld document scanner', 'Out of Stock');


create unique index index_ProductCode on Product(ProductCode);
create index index_Composite on Product(productName,productPrice);

drop index index_ProductCode on Product;
drop index index_Composite on Product;

explain select *
from Product 
where ProductCode = 'P001';

explain select *
from Product
where productName = 'Fitness Tracker' and productPrice = 60;

-- tạo View 
create view View_Product as
select productCode, productName, productPrice, productStatus
from Product;
SET SQL_SAFE_UPDATES = 0;

select * from View_Product;
-- tiến hành sửa đổi view
update View_Product
set ProductCode = 'P047'
where ProductCode = 'P040';
-- tiến hành xóa view
delete 
from View_Product
where ProductCode = 'P047';

-- Bước 5
--Tạo store procedure lấy tất cả thông tin của tất cả các sản phẩm trong bảng product
DELIMITER //
create procedure Select_ALL()
begin
	select * 
    from Product;
end //
DELIMITER ;
call Select_ALL

DELIMITER //

-- thêm 1 sản phẩm vào
CREATE PROCEDURE AddProduct(
    IN p_ProductCode VARCHAR(7),
    IN p_ProductName VARCHAR(50),
    IN p_ProductPrice INT,
    IN p_ProductAmount INT,
    IN p_ProductDescription VARCHAR(40),
    IN p_ProductStatus VARCHAR(20)
)
BEGIN
    INSERT INTO Product (
        ProductCode, ProductName, ProductPrice,
        ProductAmount, ProductDescription, ProductStatus
    ) VALUES (
        p_ProductCode, p_ProductName, p_ProductPrice,
        p_ProductAmount, p_ProductDescription, p_ProductStatus
    );
END //

DELIMITER ;

DELIMITER //

-- cập nhật theo id
CREATE PROCEDURE UpdateProduct(
    IN p_ProductID INT,
    IN p_ProductCode VARCHAR(7),
    IN p_ProductName VARCHAR(50),
    IN p_ProductPrice INT,
    IN p_ProductAmount INT,
    IN p_ProductDescription VARCHAR(40),
    IN p_ProductStatus VARCHAR(20)
)
BEGIN
    UPDATE Product
    SET
        ProductCode = p_ProductCode,
        ProductName = p_ProductName,
        ProductPrice = p_ProductPrice,
        ProductAmount = p_ProductAmount,
        ProductDescription = p_ProductDescription,
        ProductStatus = p_ProductStatus
    WHERE Id = p_ProductID;
END //

DELIMITER ;

-- xóa thông tin theo id
DELIMITER //

CREATE PROCEDURE DeleteProduct(IN p_ProductID INT)
BEGIN
    DELETE FROM Product WHERE Id = p_ProductID;
END //

DELIMITER ;


