--조회 연습하기 (별칭 alias)
SELECT ename from emp;
SELECT ename "사원 명" from emp;
SELECT ename,sal from emp;
SELECT ename 사원명,sal 급여 from emp;
SELECT ename 사원명,sal as 급여 from emp;
SELECT * from emp; --*은 전부다 라는 뜻

--emp에서 사원명과 직업을 조회하시오
SELECT ename 사원명, job 직업 from emp;
SELECT job from emp; --직업만 출력
--직업 출력하는데 중복은 제거해서 한번만 출력
SELECT DISTINCT job from emp; --distinct

-- 표현식(컬럼외에 출력을 원하는 내용을 select구문 뒤에 ' '사용
--사원명 뒤에 '오늘 근무중'
select ename 사원명,'오늘 근무중' from emp;
--문자끼리 더해서 출력해주는 연산자 ||
--emp에서 my name is SMITH!!
select 'my name is ' ||ename|| '!!' from emp;
--emp에서 smith님의 직업은 clerk입니다.
select ename||'님의 직업은 '||job||'입니다.' from emp;
--professor에서 송강님은 정교수 입니다.
select name||'님은 '||position||' 입니다.'from professor;

--정렬(오름차순 asc 내림차순 desc) order by 절은 맨마지막에
select name 학생명,grade 학년,birthday 생년월일 from student order by name asc;
select name 학생명, grade 학년, birthday 생년월일 from student order by grade desc;
select name 학생명, grade 학년, birthday 생년월일 from student order by 2 desc; --2열로도 가능

--emp에서 급여가 높은 순으로 사원명, 급여를 조회하시오
select ename 사원명, sal 급여 from emp order by sal desc;

--조건절(where)
--select (원하는 컬럼) from (테이블) where 원하는 조건

--emp에서 deptno가 20번인 사원명과 부서번호를 출력하시오
select ename 사원명, deptno 부서번호 from emp where deptno=20;--숫자/만약 문자라면 ' '써야함
--emp에서 급여가 3000만원 이상인 사원명과 급여를 조회하시오
select ename 사원명, sal 급여 from emp where sal>=3000;
--smith의 모든정보 조회
select * from emp where ename='SMITH';
--문자와 날짜는 모두 ' ', 문자는 대소문자 구별
select * from emp where hiredate>'85/01/01';

--학생테이블에서 키가 180이상인 학생과 신장을 조회해보세요.
select name 학생명,height 신장 from student where height>=180;

--between a(작은거), and b(큰거)
--학생몸무게 60-80kg까지의 학생명과 몸무게열로 조회하시오.
select name 학생명, weight 몸무게 from student where weight between 60 and 80;
select name 학생명, weight 몸무게 from student where weight between 60 and 80 order by weight;

--and 연산자
select name 학생명, weight 몸무게 from student where weight>=60 and weight<=80; 

--in연산자
--부서번호가 20,30인 사원명 부서번호를 출력
select ename 사원명, deptno 부서번호 from emp where deptno in(20,30);
--직업이 salesman,manager 인 사람의 사원명과 직업을 출력하시오.
select ename 사원명, job 직업 from emp WHERE job in('SALESMAN','MANAGER');

--or 연산자
select ename 사원명, DEPTNO 직업 from emp where DEPTNO=20 OR DEPTNO=30;
select ename 사원명, JOB 직업 from emp where JOB='SALESMAN' OR JOB='MANAGER';

--IS NULL
--보너스가 없는 사원명만 출력하기
select ename 사원명, comm 보너스 from emp where comm is null;
--보너스 받는 사람의 사원명과 보너스금액 조회(is not null)
select ename 사원명, comm 보너스 from emp where comm is not null;

--기존 컬럼명으로 새로운 컬럼명을 만들어 조회도 가능
select ename 사원명, sal 급여, comm 보너스, sal+comm 총급여 from emp; --null은 비어있다 생각하여 결과값이 null로 나옴
--null을 0으로 바꿔야 한다.
--NVL..모든데이터에 적용,0,***
select ename 사원명, sal 급여, nvl(comm,0) 보너스, sal+nvl(comm,0) 총급여 from emp;

--전체인원수
select count(*) from emp;
select count(comm) from emp; --null 값은 전체값에서 빠짐, 포함이 안됨

--emp에서 7902,7698인 사원명과 mgr을 출력하시오(단 in)
select ename 사원명, empno mgr from emp where empno in(7902,7698);
--사원명이 james인 사람의 사원명 급여 총급여를 조외하시오
select ename 사원명, sal 급여, sal+nvl(comm,0) 총급여 from emp;
--processer에서 정교수만 교수명 직급(정교수)을 출력하시오(단 이름은 오름차순)
select name 교수명, position 직급 from professor where position='정교수' order by name asc;

--LIKE
--% 여러개의 문자를 대체해주고 _(언더바)하나의 문자를 대체해줌
--교수테이블에서 성이 이씨인 사람만 조회
select name 교수명 from professor where name Like '박%';
select ename 사원명 from emp where ename like 'A%';
select ename 사원명 from emp where ename like '%K';
select ename 사원명 from emp where ename like '__A%'; --3번째 자리에 a가 오는 이름 조회
select ename 사원명 from emp where ename like'%A%'; --A를 가지고 있는 이름 전부다 출력

--job의 두번째 글자가 n인 사원명과 직업을 조회
select ename 사원명, job 직업 from emp where job like '_N%';

--학생테이블에서 이름중에 주 가 있는 학생 조회
select name 학생명 from student where name like '%주%';


--사원번호 사원명 입사일을 조회하되 82년 이후 입사했거나 직업이 MANAGER인 사람을 조회할것
select empno 사원번호,ename 사원명, hiredate 입사일 from emp where empno>=82/01/01 OR job='MANAGER' ;
--사원번호 사원명 총급여를 출력하시오(단 sal*12*comm이 총급여)
SELECT EMPNO 사원번호, ENAME 사원명, SAL*12*NVL(COMM,1)총급여 FROM EMP;
--사원명에 s가 들어있는 사람을 모두 출력하되 사원명, 입사일을 조회하시오
SELECT ENAME 사원명, HIREDATE 입사일 FROM EMP WHERE ENAME LIKE '%S%';
--급여가 3000만원 이상이고 직급은 ANALYST인 사람을 사원명 급여로 조회하시오
select ename 사원명, sal 급여 from emp where sal>=3000 and job='ANALYST';
--4학년학생중에서 키가 180이상인 학생의 학생명 키를 조회하시오
select name 학생명, grade 학년, height 신장 from student where height>=180 and grade>=4;


--2차정렬(다중 정렬)
select empno 사원번호, ename 사원명, sal 급여, hiredate 입사일, job 직업 from emp order by job,sal; --오름차순 생략 가능
--학생테이블 이름,학년, 키,몸무게 출력
select name 이름, grade 학년, height 키, weight 몸무게 from student order by grade desc,height;


--emp에서 smith님의 급여는 800만원입니다.
select ename||'님의 급여는 '||sal||'만원 입니다.' from emp;
--dept2 지역을 중복제거 후 조회하시오
select DISTINCT area 지역 from dept2;
--교수테이블에서 물리학과이면서 정교수인분만 조회하시오
select name 교수명, position from professor where position='정교수';
--고객테이블에서 포인트가 500000이상인 사람의 이름,주민번호를 조회하시오
select gname 고객명, jumin 주민번호, point 포인트 from gogak where point>=500000;
--학생테이블에서 서진수의 학년과 전화번호만 조회하시오
select name 이름, TEL 전화번호 from student WHERE NAME='서진수';
--학생테이블에서 DEPTNO1이 101이거나 301인 학생의 이름과 주민번호를 조회하시오
select deptno1, name 학생명, jumin 주민번호 from student where deptno1='101' or deptno1='301';


--sql 그룹함수
--count(*) 모든열
--sum(합계)
select count(bonus), sum(bonus) from professor; --null값은 빼고 카운트
--avg(평균)
select count(bonus), avg(bonus) from professor;
--max min
select count(bonus), sum(bonus), avg(bonus), max(bonus), min(bonus) from professor;
select max(hiredate), min(hiredate) from professor;

--소수점 round함수
select round(avg(sal),2) from emp;
select round(avg(sal),1) from emp;
select round(avg(sal),0) from emp;--반올림
select round(avg(sal),-1) from emp;--10단위 올림
select round(avg(sal),-2) from emp;--100단위 올림

--콘솔에 출력
select sysdate from dual; --현재날짜sysdate 아무콘솔(daul)에 넣음
select sysdate+1 from dual;--내일 날짜
select sysdate+7 from dual;--일주일 뒤

--to_char 함수통해서 날짜 및 숫자데이터를 문자로 변환
select to_char(sysdate,'year') from dual;--영어로 나옴
select to_char(sysdate,'yyyy') from dual;
select to_char(sysdate,'mm') from dual;
select to_char(sysdate,'yyyy-mm-dd hh24-mi-ss') from dual;
--to_char 숫자에도 적용 가능
select to_char(980312,'999,999,999') from dual;
select to_char(980312,'0099999.00') from dual;
--emp 사원번호 사원명 입사년도만 추출
select empno 사원번호, ename 사원명, to_char(hiredate,'yyyy') 입사년도 from emp;
select empno 사원번호, ename 사원명, to_char(hiredate,'mm') 입사월 from emp;
--emp에 급여표시
select empno 사원번호, ename 사원명, to_char(sal,'999,999,999$') from emp;


--[서브쿼리]
--쿼리안에 또다른 쿼리가 담김
--smith의 급여보다 많이 받는 사람은?(즉 2가지 질문)
--select 컬럼1, 컬럼2 from 테이블명 where 조건연산자 (select 컬럼명 from 테이블 where 조건);
--메인쿼리(서브쿼리);
--서브쿼리가 먼저 수행되서 결과값을 메인쿼리에 전해주고 그값을 받아서 메인쿼리를 수행;
--서브쿼리는 order by(정렬)은 못함

--평균연봉보다 더많이 받는 사람들의 목록을 조회하시오
select * from emp where sal>(select avg(sal) from emp);

--이름이 scott인 사람의 mgr과 같은 mgr을 가진 사람의 목록을 출력하시오.
select * from emp where mgr=(select mgr from emp where ename='SCOTT');

--학생테이블에서 4학년 평균키보다 큰 사람의 학생명,주민번호,키를 구하시오.
select name 학생명, jumin 주민번호, height 키 from student where height>(select avg(height) from student where grade='4');

--JAMES와 급여가 동일하거나 더많이 받는 사원명과 급여를 조회하시오.
select ename 사원명, sal 급여 from emp where sal>=(select sal from emp where ename='JAMES');


--1. emp에서 표현식을 이용하여 다음처럼 출력하시오 SMITH(CLERK)

--2. 교수테이블에서 이름, 급여, 보너스, 총급여를 구하시오

--3. 고객테이블에서 포인트가 30만~50만 사이인 사람의 이름과 포인트를 출력하시오.

--4. 교수테이블에서 성이 김씨인 사람의 이름, 직위, 전공과목을 조회하시오

--5. EMP에서 COMM이 NULL 인 사람의 이름과 급여를 출력하시오

--6. 학생테이블에서 4학년중에서 키가 170보다 작거나 몸무게가 60보다 큰 학생의 이름, 학년, 키, 몸무게를 조회하시오

--7. EMP에서 COMM의 NULL을 0으로 바꾸어서 직업이 MANAGER인 사람만 이름과 보너스를 출력하시오

--8. 1학년 학생의 이름, 키, 몸무게 출력하시오 단 몸무게는 많은순으로 정렬

--9. 교수테이블에서 나한열의 PAY와 같은 페이를 받는 교수명과 PAY를 조회하시오

--10. 교수테이블에서 조인형의 직급과 같은 직급을 가진 교수명 급여 직급 조회하시오




