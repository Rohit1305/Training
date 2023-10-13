create database normalization;

use normalization;

-- ========================= 1NF Voilation ==========================
-- Table with 1NF Violation
create table students_1NF_violation (
    student_id int primary key,
    student_name varchar(50),
    subjects varchar(50)
);

-- Inserting Data with Violation
insert into students_1NF_violation (student_id, student_name, subjects) values
    (1, 'Rohit', 'Java, Python'),
    (2, 'Umaid', 'Python, JavaScript'),
    (3, 'Amisha', 'JavaScript, Angular');
    
-- ========================= 1NF Solution ==========================

create table students_1NF_Solution(
    student_id int primary key,
    student_name varchar(50)
);

insert into students_1NF_Solution (student_id, student_name) values
    (1, 'Rohit'),
    (2, 'Umaid'),
    (3, 'Amisha');
    
create table subjects_1NF_Solution (
    subject_id int primary key,
    subject_name varchar(50)
);

insert into subjects_1NF_Solution (subject_id, subject_name) values
    (1, 'Java'),
    (2, 'Python'),
    (3, 'Javascript'),
    (4, 'Angular');


-- ========================= 2NF Voilation ==========================

create table students_2NF_Voilation(
    student_id int primary key,
    student_name varchar(50)
);

insert into students_2NF_Voilation (student_id, student_name) values
    (1, 'Rohit'),
    (2, 'Umaid'),
    (3, 'Amisha');
    
create table subjects_2NF_Voilation (
    subject_id int primary key,
    subject_name varchar(50)
);

insert into subjects_2NF_Voilation (subject_id, subject_name) values
    (1, 'Java'),
    (2, 'Python'),
    (3, 'Javascript'),
    (4, 'Angular');


create table  student_subjects_2nf_violation (
    student_id int,
    students_name varchar(50),
    subject_id int,
    subjects_name varchar(50),
    score int,
    primary key (student_id, subject_id),
    foreign key (student_id) references students_2NF_Voilation(student_id),
    foreign key (subject_id) references subjects_2NF_Voilation(subject_id)
);

insert into student_subjects_2nf_violation (student_id, students_name, subject_id, subjects_name,score) values
    (1, 'Rohit', 1, 'Java', 85),
    (1, 'Rohit', 2, 'Python', 90),
    (2, 'Umaid', 1, 'Java', 75),
    (2, 'Umaid', 3, 'JavaScript', 80),
    (3, 'Amisha', 2, 'Python', 88),
	(3, 'Amisha', 3, 'JavaScript', 70);
    

-- ========================= 2 NF Solution ==========================

create table students_2NF_Solution(
    student_id int primary key,
    student_name varchar(50)
);

insert into students_2NF_Solution (student_id, student_name) values
    (1, 'Rohit'),
    (2, 'Umaid'),
    (3, 'Amisha');
    
create table subjects_2NF_Solution (
    subject_id int primary key,
    subject_name varchar(50)
);

insert into subjects_2NF_Solution (subject_id, subject_name) values
    (1, 'Java'),
    (2, 'Python'),
    (3, 'Javascript'),
    (4, 'Angular');

CREATE TABLE student_subject_2NF (
    student_id int,
    subject_id int,
    score int,
    constraint student_subject_2nf_ibfk_1 primary key (student_id, subject_id),
    foreign key (student_id) references students_2NF_Solution(student_id),
    foreign key (subject_id) references subjects_2NF_Solution(subject_id)
);

insert into student_subject_2NF (student_id, subject_id, score) values
    (1, 1, 85),
    (1, 2, 90),
    (2, 1, 75),
    (2, 3, 80),
    (3, 2, 88);
    
-- ============================== 3NF Voilation ==========================

create table students_3nf (
    student_id int primary key,
    student_name varchar(50)
);

insert into students_3nf (student_id, student_name) values
    (1, 'Rohit'),
    (2, 'Umaid'),
    (3, 'Amisha');

create table subjects_3nf (
    subject_id int primary key,
    subject_name varchar(50)
);

insert into subjects_3nf (subject_id, subject_name) values
    (1, 'Java'),
    (2, 'Python'),
    (3, 'Javascript'),
    (4, 'Angular');

create table student_subject_3nf_violation (
    student_id int,
    student_name varchar(50),
    subject_id int,
    subject_name varchar(50),
    teacher_name varchar(50),
    score int,
    primary key (student_id, subject_id),
    foreign key (student_id) references students_3nf(student_id),
    foreign key (subject_id) references subjects_3nf(subject_id)
);

insert into student_subject_3nf_violation (student_id, student_name, subject_id, subject_name, teacher_name, score) values
    (1, 'Rohit', 1, 'Java', 'Reena', 85),
    (1, 'Rohit', 2, 'Python', 'Pooja', 90),
    (2, 'Umaid', 1, 'Java', 'Reena', 75),
    (2, 'Umaid', 3, 'Javascript', 'Smita', 80),
    (3, 'Amisha', 2, 'Python', 'Pooja', 88);
    
    
    
    
    
    
    
    

