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
    
CREATE TABLE employee(
    id int auto_increment primary key,
    name varchar(50) not null,
    email varchar(50) not null,
    password varchar(50) not null,
    dob date,
    gender enum('Male', 'Female', 'Other'),
    designation varchar(50)
);

insert into employee (name, email, password, dob, gender, designation)
values ('rohit', 'rohit@gmail.com', 'admin123', '2000-01-15', 'Male', 'Employee');


create table instructor (
    id int auto_increment primary key,
    name varchar(50),
    email varchar(50),
    doj varchar(50)
);

create table instructortechdetail (
    id int auto_increment primary key,
    youtube_url varchar(50),
    git_url varchar(50)
);

insert into instructor (name, email, doj) values
('Rohit', 'rohit@gmail.com', '2022-01-15'),
('Sachin', 'sachin@gmail.com', '2021-09-20'),
('Virat', 'virat@gmail.com', '2020-03-10');

insert into instructortechdetail (youtube_url, git_url) values
('youtube.com/Rohit', 'github.com/Rohit'),
('youtube.com/Sachin', 'github.com/Sachin'),
('youtube.com/virat', 'github.com/Virat');
    

    
