--시퀀스
create sequence seq4;

--테이블
create table hello(num number(3) primary key, name varchar2(20), age number(5), writeday date);

--insert
insert into hello values(seq4.nextval, '홍길동', 33, sysdate);

select * from hello;

update hello set age=40 where num=3;
update hello set name='박해수', age=42 where num=2;


--2번째 테이블
create table myclub(cno number(3) primary key, cname varchar2(20), caddr varchar2(50), cjob varchar2(30), chp varchar2(20), gaipday date);

select * from myclub;
