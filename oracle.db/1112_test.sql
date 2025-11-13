--test계정에서 테이블 만들어보기

--테이블확인
select * from tab;

-- 테이블생성.gibon
--primary key 기본키: unique+not null
CREATE table gibon (num number(5) primary key, name varchar2(20), score number(6,2), birth date);

--테이블 구조 확인
desc gibon;

--테이블 확인
select * from gibon;

--gibon 테이블에 전체 데이터 insert 하기
--두번 삽입시 참조무결성 오류(기본키 임으로 중복 불가능)
insert into gibon values(1,'박성진',87.7,'93-01-16');
insert into gibon values(2,'강영현',180.3,'93-12-26');
insert into gibon values(3,'김원필',174.8,'94-04-17');
insert into gibon values(4,'윤도운',178.8,'95-08-25');

--gibon 테이블에 일부 데이터 insert 하기
insert into gibon (num, name) values(200,'김민지');

--gibon의 일부만 조회
select name, score from gibon;
select name, briteh from gibon;

--sysdate 현재날짜
--두번넣으면 무조건 무결성 제약조건에 어긋나서 오류가 난다.
insert into gibon values(25,'이태민',177.7,sysdate);

--컬럼을 추가..나이 초기값은 무조건 null
alter table gibon add age number(5);

--컬럼명을 추가..주소 기본값을 강남구
alter table gibon add addr varchar2(30) default '강남구';

--주소 컬럼을 30-->50 으로 변경
alter table gibon modify addr varchar2(50);

--나이 varchar2(10)으로 변경 초기값:20으로 설정
--기존 null은 그대로 있고 새로 insert하는것부터 초기값이 들어감
alter table gibon modify age number(10) default '20';

--전체 insert
insert into gibon values(312,'김지수',163.2,'94-10-19','32','서울시 성동구');
--부분 insert-num,name,addr
insert into gibon (num,name,addr) values(28,'홍민지','경기도 김포시');


--num의 오름차순 출력
select * from gibon order by num;
--이름이 내림차순 출력
select * from gibon order by name desc;


--칼럼 삭제
--age 삭제
alter table gibon drop column age;
--addr 삭제
alter table gibon drop column addr;

--칼럼명 변경
--score --> height
alter table gibon rename column score to height;
--birth --> birthday
alter table gibon rename column birth to birthday;

--테이블 삭제
drop table gibon;

select * from gibon;


--[시퀀스]
--유일한 값 생성해주는 오라클객체
--기본키에 순차적으로 중가하는 컬럼을 자동생성
--증감숫자가 최대값에 도달하면 생성을 중단할지(nocycle) 아니면 처음부터 다시 생성(cycle)할지
--메모리에 시퀀스를 미리 할당(cache) 혹은 할당하지 않을지(nocache)

--시퀀스 기본으로 생성..1부터 1씩 증가하는 시퀀스 생성됨
create sequence seq1;

--전체시퀀스 확인
select * from seq;

--시퀀스에서 다음 시퀀스 발생
select seq1.nextval from dual;

--시퀀스에서 마지막 발생한값
select seq1.currval from dual;

--sql1시퀀스 삭제
drop sequence seq1;


--10부터 5씩 증가하는 시퀀스 생성 -cache값은 없애기
create sequence seq1 start with 10 increment by 5 nocache;

--시퀀스 발생
select seq1.nextval from dual;

select * from seq;

--시퀀스 삭제
drop sequence seq1;

--seq1 :시작값 5, 증가값 5, 캐쉬 no
create sequence seq1 start with 5 increment by 5 nocache;
--seq2 :시작값 1, 증가값 2
create sequence seq2 start with 1 increment by 2;
--seq3 :시작값 1, 증가값 1, 캐쉬 no
create sequence seq3 start with 1 increment by 1 nocache;

--출력
select seq1.nextval, seq2.nextval, seq3.nextval from dual;

--1,2,3삭제
drop sequence seq1;
drop sequence seq2;
drop sequence seq3;


--시퀀스생성후 테이블생성하고 기본키발생시킬때 시퀀스적용해보기

create sequence seq_test;

--테이블 생성
create table person (num number(5) primary key,name varchar2(20),job varchar2(20),gender varchar2(10),age number(3),hp varchar2(20),birth date);

--구조확인
desc person;

--birth를 ipsaday로 바꿔보자
--alter table person rename column birth to ipsaday;

--조회연습을 위해서 10개이상 데이타 추가(시퀀스추가) _요리사,교사,개발자
insert into person values(seq_test.nextval,'이영자','요리사','여자',25,'010-1111-2546','2025-01-12');
insert into person values(seq_test.nextval,'김수환','교사','남자',25,'010-4587-2546','2025-06-12');
insert into person values(seq_test.nextval,'김민지','개발자','여자',29,'010-2541-2589','2025-11-19');
insert into person values(seq_test.nextval,'홍민지','요리사','여자',21,'010-5555-2546','2025-08-12');
insert into person values(seq_test.nextval,'이영자','교사','여자',29,'010-1248-2546','2024-01-10');
insert into person values(seq_test.nextval,'허민','개발자','남자',33,'010-5555-1111','2024-11-10');
insert into person values(seq_test.nextval,'이영자','요리사','여자',25,'010-1111-2546','2025-01-12');
insert into person values(seq_test.nextval,'이영자','요리사','여자',25,'010-1111-2546','2025-01-12');
insert into person values(seq_test.nextval,'손흥민','개발자','남자',35,'010-7777-6666','2023-10-25');
insert into person values(seq_test.nextval,'홍유미','교사','여자',36,'010-7777-8888','2023-11-25');

--최종저장
commit;

--인원수 확인
select count(*) from person;

--이름 오름차순 출력
select * from person order by name;
--나이의 역순으로 출력
select * from person order by age desc;
--성별의 오름차순,같을경우 이름의 오름차순
select * from person order by gender,name;

--중복되지않게 직업의 종류만 출력
select distinct job from person;

--성이 이씨인 사람만 출력
select * from person where name like '이%';

--핸드폰이 010 으로 시작하는 사람출력
select * from person where hp like '010%';

--입사월이 10월인사람 출력
select * from person where to_char(ipsaday,'mm')='10';

--입사년도가 2025년도만 출력
select * from person where to_char(ipsaday,'yyyy')='2025';

--나이가 20~25세 사이(AND)
select * from person where age>='20' and age<='25';
--나이가 20~25세 사이(between)
select * from person where age between 20 and 25;
--직업이 교사이거나 개발자인사람 출력(IN)
select * from person where job in('교사','개발자');
--직업이 교사이거나 개발자인사람 출력(OR)
select * from person where job='교사' or job='개발자';
--직업이 교사, 개발자를 제외한 직업을 가진 사람
select * from person where job not in('교사','개발자');

--update
--update 테이블명 set column=value where 조건;
--모든컬럼 변경
update person set job='취준생', age='28';

rollback;

--시퀀스 3번만 데이터 바꾸기
update person set job='취준생', age='28' where num=3;

--이씨이면서 요리사인 사람의 젠더를 남자로 수정
update person set gender='남자' where job='요리사' and name like'이%';

--num이 8번인 사람의 직업을 교수, 입사일을 2025-01-02로 변경
update person set job='교수', ipsaday='25-01-02' where num=8;

--삭제
--5번삭제
delete from person where num=5; 

--여자이면서 30세 이상 모두 삭제
delete from person where gender='여자' and age>='30';


--[과제물]
--시퀀스생성
--seq4 시작:5 증가:5
create sequence seq4 start with 5 increment by 5;
--테이블 생성
--테이블명 : moim
--no number(3) 기본키: seq값
--name varchar2 (20)
--addr varchar2(30)
--hp varchar2(20)
--job varchar2(30)
--gaipday 오늘날짜
create table moim(no number(3) primary key, name varchar2(20), addr varchar2(30), hp varchar2(20), job varchar2(30), gaipday date);

--최소 10개 이상 넣기(commit 필수)
insert into moim values(1,'박성진','부산광역시 수성구','010-0116-1597','프론트맨',sysdate);
insert into moim values(2, '강영현','고양시 일산동구','010-1216-1597','베이스',sysdate);
insert into moim values(3, '김원필','인천광역시 계양구','010-0408-1597','키보드',sysdate);
insert into moim values(4, '윤도운','창원시','010-0825-1597','드럼',sysdate);
insert into moim values(5, '김민지','서울특별시 광진구','010-6621-9838','개발자',sysdate);
insert into moim values(6, '김지수','서울특별시 성동구','010-1019-0404','웹퍼블리셔',sysdate);
insert into moim values(7, '엄혜지','경기도 남양주시','010-0113-0408','연구원',sysdate);
insert into moim values(8, '유희재','부산광역시 서구','010-0402-1256','취준생',sysdate);
insert into moim values(9, '김다영','경기도 수원시','010-0311-8282','승무원',sysdate);
insert into moim values(10, '임정은','서울특별시 광진구','010-0728-8520','PD',sysdate);


--이름이 김씨인 사람 조회
select * from moim where name like '김%';
--김지수의 직업을 개발자로 수정하시오
update moim set job='개발자' where name='김지수';
update moim set addr='서울특별시 광진구' where name='김다영';
--개발자이거나 서울특별시 광진구에 사는 사람만 조회하시오
select * from moim where job='개발자' or addr='서울특별시 광진구';
--개발자가 아닌 사람만 조회하시오
select * from moim where job not in '개발자';
--moim회원의 총 인원수를 구하시오
select count(*) from moim;
--moim의 직업만 중복되지 않게 조회하시오
select distinct job from moim;


--제약조건물

create table sawon (num number(10) CONSTRAINT sawon_pk_num primary key,
name varchar2(20), gender varchar2(20), buseo varchar2(20) CONSTRAINT sawon_ck_buseo CHECK(buseo in('개발부',' 마케팅부','디자인부')), pay number(10) default 1000000, ipsa date);

--나중에 제약조건 alter로 추가 가능
alter table sawon add CONSTRAINT sawon_ck_gender check(gender in('남자','여자'));

--시퀀스 만들기
create sequence seq_sawon;

--데이터 추가
insert into sawon values(seq_sawon.nextval, '박성진', '남자', ' 마케팅부', 2500000, sysdate);
insert into sawon values(seq_sawon.nextval, '강영현', '남자', '개발부', 3800000, sysdate);
insert into sawon values(seq_sawon.nextval, '김원필', '여자', ' 마케팅부', 2200000, sysdate);
insert into sawon values(seq_sawon.nextval, '윤도운', '남자', '디자인부', 3000000, sysdate);
insert into sawon values(seq_sawon.nextval, '김민지', '여자', '개발부', 3500000, sysdate);
insert into sawon values(seq_sawon.nextval, '김지수', '여자', '개발부', 3600000, sysdate);
insert into sawon values(seq_sawon.nextval, '김다영', '여자', '디자인부', 2800000, sysdate);
insert into sawon values(seq_sawon.nextval, '유희재', '남자', ' 마케팅부', 2400000, sysdate);
insert into sawon values(seq_sawon.nextval, '임정은', '여자', '개발부', 3600000, sysdate);
insert into sawon values(seq_sawon.nextval, '엄혜지', '여자', '개발부', 3000000, sysdate);

--사원번호 5번의 성별의 남자로 변경하시오
update sawon set gender='남자' where num=5;
--10번의 입사 일자를 25-10-19로 변경하시오
update sawon set pay=3700000 where num=10;
--13번이 퇴사했으므로 삭제
delete from sawon where num=13;


--그룹함수 연습
--부서별 인원수 최고급여 최소급여 조회(제목도 별칭으로 나오게)
select buseo 부서, count(buseo) 인원수, max(pay), min(pay) from sawon group by buseo;
--위의 쿼리문에서 급여부분에 화폐단위 붙히고 3자리컴마도 나오도록
select buseo 부서, count(buseo) 인원수, to_char(max(pay),'L999,999,999') 최고급여, to_char(min(pay),'L999,999,999') 최소급여 from sawon group by buseo;
--위의 쿼리문에서 인원수 2명처럼 표기되게 수정
select buseo 부서, count(buseo)||'명' 인원수, to_char(max(pay),'L999,999,999') 최고급여, to_char(min(pay),'L999,999,999') 최소급여 from sawon group by buseo;
--성별인원수와 평균급여, 최고급여, 최저급여를 구하시오(별칭, 2명포함..)
select  gender 성별, count(gender) ||'명' 인원수, to_char(avg(pay),'L999,999,999') 평균급여, to_char(max(pay),'L999,999,999') 최고급여, to_char(min(pay),'L999,999,999') 최소급여 from sawon group by gender;
--group by와 연결된 조건만--having ..4명 이상인 경우만 출력
select buseo 부서, count(buseo)||'명' 인원수, to_char(avg(pay),'L999,999,999') 평균급여 from sawon group by buseo having count(buseo)>=4;


--제약조건 제거하기
--sawon 테이블의 sawon_ck_boseo 제거
alter table sawon drop CONSTRAINT sawon_ck_buseo;
--다른부서 추가해보기
insert into sawon values (seq_sawon.nextval,'이동욱', '남자', '경영지원부', 33000000,'2025-10-17');
--sawon name컬럼에 unique제약조건 추가하기(sawon_uk_name)
alter table sawon add CONSTRAINT sawon_uk_name unique(name);







select * from sawon;
commit;