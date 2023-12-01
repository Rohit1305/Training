create database bankdb;
use bankdb;
 
create table user (
acc_no bigint primary key, 
user_name varchar(50) not null, 
email varchar(50) unique, 
pass varchar(50) not null, 
mob varchar(15) , 
balance decimal(10,2)
);

insert into user values(1001, "Shikhar Dhawan", 'shikhar@gmail.com',"shikhar@123", "8989898989", 50000);
insert into user values(1002, "Sachin Tendulkar", 'sachin@gmail.com',"sachin@123", "7878787878", 90000);

create table admin( 
id int primary key, 
admin_name varchar(50) not null,
email varchar(30) unique, 
pass varchar(20) not null,
mob varchar(15) 
);

desc admin;

insert into admin values(1, "Rohit Sabat", 'rohit@gmail.com',"rohit@123", "9999999999");
insert into admin values(2, "Umaid Shaikh", 'umaid@gmail.com',"umaid@123", "8888888888");
insert into admin values(3, "Amisha Yadav", 'amisha@gmail.com',"amisha@123", "7777777777");

 create table passbook (
 sr_no int auto_increment primary key,  
 acc_no bigint , 
 trans_date date, 
 trans_type varchar(20) , 
 amount decimal(10,2) , 
 balance decimal(10,2)
 );

 
 insert into passbook ( acc_no , trans_date , trans_type, amount ,balance) values(1001, "2023-10-23", "Credit", 1000, 7000);
 insert into passbook ( acc_no , trans_date , trans_type, amount ,balance) values(1002, "2023-10-23", "Credit", 1000, 10000);
