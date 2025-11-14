--company 와 c_sawon
--조인테이블
--거래처회사 거래처사원 직위
select company, name, position from company,c_sawon where company.company_id=c_sawon.c_sawon_id;

--emp
--사원명 부서명 
--smith 20번에 해당하는 실제 부서명
select ename 성함, dname 부서명 from emp,dept where emp.deptno=dept.deptno and ename='SMITH';

--교수명  학과명
select name ||'교수' 교수명 , dname 학과 from professor p, department d where p.deptno=d.deptno;