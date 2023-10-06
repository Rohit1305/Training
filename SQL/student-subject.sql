
use  school;
create table students (
    student_id int auto_increment primary key,
    student_name varchar(50)
);

create table subj (
    course_id int auto_increment primary key,
    course_name varchar(50)
);


-- insert students
insert into students (student_name) values
    ('rohit'),
    ('virat'),
    ('sachin');

-- insert courses
insert into subj (course_name) values
    ('math'),
    ('history'),
    ('english');
    
create table student_subject (
    stud_id int,
    cour_id int,
    primary key (stud_id, cour_id),
    constraint fk_student_subj
    foreign key (stud_id) references students(student_id),
    foreign key (cour_id) references subj(course_id)
);

insert into student_subject (stud_id, cour_id) values
    (1, 1),  
    (1, 2); 

insert into student_subject (stud_id, cour_id) values
    (2, 2),  
    (2, 3); 

insert into student_subject (stud_id, cour_id) values
    (3, 1),  
    (3, 3);

Select s.student_id, s.student_name, sub.course_name
from students as s
join student_subject as ss on s.student_id = ss.stud_id
join subj as sub on ss.cour_id = sub.course_id;
