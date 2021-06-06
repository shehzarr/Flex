

-------------------------------------------------------------------------------------------------------------------------------------------------------------


create table student
(
id nvarchar(30) not null,
name nvarchar(30) not null,
lname nvarchar(30) not null,
password nvarchar (30) not null,
address nvarchar(30) not null,
phoneno nvarchar(30) not null,
fathername nvarchar(30) not null,
dob nvarchar(30) not null,
batch nvarchar(30) not null,
credithourattempted nvarchar(30) not null,
credithourobtained nvarchar(30) not null,
currentsemester nvarchar(30) not null,
primary key (id)
)
--select * from stored_feedback

INSERT INTO student VALUES ('1','Shehzar','Iftikhar','123','Bahria Town','0301','Iftikhar','23 oct 1998','17','67','50','5')
INSERT INTO student VALUES ('2','Danish','Ali','123','Iqbal Town','0301','Ali','10 oct 1998','17','67','50','5')
INSERT INTO student VALUES ('3','Hamza','Arshad','123','Iqbal Town','0301','Arshad','12 oct 1998','17','67','50','5')

INSERT INTO student VALUES ('4','Ibrahim','Ali','123','Iqbal Town','0301','Iftikhar','12 jan 1999','17','67','50','5')
INSERT INTO student VALUES ('5','Manzoor','Ali','123','Iqbal Town','0301','Iftikhar','12 jan 1999','19','67','50','5')
INSERT INTO student VALUES ('6','Bilal','Ali','123','Iqbal Town','0301','Iftikhar','12 jan 1999','19','67','50','5')
INSERT INTO student VALUES ('7','Hammad','Ali','123','Iqbal Town','0301','Iftikhar','12 jan 1999','19','67','50','5')
INSERT INTO student VALUES ('8','Neha','Ali','123','Iqbal Town','0301','Iftikhar','12 jan 1999','18','67','50','5')
INSERT INTO student VALUES ('9','Mujahid','Ali','123','Iqbal Town','0301','Iftikhar','12 jan 1999','18','67','50','5')
INSERT INTO student VALUES ('10','Shehzad','Ali','123','Iqbal Town','0301','Iftikhar','12 jan 1999','18','67','50','5')
INSERT INTO student VALUES ('11','Ahmad','Ali','123','Iqbal Town','0301','Iftikhar','12 jan 1999','16','67','50','5')
INSERT INTO student VALUES ('12','Imran','Ali','123','Iqbal Town','0301','Iftikhar','12 jan 1999','16','67','50','1')


-------------------------------------------------------------------------------------------------------------------------------------------------------------

select* from courses
create table stored_feedback
(

id int not null IDENTITY(1,1),
courseName nvarchar(30) not null,
courseSection nvarchar(30) not null,
studentId nvarchar(30) not null,
semester nvarchar(30) not null,
ques_no nvarchar(30) not null,
optionSelected nvarchar(30) not null,			

primary key(id)

)

-------------------------------------------------------------------------------------------------------------------------------------------------------------

create table attendance(
lecture_no int not null,
student_rollno nvarchar(30) not null,
lecture_date nvarchar(30) not null,
credit_hours nvarchar(3) not null,
course_name nvarchar(30) not null,
semester nvarchar(30) not null,
section nvarchar(2) not null,
istakenclass nvarchar(1) not null,

primary key(lecture_date,student_rollno,course_name),
foreign key(student_rollno) references student(id) on update cascade
)
--select * from attendance
--select * from evaluation
--drop table attendance


Insert into attendance values ('1','1','20 Oct 2019','1.5','MASSCOM','Fall 2019','A','P')
Insert into attendance values ('2','1','21 Oct 2019','1.5','MASSCOM','Fall 2019','A','P')
Insert into attendance values ('3','1','22 Oct 2019','1.5','MASSCOM','Fall 2019','A','A')

----------------------
Insert into attendance values ('5','1','23 Oct 2019','1.5','MASSCOM','Fall 2019','A','A')
Insert into attendance values ('6','1','24 Oct 2019','1.5','MASSCOM','Fall 2019','A','A')
Insert into attendance values ('7','1','25 Oct 2019','1.5','MASSCOM','Fall 2019','A','A')
Insert into attendance values ('8','1','26 Oct 2019','1.5','MASSCOM','Fall 2019','A','A')
Insert into attendance values ('9','1','27 Oct 2019','1.5','MASSCOM','Fall 2019','A','A')
Insert into attendance values ('10','1','28 Oct 2019','1.5','MASSCOM','Fall 2019','A','A')
Insert into attendance values ('11','1','29 Oct 2019','1.5','MASSCOM','Fall 2019','A','A')
Insert into attendance values ('12','1','30 Oct 2019','1.5','MASSCOM','Fall 2019','A','A')
Insert into attendance values ('13','1','31 Oct 2019','1.5','MASSCOM','Fall 2019','A','A')
Insert into attendance values ('14','1','32 Oct 2019','1.5','MASSCOM','Fall 2019','A','A')
Insert into attendance values ('15','1','33 Oct 2019','1.5','MASSCOM','Fall 2019','A','A')
Insert into attendance values ('16','1','34 Oct 2019','1.5','MASSCOM','Fall 2019','A','A')
----------------------

Insert into attendance values ('1','1','20 Oct 2019','1.5','AP','Fall 2019','A','P')
Insert into attendance values ('2','1','21 Oct 2019','1.5','AP','Fall 2019','A','P')
Insert into attendance values ('3','1','22 Oct 2019','1.5','AP','Fall 2019','A','A')

Insert into attendance values ('1','2','20 Oct 2019','1.5','AP','Fall 2019','A','P')
Insert into attendance values ('2','2','21 Oct 2019','1.5','AP','Fall 2019','A','A')
Insert into attendance values ('3','2','22 Oct 2019','1.5','AP','Fall 2019','A','A')

-------------------------------------------------------------------------------------------------------------------------------------------------------------


create table evaluation(

id int not null IDENTITY(1,1),

evaluation_type nvarchar(30) not null,
marks_obt nvarchar(5) not null,
marks_tot nvarchar(5) not null,
weightage nvarchar(5) not null,
student_rollno nvarchar(30) not null,
course_name nvarchar(30) not null,
section nvarchar(2) not null,
number nvarchar(30) not null, --type number

primary key(id),
foreign key(student_rollno) references student(id) on update cascade
)

insert into evaluation values ('Assignment1','8','10','2','1','AP','A','1')
insert into evaluation values ('Assignment2','7','10','2','1','AP','A','2')
insert into evaluation values ('Quiz1','10','10','2','1','AP','A','1')
insert into evaluation values ('Quiz2','9','10','2','1','AP','A','2')
insert into evaluation values ('Mid1','80','100','30','1','AP','A','1')
insert into evaluation values ('Final1','88','100','50','1','AP','A','1')


-------------------------------------------------------------------------------------------------------------------------------------------------------------





create table teacher
(
id nvarchar(30) not null,
name nvarchar(30) not null,
password nvarchar(30) not null,
primary key(id)

)


INSERT INTO teacher VALUES ('1','Amir Waali','123')
INSERT INTO teacher VALUES ('2','Amir Shafi','123')
INSERT INTO teacher VALUES ('3','Abeeda Akram','123')
INSERT INTO teacher VALUES ('4','Samin Iftikhar','123')
INSERT INTO teacher VALUES ('5','Saira Karim','123')
INSERT INTO teacher VALUES ('6','Omer Ali','123')
INSERT INTO teacher VALUES ('7','Umer Aftab','123')
INSERT INTO teacher VALUES ('8','Mughees Ahmed','123')
INSERT INTO teacher VALUES ('9','Asif Qureshi','123')
INSERT INTO teacher VALUES ('10','Mehmood Raza','123')


-------------------------------------------------------------------------------------------------------------------------------------------------------------


GO
create table courses (

id nvarchar(10),
name nvarchar(30),
instructorid nvarchar (30),
section nvarchar (10),
c_type nvarchar(10), --elective ya core
credithours nvarchar(3),
total_seats nvarchar(2),
semester nvarchar(30),
pre_req nvarchar(10),
semester_num nvarchar(2),
postreq nvarchar(10),
primary key (id,name,section,semester),
foreign key(instructorid) references teacher(id) on delete set null on update cascade,

)

Insert into courses values ('1','ITC','1','A','CORE',3,50,'Fall 2019','','5','2')
Insert into courses values ('1','ITC','1','B','CORE',3,50,'Fall 2019','','5','2')
Insert into courses values ('1','ITC','1','C','CORE',3,50,'Fall 2019','','5','2')

Insert into courses values ('1','ITC','1','d','CORE',3,50,'Fall 2019','','5','2')

Insert into courses values ('2','CP','4','D','CORE',3,50,'Fall 2019','1','5','3')



Insert into courses values ('2','CP','4','A','CORE',3,50,'Fall 2019','1','2','3')
Insert into courses values ('2','CP','4','B','CORE',3,50,'Fall 2019','1','2','3')
Insert into courses values ('2','CP','4','C','CORE',3,50,'Fall 2019','1','2','3')
Insert into courses values ('3','DATA STRUCTURES','5','A','CORE',3,50,'Fall 2019','2','3','')
Insert into courses values ('3','DATA STRUCTURES','5','B','CORE',3,50,'Fall 2019','2','3','')
Insert into courses values ('3','DATA STRUCTURES','5','C','CORE',3,50,'Fall 2019','2','3','')
Insert into courses values ('4','ASSEMBLY LANGUAGE','6','A','CORE',3,50,'Fall 2019','','4','')
Insert into courses values ('4','ASSEMBLY LANGUAGE','6','B','CORE',3,50,'Fall 2019','','4','')
Insert into courses values ('4','ASSEMBLY LANGUAGE','6','C','CORE',3,50,'Fall 2019','','4','')
Insert into courses values ('5','DISCRETE','1','A','CORE',3,50,'Fall 2019','','4','')
Insert into courses values ('5','DISCRETE','1','B','CORE',3,50,'Fall 2019','','4','')
Insert into courses values ('5','DISCRETE','1','C','CORE',3,50,'Fall 2019','','4','')
Insert into courses values ('6','AP','7','A','ELECTIVE',3,50,'Fall 2019','','5','')
Insert into courses values ('6','AP','7','B','ELECTIVE',3,50,'Fall 2019','','5','')
Insert into courses values ('12','SOCIO','9','A','ELECTIVE',3,50,'Fall 2019','','5','')
Insert into courses values ('7','DIP','10','A','ELECTIVE',3,50,'Fall 2019','','5','')
Insert into courses values ('7','DIP','10','B','ELECTIVE',3,50,'Fall 2019','','5','')
Insert into courses values ('8','SMD','8','A','ELECTIVE',3,50,'Fall 2019','','5','')

Insert into courses values ('9','PROB','8','A','CORE',4,50,'Fall 2019','','5','')
Insert into courses values ('10','MASSCOM','8','A','ELECTIVE',3,50,'Fall 2019','','5','')
Insert into courses values ('11','MPG','8','A','ELECTIVE',3,50,'Fall 2019','','5','')
select* from courses



-------------------------------------------------------------------------------------------------------------------------------------------------------------



create table registration(

courseid nvarchar(10) not null,
coursename nvarchar(30) not null,
section nvarchar(10) not null,
studentid nvarchar(30) not null,
grade nvarchar(2) not null,
semester nvarchar(30) not null,
instructorid nvarchar(30) not null,

primary key(courseid,studentid,semester),

foreign key(studentid) references student(id)  on update cascade,
foreign key(instructorid) references teacher(id) on update cascade
)



Insert into registration values ('6','AP','A','1','F','Fall 2019',1)
Insert into registration values ('9','PROB','A','1','I','Fall 2019',1)
Insert into registration values ('10','MASSCOM','A','1','I','Fall 2019',1)
Insert into registration values ('1','ITC','A','1','F','Fall 2019',1)


Insert into registration values ('6','AP','B','2','I','Fall 2019',1)
Insert into registration values ('7','DIP','B','2','I','Fall 2019',1)
Insert into registration values ('9','PROB','A','2','I','Fall 2019',1)
Insert into registration values ('11','MPG','A','2','I','Fall 2019',1)

Insert into registration values ('6','AP','A','3','I','Fall 2019',1)
Insert into registration values ('7','DIP','B','3','I','Fall 2019',1)
Insert into registration values ('10','MASSCOM','A','3','I','Fall 2019',1)
Insert into registration values ('11','MPG','A','3','I','Fall 2019',1)

Insert into registration values ('3','DATA STRUCTURES','B','10','I','Fall 2019',1)
Insert into registration values ('4','ASSEMBLY LANGUAGE','C','10','I','Fall 2019',1)
Insert into registration values ('5','DISCRETE','A','10','I','Fall 2019',1)
Insert into registration values ('10','MASSCOM','A','10','I','Fall 2019',1)
Insert into registration values ('11','MPG','A','10','I','Fall 2019',1)

Insert into registration values ('3','DATA STRUCTURES','A','11','I','Fall 2019',1)
Insert into registration values ('7','DIP','A','11','I','Fall 2019',1)
Insert into registration values ('10','MASSCOM','A','11','I','Fall 2019',1)
Insert into registration values ('11','MPG','A','11','I','Fall 2019',1)

Insert into registration values ('1','ITC','A','5','I','Fall 2019',1)
Insert into registration values ('2','CP','A','5','I','Fall 2019',1)
Insert into registration values ('3','DATA STRUCTURES','A','5','I','Fall 2019',1)
Insert into registration values ('4','ASSEMBLY LANGUAGE','A','5','I','Fall 2019',1)

Insert into registration values ('1','ITC','B','8','I','Fall 2019',1)
Insert into registration values ('2','CP','A','8','I','Fall 2019',1)
Insert into registration values ('3','DATA STRUCTURES','B','8','I','Fall 2019',1)
Insert into registration values ('4','ASSEMBLY LANGUAGE','A','8','I','Fall 2019',1)

-------------------------------------------------------------------------------------------------------------------------------------------------------------



create table admin
(
id nvarchar(30) not null,
name nvarchar(30) not null,
password nvarchar (30) not null,
primary key (id)
)


Insert into admin values ('1','Saif Ullah','123')
Insert into admin values ('2','Aftab','123')



-------------------------------------------------------------------------------------------------------------------------------------------------------------


create table transcript
(

studentid nvarchar(30) not null,
coursename nvarchar(30) not null,
grade nvarchar(30) not null,
semester nvarchar(30) not null,


primary key(studentid,coursename,semester)
)


