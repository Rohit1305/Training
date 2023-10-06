CREATE DATABASE ORGANIZATION;

USE ORGANIZATION;

CREATE TABLE DEPT (
 DEPTNO              integer NOT NULL,
 DNAME               varchar(14),
 LOC                 varchar(13),
 CONSTRAINT DEPT_PRIMARY_KEY PRIMARY KEY (DEPTNO));
 
 CREATE TABLE EMP (
 EMPNO               integer NOT NULL,
 ENAME               varchar(10),
 JOB                 varchar(9),
 MGR                 integer,
 HIREDATE            DATEtime,
 SAL                 DECIMAL(10,2),
 COMM                DECIMAL(10,2),
 DEPTNO              integer NOT NULL,
 CONSTRAINT EMP_FOREIGN_KEY FOREIGN KEY (DEPTNO) REFERENCES DEPT (DEPTNO),
 CONSTRAINT EMP_PRIMARY_KEY PRIMARY KEY (EMPNO));
 
INSERT INTO DEPT VALUES (10,'ACCOUNTING','NEW YORK');
INSERT INTO DEPT VALUES (20,'RESEARCH','DALLAS');
INSERT INTO DEPT VALUES (30,'SALES','CHICAGO');
INSERT INTO DEPT VALUES (40,'OPERATIONS','BOSTON');

INSERT INTO EMP VALUES (7839,'KING','PRESIDENT',NULL,'1981-11-17',5000,NULL,10);
INSERT INTO EMP VALUES (7698,'BLAKE','MANAGER',7839,'1981-05-1',2850,NULL,30);
INSERT INTO EMP VALUES (7782,'CLARK','MANAGER',7839,'1981-06-9',2450,NULL,10);
INSERT INTO EMP VALUES (7566,'JONES','MANAGER',7839,'1981-4-2',2975,NULL,20);
INSERT INTO EMP VALUES (7654,'MARTIN','SALESMAN',7698,'1981-9-28',1250,1400,30);
INSERT INTO EMP VALUES (7499,'ALLEN','SALESMAN',7698,'1981-2-20',1600,300,30);
INSERT INTO EMP VALUES (7844,'TURNER','SALESMAN',7698,'1981-9-8',1500,0,30);
INSERT INTO EMP VALUES (7900,'JAMES','CLERK',7698,'1981-12-3',950,NULL,30);
INSERT INTO EMP VALUES (7521,'WARD','SALESMAN',7698,'1981-2-22',1250,500,30);
INSERT INTO EMP VALUES (7902,'FORD','ANALYST',7566,'1981-12-3',3000,NULL,20);
INSERT INTO EMP VALUES (7369,'SMITH','CLERK',7902,'1980-12-17',800,NULL,20);
INSERT INTO EMP VALUES (7788,'SCOTT','ANALYST',7566,'1982-12-09',3000,NULL,20);
INSERT INTO EMP VALUES (7876,'ADAMS','CLERK',7788,'1983-1-12',1100,NULL,20);
INSERT INTO EMP VALUES (7934,'MILLER','CLERK',7782,'1982-1-23',1300,NULL,10);

 
CREATE TABLE REGIONS
( REGION_ID INTEGER NOT NULL,
REGION_NAME VARCHAR(20),
PRIMARY KEY(REGION_ID)
);

CREATE TABLE COUNTRIES 
    ( COUNTRY_ID      CHAR(2)
    , COUNTRY_NAME    VARCHAR(40) 
    , REGION_ID       INTEGER 
    , PRIMARY KEY (COUNTRY_ID),
	  CONSTRAINT COUNTR_REG_FK FOREIGN KEY (REGION_ID) REFERENCES REGIONS(REGION_ID)
    ) ;
    
CREATE TABLE LOCATIONS
    ( LOCATION_ID    INTEGER not null
    , STREET_ADDRESS VARCHAR(40)
    , POSTAL_CODE    VARCHAR(12)
    , CITY       VARCHAR(30) NOT NULL
    , STATE_PROVINCE VARCHAR(25)
    , COUNTRY_ID     CHAR(2),
    PRIMARY KEY (LOCATION_ID),
    FOREIGN KEY (COUNTRY_ID) REFERENCES COUNTRIES(COUNTRY_ID)
    ) ;

INSERT INTO regions VALUES( 1, 'Europe');
INSERT INTO regions VALUES( 2, 'Americas');
INSERT INTO regions VALUES( 3, 'Asia');
INSERT INTO regions VALUES( 4, 'Middle East and Asia');

INSERT INTO countries VALUES( 'IT', 'Italy', 1);
INSERT INTO countries VALUES( 'JP', 'Japan', 3);
INSERT INTO countries VALUES( 'US', 'USA', 2);
INSERT INTO countries VALUES( 'CA', 'Canada', 2);
INSERT INTO countries VALUES( 'CN', 'China', 3);
INSERT INTO countries VALUES( 'IN', 'India', 3);
INSERT INTO countries VALUES( 'AU', 'Australia', 3);
INSERT INTO countries VALUES( 'ZW', 'Zimbabwe',4);



INSERT INTO countries VALUES( 'SG', 'Singapore', 3);
INSERT INTO countries VALUES( 'UK', 'United Kingdom', 1);
INSERT INTO countries VALUES( 'FR', 'France', 1);
INSERT INTO countries VALUES( 'DE', 'Germany', 1);
INSERT INTO countries VALUES( 'ZM', 'Zambia', 4);
INSERT INTO countries VALUES( 'EG', 'Egypt', 4);
INSERT INTO countries VALUES( 'BR', 'Brazil', 2);
INSERT INTO countries VALUES( 'CH', 'Switzerland', 1);


INSERT INTO countries VALUES( 'NL', 'Netherlands', 1);
INSERT INTO countries VALUES( 'MX', 'Mexico', 2);
INSERT INTO countries VALUES( 'KW', 'Kuwait', 4);
INSERT INTO countries VALUES( 'IL', 'Israel', 4);
INSERT INTO countries VALUES( 'DK', 'Denmark', 1);
INSERT INTO countries VALUES( 'HK', 'HongKong', 3);
INSERT INTO countries VALUES( 'NG', 'Nigeria', 4);
INSERT INTO countries VALUES( 'AR', 'Argentina', 2);
INSERT INTO countries VALUES( 'BE', 'Belgium', 1);

INSERT INTO locations VALUES( 1000, '1297 Via Cola di Rie', '00989', 'Roma', NULL, 'IT');
INSERT INTO locations VALUES( 1100, '93091 Calle della Testa', '10934', 'Venice', NULL, 'IT');
INSERT INTO locations VALUES( 1200, '2017 Shinjuku-ku', '1689', 'Tokyo', 'Tokyo Prefecture', 'JP');
INSERT INTO locations VALUES( 1300, '9450 Kamiya-cho', '6823', 'Hiroshima', NULL, 'JP');
INSERT INTO locations VALUES( 1400, '2014 Jabberwocky Rd', '26192', 'Southlake', 'Texas', 'US');
INSERT INTO locations VALUES( 1500, '2011 Interiors Blvd', '99236', 'South San Francisco', 'California', 'US');
INSERT INTO locations VALUES( 1600, '2007 Zagora St', '50090', 'South Brunswick', 'New Jersey', 'US');
INSERT INTO locations VALUES( 1700, '2004 Charade Rd', '98199', 'Seattle', 'Washington', 'US');
INSERT INTO locations VALUES( 1800, '147 Spadina Ave', 'M5V 2L7', 'Toronto', 'Ontario', 'CA');
INSERT INTO locations VALUES( 1900, '6092 Boxwood St', 'YSW 9T2', 'Whitehorse', 'Yukon', 'CA');

-- =====================================================================================

-- 1)QUERY 0 = show details of all employee
select * from emp;

-- 2)QUERY 1 = Display all employee names in ascending order
select ename from emp order by ename asc;

-- 3)QUERY 2 = Display all employees(all columns) in department 20 and 30
select * from emp where deptno in (20, 30);

-- 4)QUERY 3 = Display all the employees who are managers
select * from emp where job= 'manager';

-- 5)QUERY 4 = Display all the employees whose salary is between 2000 and 5000
select * from emp where sal>=2000 and sal<=5000;

-- 6)QUERY 5 = Display all the employees whose commission is null
select * from emp where comm is null;

-- 7)QUERY 6 = Display emp_name,salary,comission,ctc(calculated column)
select ename,sal,comm, (sal+ ifnull(comm,0)) as ctc from emp;

-- 8)QUERY 7 = Display hire_date, current_date, tenure(calculated col) of the empl
select hiredate,current_timestamp(),datediff(current_timestamp,hiredate)/365 as tenture from emp;

-- 9)QUERY 8 = Display all the employees whose name starts with s
select * from emp where ename like 's%';

-- 10)QUERY 9 = Display unique department numbers from the employee table
select distinct deptno from emp;

-- 11)QUERY 10 = Display emp_name and job in lower case
select lower(ename), lower(job) from emp;
 
-- 12)QUERY 11 = Select top 3 salary earning employee
 select * from emp
 order by sal desc
 limit 3;
 
-- 13)QUERY 12 = Select clerks and Managers in department 10
select * from emp 
where deptno=10
and (job='clerk' or job='manager');

-- 14)QUERY 13 = Display all clerks in asscending order of the department number 
select * from emp 
where job ='clerk'
order by deptno asc;

-- 15)QUERY 14 = Display All employees in the same dept of 'SCOTT' 
-- subqueries 
select * from emp 
where deptno =(select deptno from emp where ename ='SCOTT');
-- selfjoin
select * from emp as e1
join emp e2 on e1.deptno = e2.deptno
where e2.ename ='SCOTT';

-- 16)QUERY 15 = Employees having same designation of SMITH
select * from emp as e1
join emp as e2 on e1.job = e2.job
where e2.ename ='SMITH' and e1.ename!='SMITH';

-- 15)QUERY 16 = Employee who are reproting under KING
select * from emp 
where mgr=(select empno from emp where ename ='KING');

-- 15)QUERY 17 =  Employees who have same salary of BLAKE
update emp
set sal = 1500
where empno=7698;

select * from emp as e1
join emp e2 on e1.sal = e2.sal
where e2.ename ='BLAKE' and e1.ename!='BLAKE';

-- 15)QUERY 18 = Display departmentwise number of employees
select deptno , count(*) as no_of_emp from emp
group by deptno
order by deptno;

-- 15)QUERY 19 = Display jobwise number of employees
select job , count(*) as no_of_emp from emp
group by job
order by job;

-- 15)QUERY 20 = Display deptwise jobwise number of employees
select deptno,job , count(*) as no_of_emp from emp
group by deptno,job
order by deptno,job;

-- 15)QUERY 21 = Display deptwise  employees greater than  3 
select deptno , count(*) as no_of_emp from emp
group by deptno
order by deptno
limit 3;

-- 15)QUERY 22 =Display designation wise employees count greater than 3 
select job , count(*) as no_of_emp from emp
group by job
order by job
limit 3;

-- 15)QUERY 23 =Display Employee name,deptname and location

select ename,dname,city 
from emp e
join dept d on e.deptno = d.deptno
join locations l on d.loc = l.location_id;

-- 15)QUERY 24 = display all deptnames and corresponding employees if ANY
 
select dname,ename
from dept d
left join emp e on d.deptno = e.deptno
order by d.deptno, e.empno;

-- 15)QUERY 25 = dipslay all deptnames where there are no employees

select dname 
from dept d
left join emp e on d.deptno = e.deptno
where e.empno is null;



