create database normalizations;
use normalizations;

-- ========================= 1NF Voilation ==========================

create table students_1NF_violation (
    student_id int primary key,
    student_name varchar(50),
    subjects varchar(50)
);

insert into students_1NF_violation (student_id, student_name, subjects) values
    (1, 'Rohit', 'Java, Python'),
    (2, 'Umaid', 'Python, JavaScript'),
    (3, 'Amisha', 'JavaScript, Angular');
    
-- ========================= 1NF Solution ==========================

create table students(
    student_id int primary key,
    student_name varchar(50)
);

insert into students(student_id, student_name) values
    (1, 'Rohit'),
    (2, 'Umaid'),
    (3, 'Amisha');
    
create table subjects(
    subject_id int primary key,
    subject_name varchar(50)
);

insert into subjects(subject_id, subject_name) values
    (1, 'Java'),
    (2, 'Python'),
    (3, 'Javascript'),
    (4, 'Angular');
    
-- ========================= 2NF Voilation ==========================

create table  student_subjects_2nf_violation (
    student_id int,
    students_name varchar(50),
    subject_id int,
    subjects_name varchar(50),
    score int,
    primary key (student_id, subject_id),
    foreign key (student_id) references students(student_id),
    foreign key (subject_id) references subjects(subject_id)
);

insert into student_subjects_2nf_violation (student_id, students_name, subject_id, subjects_name,score) values
    (1, 'Rohit', 1, 'Java', 85),
    (1, 'Rohit', 2, 'Python', 90),
    (2, 'Umaid', 1, 'Java', 75),
    (2, 'Umaid', 3, 'JavaScript', 80),
    (3, 'Amisha', 2, 'Python', 88),
	(3, 'Amisha', 3, 'JavaScript', 70);
    

-- ========================= 2 NF Solution ==========================
    
create table student_subject_2NF_Solution (
    student_id int,
    subject_id int,
    score int,
    constraint student_subject_2nf_ibfk_1 primary key (student_id, subject_id),
    foreign key (student_id) references students(student_id),
    foreign key (subject_id) references subjects(subject_id)
);

insert into student_subject_2NF_solution (student_id, subject_id, score) values
    (1, 1, 85),
    (1, 2, 90),
    (2, 1, 75),
    (2, 3, 80),
    (3, 2, 88);
    
select
    students.student_name as StudentName,
    subjects.subject_name as SubjectName,
    student_subject_2nf_solution.score as Score
from
    student_subject_2nf_solution
inner join students on student_subject_2nf_solution.student_id = students.student_id
inner join subjects on student_subject_2nf_solution.subject_id = subjects.subject_id;

    
-- ============================== 3NF Voilation ==========================

create table student_subject_3nf_violation (
    student_id int,
    student_name varchar(50),
    subject_id int,
    subject_name varchar(50),
    teacher_name varchar(50),
    score int,
    primary key (student_id, subject_id),
    foreign key (student_id) references students(student_id),
    foreign key (subject_id) references subjects(subject_id)
);

insert into student_subject_3nf_violation (student_id, student_name, subject_id, subject_name, teacher_name, score) values
    (1, 'Rohit', 1, 'Java', 'Reena', 85),
    (1, 'Rohit', 2, 'Python', 'Pooja', 90),
    (2, 'Umaid', 1, 'Java', 'Reena', 75),
    (2, 'Umaid', 3, 'Javascript', 'Smita', 80),
    (3, 'Amisha', 2, 'Python', 'Pooja', 88);


-- ============================== 3NF Solution ==========================

create table teachers (
    teacher_id int primary key,
    teacher_name varchar(50),
    subject_id int,
    foreign key (subject_id) references subjects(subject_id)
);

insert into teachers (teacher_id, teacher_name, subject_id) values
    (1, 'Reena', 1),
    (2, 'Pooja', 2),
    (3, 'Smita', 3);

create table student_subject_3nf_solution (
    student_id int,
    subject_id int,
    score int,
    primary key (student_id, subject_id),
    foreign key (student_id) references students(student_id),
    foreign key (subject_id) references subjects(subject_id)
);

insert into student_subject_3nf_solution (student_id, subject_id, score) values
    (1, 1, 85),
    (1, 2, 90),
    (2, 1, 75),
    (2, 3, 80),
    (3, 2, 88);
    
select
    students.student_name as StudentName,
    subjects.subject_name as SubjectName,
    teachers.teacher_name as TeacherName,
    student_subject_3nf_solution.score as Score
from
    student_subject_3nf_solution
inner join students on student_subject_3nf_solution.student_id = students.student_id
inner join subjects on student_subject_3nf_solution.subject_id = subjects.subject_id
inner join teachers on subjects.subject_id = teachers.subject_id;

-- ====================================================================

create view student_subject_view as
select students.student_id, students.student_name, subjects.subject_id, subjects.subject_name
from students
join subjects on students.student_id = subjects.subject_id;



-- =======================insert=======================
delimiter //
create procedure insert_student(in student_id int, in student_name varchar(50))
begin
  insert into students(student_id, student_name) values (student_id, student_name);
end;
//
delimiter ;

delimiter //
create procedure insert_subject(in subject_id int, in subject_name varchar(50))
begin
  insert into subjects(subject_id, subject_name) values (subject_id, subject_name);
end;
//
delimiter ;


-- ===========Update ===================

delimiter //
create procedure update_student_name(in stud_id int, in new_name varchar(50))
begin
set sql_safe_updates=0;
  update students set student_name = new_name where student_id = stud_id;
  set sql_safe_updates=1;
end;
//
delimiter ;


delimiter //
create procedure update_subject_name(in subj_id int, in new_name varchar(50))
begin
set sql_safe_updates=0;
  update subjects set subject_name = new_name where subject_id = subj_id;
  set sql_safe_updates=1;
end;
//
delimiter ;

-- ======================delete====================

delimiter //
create procedure delete_student(in student_id int)
begin
  delete from students where student_id = student_id;
end;
//
delimiter ;

delimiter //
create procedure delete_subject(in subject_id int)
begin
  delete from subjects where subject_id = subject_id;
end;
//
delimiter ;

-- =============================READ=======================
select students.student_id, students.student_name, subjects.subject_id, subjects.subject_name
from students
join subjects on students.student_id = subjects.subject_id;

-- =================================================================================

call insert_student(5,'Amit');
call insert_subject(5,'React');

call update_student_name(3, 'Amisha');
call update_subject_name(5, 'React JS');

call delete_student(5);
call delete_subject(5);

select student_id, student_name from students;
select subject_id, subject_name from subjects;

 



