
create table student_course(
	stud_id int,
    cour_id int,
    primary key (stud_id, cour_id),
    constraint fk_student_course
    foreign key (stud_id) references student(id),
    foreign key (cour_id) references courses(course_id)
);

insert into student_course (stud_id, cour_id) values
    (1, 1),  
    (1, 2); 

insert into student_course (stud_id, cour_id) values
    (2, 2),  
    (2, 3); 

insert into student_course (stud_id, cour_id) values
    (3, 1),  
    (3, 3);

Select s.id, s.first_name, cor.course_name
from student as s
join student_course as ss on s.id = ss.stud_id
join courses as cor on ss.cour_id = cor.course_id;


INSERT INTO student (first_name, last_name, email, phone_number)
VALUES ('New', 'Student', 'newstudent@example.com', '1234567890');


SELECT s.id, s.first_name, c.course_name
FROM student s
LEFT OUTER JOIN student_course sc ON s.id = sc.stud_id
LEFT OUTER JOIN courses c ON sc.cour_id = c.course_id;
