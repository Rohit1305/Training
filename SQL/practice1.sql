create database school;
use school;

create table student (
    id INT AUTO_INCREMENT PRIMARY KEY,    
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,    
    email VARCHAR(100) UNIQUE NOT NULL,
    phone_number VARCHAR(15));
    
INSERT INTO student (first_name, last_name, email, phone_number) VALUES
    ('Rohit', 'Sabat', 'rohit@gmail.com', '9999999999'),    
    ('Rahul', 'Smith', 'rahul@rediffmail.com', '8888888888'),
    ('Virat', 'kohli', 'virat@gmail.com', '77777777777');
    
-- ==========================add city==================
ALTER TABLE student
add city varchar(50);

UPDATE student
SET city = 'Mumbai'
WHERE id = 1;

UPDATE student
SET city = 'punjab'
WHERE id = 2;

UPDATE student
SET city = 'bangalore'
WHERE id = 3;

-- =====================add date_of_birth=========================
ALTER TABLE student
ADD date_of_birth DATE;

UPDATE student
SET date_of_birth = '1995-05-15'
WHERE id = 1;

UPDATE student
SET date_of_birth = '1990-08-25'
WHERE id = 2;

UPDATE student
SET date_of_birth = '1988-11-05'
WHERE id = 3;
-- ======================date of birth before 1990=================
select * from student 
where date_of_birth < '1990-09-25';
-- =======================date of birth between 1992-1998====================
select * from student 
where  date_of_birth between '1992-01-01' and '1998-12-31';



-- ===========-----------LAPTOP----------==============

CREATE TABLE laptop (
    id INT AUTO_INCREMENT PRIMARY KEY,
    brand VARCHAR(50) NOT NULL,
    dateofpurchase DATE NOT NULL,
    details TEXT
);

INSERT INTO laptop (brand, dateofpurchase, details)
VALUES
    ('HP', '2022-09-27', '8GB RAM, Intel Core i5 processor'),
    ('Dell', '2019-09-26', '16GB RAM, AMD Ryzen 7 processor'),
    ('Lenovo', '2023-09-25', '12GB RAM, Intel Core i7 processor');
    
ALTER TABLE laptop
ADD student_id INT,
ADD FOREIGN KEY (student_id) REFERENCES student(id);

alter table laptop add unique (student_id);

update laptop 
set student_id ='1'
where id =1 ;

update laptop 
set student_id ='2'
where id =2 ;

update laptop 
set student_id ='3'
where id =3;

select first_name,laptop.id, laptop.brand
from laptop inner join student 
where laptop.student_id = student.id



