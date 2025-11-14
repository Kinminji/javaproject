--[본인 첫번째 만든 계정]
--1.department 테이블에 다음 일부만 insert할것
--102 화학공학과
--103 물리학과
--201 유아교육학과
--202 영어영문학과
insert into department (deptno,dname) values (102,'화학공학과');
insert into department (deptno, dname) values (103,'물리학과');
insert into department (deptno, dname) values (201,'유아교육학과');
insert into department (deptno,dname) values (202,'영어영문학과');

select * from department;

--2. professort 테이블에 전체테이터 insert 할것
--4008 홍길동 hong 조교수 440 85/01/01 100 103 hong@gmail.com http://hong.abc.com
insert into professor values (4008,'홍길동','hong','조교수',440,'85-01-01',100,103,'hong@gmail.com','http://hong.abc.com');
--3. professor 테이블에서 김영조의 직급을 정교수로 변경하시오
update professor set position='정교수' where name='김영조';
--4. 4005 바비님의 데이터를 삭제하시오
delete from professor where name='바비';
--5. 학생테이블에서 서진수의 담당교수를 2001로 수정하시오
update student set profno=2001 where name='서진수';

commit;

select * from professor;
select * from student;


--[조인]
--emp dept_deptno
--사원명 부서명
select e.ename,d.dname from emp e, dept d where e.deptno=d.deptno;
--사원명 회사위치
select emp.ename, dept.loc from emp, dept where emp.deptno=dept.deptno;
select ename, loc from emp, dept where emp.deptno=dept.deptno; --하나의 테이블에만 있는 이름은 굳이 말하지 않아도 됨

--student 와 department 이용해서 다음과 같이 출력해보세요.
--학생명 학년 학과명
--서진수 4학년 컴퓨터공학과
select student.name, student.grade, department.dname from student, department where student.deptno1=department.deptno;

--student, professor
--학생명 담당교수
select student.name 학생명, professor.name 교수명 from student, professor where student.deptno1=professor.deptno order by professor.name asc;

--product, panmae
--과자명 판매가 판매개수 총금액
select p_name 상품명, p_price 판매가, p_qty 판매개수, p_total 총금액 from product, panmae where product.p_code=panmae.p_code order by p_total desc;

--emp dept
--사원명 부서 근무지
select ename 사원명, job 부서, loc 근무지 from emp, dept where emp.deptno=dept.deptno;

--student professor
--학번 학생명 부전공 담당교수
--(+)연산자 표시하면 null이거나 없는 데이터도 처리가능
select studno 학번, student.name 학생명 , department.dname 부전공, professor.name 담당교수
from student, professor, department where student.deptno1=professor.deptno(+) and professor.deptno=department.deptno order by professor.name asc;


--1.먼저 비정규화 테이블 만들어서 데이터 넣고 조회
--거래처, 직원 테이블: companysawon 
--회사명: company 문자열
--회사주소: addr 문자열
--회사전화: call 문자열
--직원명: sawon_name
--직급: position
--이메일: email
--휴대폰: hp

create table companysawon(company varchar2 (30), addr varchar2(30), call varchar2(20),
sawon_name varchar2 (10), position varchar2(15), email varchar2(20), hp varchar2(20));

--insert==> 비효율적(정규화의 필요성)
insert into companysawon values('삼성', '서울 강남구', '02-456-9838', '박성진', '과장', 'aaa@samsung.com)', '010-0116-1597');
insert into companysawon values('LG', '서울 강서구', '02-111-2222', '강영현', '과장', 'aaa@LG.com)', '010-1216-1597');
insert into companysawon values('롯데', '서울 잠실구', '02-222-3333', '김원필', '대리', 'aaa@lotte.com)', '010-0428-1597');
insert into companysawon values('소니', '서울 압구정', '02-333-4444', '윤도운', '대리', 'aaa@sony.com)', '010-0825-1597');
insert into companysawon values('애플', '서울 성동구', '02-444-5555', '김민지', '주임', 'aaa@apple.com)', '010-0312-1597');

update companysawon set company='삼성' where company='소니';


--2.위의 테이블을 두개로 나눠 외부키를 이용하여 연결
--거래처아이디: 기본키
--회사명, 회사주소, 회사전화
create table company(company_id number(5) primary key, company varchar2(10), addr varchar2(30), call varchar2(20));

--insert
insert into company values(10,'LG', '서울 강서구', '02-111-2222');
insert into company values(20,'삼성', '서울 강남구', '02-456-9838');
insert into company values(30,'롯데', '서울 잠실구', '02-222-3333');

--거래처 직원 테이블:c_sawon
--직원명, 직급, 이메일, 핸드폰
create table c_sawon(sawon_name varchar2(10), position varchar2(15), email varchar2(20), hp varchar2(20));
alter table c_sawon add c_sawon_id number(5);

--insert
insert into c_sawon values('강영현', '과장', 'aaa@LG.com', '010-1216-1597',10);
insert into c_sawon values('고영배', '부장', 'bbb@LG.com', '010-1216-1597',10);
insert into c_sawon values('권정열', '차장', 'ccc@LG.com', '010-1216-1597',10);
insert into c_sawon values('박성진', '과장', 'aaa@samsung.com', '010-0116-1597',20);
insert into c_sawon values('윤도운', '대리', 'bbb@samsung.com', '010-0116-1597',20);
insert into c_sawon values('김원필', '대리', 'ccc@lotte.com', '010-0428-1597',30);

--조인 이용하셔 출력
select company, addr, call, name, position, email, hp from company, c_sawon where company.company_id=c_sawon.c_sawon_id;

--3.데이터 삭제시 정규화된 테이블의 경우 문제발생 casecade연산자를 이용해서 삭제








rollback;
select * from companysawon;
select * from company;
select * from c_sawon;