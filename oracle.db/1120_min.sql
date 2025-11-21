--PrepareStatement 예제를 위한 테이블
create table Mymallipgo(num number(3) primary key, category varchar2(20), sangpum varchar2(30), su number(5), price number(10), ipgo date);

select * from mymallipgo;

create table MystudentInfo(stu_no number(3) primary key, stu_name varchar2(15), stu_addr varchar2(30), stu_grade number(5), stu_blood varchar2(10), stu_birth varchar2(20), writeday date);