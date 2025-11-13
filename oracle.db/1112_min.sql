--[그룹함수 복습]
select sum(sal) 합계 from emp;
select sum(pay) 총급여 from professor;

--자리수, 전체합계와 평균(소수점이하 한자리 반올림);
select sum(sal) 합계, round(avg(sal),1) 평균 from emp;
select sum(pay) 합계, round(avg(pay),2) 평균 from professor;

--최대급여 최소급여
select max(pay) 최대급여, min(pay) 최소급여 from professor;

--emp에서 입사월이 5월인 사람(to_char)
select * from emp where to_char(hiredate,'mm')='05';
--emp에서 입사년이 81년인 사람(to_char)
select * from emp where to_char(hiredate,'yyyy')='1981';

select * from emp where hiredate between '81/01/01' and '81/12/31';
select * from emp where hiredate >='81/01/01' and hiredate<='81/12/31';


--[특정조건으로 세부적인 그룹화하기 GROUP BY]
--select절에 사용된 그룹함수 이외에 컬럼은 반드시 group by 절에 포함이 되어야 함
--professor에서 학과별로 교수들의 평균급여를 출력하시오
select deptno, round(avg(pay),1) "평균 급여" from professor group by deptno;
--학과별, 직급별 교수들의 평균급여 조회
select deptno 학과, position 직급, round(avg(pay),1) "평균급여" from professor group by deptno,position;
--학생테이블에서 학년별 최고몸무게, 평균키를 구하시오.
select grade 학년, max(weight), avg(height) from student group by grade;
--같은 직무를 가진 사원수를 조회하시오
select job 직무, count(job) from emp group by job;

--직무별로 sal의 평균급여 구하시오
select job 직무, round(avg(sal),1) from emp group by job;
--교수직급별로 최고급여와 최고보너스를 구하시오
select position 직급, max(pay) 최고급여, max(bonus) 최고보너스 from professor group by position;
--교수 직급별로 인원수 구하시오
select position 직급, count(position) 인원수 from professor group by position;
--학년별 인원수, 평균키, 평균몸무게 구하시오
select grade 학년, count(grade) 인원수, round(avg(height),1) 평균키, round(avg(weight),1) 평균몸무게 from student group by grade;


--[HAVING 절은 group by에 조건을 줄때 쓰인다]
--where -> group by -> having -> order by
--학과별 평균급여를 구하려면 group by만 필요
--평균급여가 450 이상인 학과의 평균급여를 구하려면 having 절이 필요
select deptno 학과, round(avg(pay),1) from professor group by deptno;
select deptno 학과, round(avg(pay),1) from professor group by deptno having avg(pay)>=450;
--emp에서 부서별로 평균급여를 구하되 2000이상만 조회하시오
select job 부서, round(avg(sal),0) 평균급여 from emp group by job having avg(sal)>=2000;
--deptno가 10,20,30인 부서의 직무별 갯수는?
select job 직무, count(deptno) from emp group by job;
select job 직무, count(deptno)부서 from emp where deptno='10' or deptno='20' group by job;
--deptno가 10,20,30인 부서의 직무별 갯수를 구하되 2명이상만 조회한다
select job 직무, count(deptno) 부서 from emp where deptno in(10,20) group by job having count(deptno)>=2;
--직무별 인원수와 총급여를 구하되 인원이 2명이상이고 총급여가 5000이상 직무만 조회
select job 직무, count(job) 인원수, sum(sal) 총급여 from emp group by job having count(job)>=2 and sum(sal)>='5000';

--모든 where 조건과 그룹, having 다 포함
select job 직무, sum(sal) 총급여 from emp where job not in('MANAGER')--manager 제외
group by job --직무별로 그룹화
having sum(sal)>=5000 --급여합계 5000이상
order by 총급여 desc; --내림차순

--[Rollup,cube] 자동으로 소계/합계 구해주는 함수
--Rollup : group by절에 주어진 조건으로 소계값 구해준다
select deptno 학과, position 직위, sum(pay) 총급여 from professor group by position,rollup(deptno);
select position 직위, count(*) 인원수,sum(pay) 총급여 from professor group by rollup(position);

--cube
select deptno 학과, count(*) 인원수, sum(pay) 총급여 from professor group by cube(deptno);
select position 직위, count(*) 인원수, sum(pay) 총급여 from professor group by cube(position);










