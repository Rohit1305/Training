create database student_db;
use  student_db;

create table student (
    id int auto_increment primary key,
    first_name varchar(50),
    last_name varchar(50),
    email varchar(50)
);

insert into student (first_name,last_name,email) values
    ('rohit','sharma','rohit@gmail.com'),
    ('virat','kohli','virat@gmail.com'),
    ('sachin','tendulkar','sachin@gmail.com');
    
    delete from student 

    
    
