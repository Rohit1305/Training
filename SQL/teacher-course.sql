-- ========================teacher table==============
create table teacher (
    id int auto_increment primary key,
    first_name varchar(50),
    last_name varchar(50),
    email varchar(100),
    department varchar(50),
    hire_date date
);

insert into teacher (first_name, last_name, email, department, hire_date)
values
    ('rohit', 'sabat', 'rohit@example.com', 'Mathematics', '2020-05-15'),
    ('Mary', 'Johnson', 'mary@gmail.com', 'Science', '2019-08-20'),
    ('Michael', 'Davis', 'davis@example.com', 'Art', '2021-09-05');


create table courses (
    course_id int auto_increment primary key,
    course_name varchar(100),
    start_date date,
    end_date date,
    duration int,
    teacher_id int,
    constraint fk_course_teacher
    foreign key (teacher_id) references teacher(id)
);

insert into courses (course_name, start_date, end_date, duration, teacher_id)
values
    ('Math 101', '2023-09-15', '2023-12-15', 90, 1),
    ('Science 202', '2023-10-05', '2024-01-10', 98, 2),
    ('Art 103', '2023-10-01', '2023-12-31', 92, 3);
    










