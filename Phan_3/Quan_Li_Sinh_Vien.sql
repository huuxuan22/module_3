create database if not exists Students;
use Students;

 
create table Class
(
	IdClass varchar(7)primary key,
    StartTime date,
    NameClass varchar(30)
);

create table Student
(
	IdStudent varchar(30) primary key,
    StudentName varchar(50),
    SubName varchar(50),
    Mark int,
    Cccd varchar(10) unique,
    PhoneNumber varchar(10),
    Address varchar(50),
    IdClass varchar(7),
    credit int,
    foreign key (IdClass) references Class(IdClass)
);

create table Teacher 
(
	IdTeacher varchar(50)primary key,
    Name varchar(45),
    Age int,
    Country varchar(40),
    IdClass varchar(7),
    foreign key (IdClass) references Class(IdClass)
);


INSERT INTO Class (IdClass, StartTime, NameClass)
VALUES
('C001', '2024-01-01', 'Class A'),
('C002', '2024-01-02', 'Class B'),
('C003', '2024-01-03', 'Class C'),
('C004', '2024-01-04', 'Class D'),
('C005', '2024-01-05', 'Class E');

-- Insert vào bảng Student
INSERT INTO Student (IdStudent, StudentName, SubName, Mark, Cccd, PhoneNumber, Address, IdClass, credit)
VALUES
('S001', 'John Doe', 'Math', 85, '1234567890', '0123456789', '123 Main St', 'C001', 150),
('S002', 'Jane Smith', 'English', 75, '0987654321', '9876543210', '456 Oak St', 'C001', 120),
('S003', 'Bob Johnson', 'Science', 92, '1122334455', '0345678901', '789 Pine St', 'C002', 180),
('S004', 'Alice Brown', 'History', 88, '9876543210', '0765432109', '321 Elm St', 'C002', 200),
('S005', 'David Lee', 'Math', 78, '1111222233', '0555555555', '555 Maple St', 'C003', 160);
-- Insert vào bảng Teacher
INSERT INTO Teacher (IdTeacher, Name, Age, Country, IdClass)
VALUES
('T001', 'Mr. Smith', 35, 'USA', 'C001'),
('T002', 'Mrs. Johnson', 40, 'Canada', 'C001'),
('T003', 'Miss White', 28, 'UK', 'C002'),
('T004', 'Mr. Brown', 45, 'Australia', 'C002'),
('T005', 'Mrs. Lee', 32, 'Germany', 'C003');

-- câu 1: Hiển thị tất cả các sinh viên có tên bắt đầu bảng ký tự ‘h’
select *
from Student s 
where SUBSTRING_INDEX(StudentName, ' ',1) = 'h';
-- câu 2: Hiển thị các thông tin lớp học có thời gian bắt đầu vào tháng 12.
select *
from Class
where year(StartTime) = 12;
-- câu 3: Hiển thị tất cả các thông tin môn học có credit trong khoảng từ 3-5.
select *
from Student
where credit between 3 and 5;
SET SQL_SAFE_UPDATES = 0;
-- câu 4: Thay đổi mã lớp(ClassID) của sinh viên có tên ‘Hung’ là 2.
UPDATE Student
SET IdClass = 2
WHERE StudentName = 'Hung';
-- câu 5: 	Hiển thị các thông tin: StudentName, SubName, Mark. Dữ liệu sắp xếp theo điểm thi (mark) giảm dần. nếu trùng sắp theo tên tăng dần.
select StudentName,SubName,Mark
from Student 
order by mark desc, StudentName asc


