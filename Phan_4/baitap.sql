create database if not exists Students;
use Students;

create table Class
(
	IdClass varchar(7)primary key,
    StartTime date,
    NameClass varchar(30)
);

create table `Subject`
(
	IdSubject varchar(7) primary key,  
    Credit int,
    NameSubject varchar(30),
    StartTime date,
    IdClass varchar(7),
    foreign key (IdClass) references Class(IdClass)
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
    MediumScore float,
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
 
create table Subject_Student 
(
	IdSubject varchar(7),
    IdStudent varchar(30),
    primary key(IdSubject,IdStudent),
    foreign key (IdSubject) references `Subject`(IdSubject),
    foreign key (IdStudent) references Student(IdStudent)
);

INSERT INTO Class (IdClass, StartTime, NameClass)
VALUES
('C1', '2024-01-09', 'Math Class'),
('C2', '2024-01-10', 'Science Class'),
('C3', '2024-01-11', 'History Class'),
('C4', '2024-01-12', 'English Class'),
('C5', '2024-01-13', 'Physics Class');

-- Insert into Subject table
INSERT INTO `Subject` (IdSubject, Credit, NameSubject, StartTime, IdClass)
VALUES
('S1', 3, 'Algebra', '2024-01-09', 'C1'),
('S2', 4, 'Physics 101', '2024-01-10', 'C2'),
('S3', 3, 'World History', '2024-01-11', 'C3'),
('S4', 4, 'English Literature', '2024-01-12', 'C4'),
('S5', 3, 'Chemistry Basics', '2024-01-13', 'C5');

-- Insert into Student table
INSERT INTO Student (IdStudent, StudentName, SubName, Mark, Cccd, PhoneNumber, Address, IdClass, credit,MediumScore)
VALUES
('ST1', 'John Doe', 'Math', 85, 'CCCD001', '1234567890', '123 Main St', 'C1', 3,5),
('ST2', 'Jane Smith', 'Physics', 92, 'CCCD002', '9876543210', '456 Oak St', 'C2', 4,6),
('ST3', 'Bob Johnson', 'History', 78, 'CCCD003', '4567890123', '789 Pine St', 'C3', 3,7),
('ST4', 'Alice Brown', 'English', 95, 'CCCD004', '3210987654', '789 Elm St', 'C4', 4,8),
('ST5', 'Charlie Wilson', 'Chemistry', 88, 'CCCD005', '8765432109', '101 Cedar St', 'C5', 3,6);

-- Insert into Teacher table
INSERT INTO Teacher (IdTeacher, `Name`, Age, Country, IdClass)
VALUES
('T1', 'Mr. Anderson', 35, 'USA', 'C1'),
('T2', 'Mrs. Williams', 40, 'Canada', 'C2'),
('T3', 'Dr. Smith', 50, 'UK', 'C3'),
('T4', 'Ms. Davis', 28, 'Australia', 'C4'),
('T5', 'Prof. Johnson', 45, 'Germany', 'C5');

INSERT INTO Subject_Student (IdSubject, IdStudent)
VALUES
('S1', 'ST1'),
('S2', 'ST2'),
('S3', 'ST3'),
('S4', 'ST4'),
('S5', 'ST5');


-- câu 1: Hiển thị tất cả các thông tin môn học (bảng subject) có credit lớn nhất.
select  *
from `Subject`
where Credit = (select Max(Credit) from `Subject`);

-- câu 2: Hiển thị các thông tin môn học có điểm thi lớn nhất.
-- credit ở đây chính là điểm thi của học sinh tức là credit của học sinh

select *
from `Subject` s
where s.IdSubject in (select IdSubject from Subject_Student where IdStudent in (select IdStudent
from Student  
where Credit = (select Max(Credit) from Student)))

-- câu 3: Hiển thị các thông tin sinh viên và điểm trung bình của mỗi sinh viên, xếp hạng theo thứ tự điểm giảm dần
explain select *
from Student 
order by MediumScore desc	


create view View_Student as
select *, Mark
from Student
where Mark != 0 with check option

