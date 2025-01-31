-- 관계지향형 데이터베이스
-- 집합에 대한 정의에 따라서 여러개로 나누어 관리
-- 테이블의 수가 많아진다.
-- 관계형태의 종류
-- 1:1, 1:n,  n:n(업무적인 정의가 덜 된 경우)
-- 둘 이상의 집합 사이에서 가능한 관계형태는 1:1, 1:n
--  n:n은 왜 대상이 아닌가? - 쓰레기 값을 포함한다. 있을 수 있는 경우의 수(가능성) (의미가 없거나 필요없는 값들) 

select empno, ename
    from emp;
    
select deptno, dname
    from dept;

select empno, ename, dname
    from emp;
    
-- 왜 부서이름을 적었나요? 그 사원의 부서이름을 알고 싶다.
-- 조회결과는 14명 사원해 대한 부서이름을 출력한다.
-- 14*4 = 56명의 사원이 있나요? 사원수는 14명인데.. - 카타시안곱이다. - 근무할 수 있는 부서의 종류가 모두 출력되었다.
-- 위 문제를 해결 방법은 join(조인)이다. 
    
select empno, ename, dname
    from emp,dept;
    
-- RED (Entity Relation Diagram) 테이블 관계를 도식화해서 보는 것을 말한다. 이걸 가능하게 하는 프로그램은 ERWIN이다.

-- 하나의 부서에 근무하는 사원이 몇 명 인가요?

select count (empno) from emp
where deptno = 10;

select count (empno) from emp
where deptno = 20;

select count (empno) from emp
where deptno = 30;

select count (empno) from emp
where deptno = 40;

select deptno, count (empno) 
    from emp
 group by deptno;
 
 select deptno from dept
 minus
 select deptno from emp;
 
select deptno from  emp
 minus
 select deptno from dept;
 
 select distinct(deptno) from emp;
 
 select deptno from emp;
 
select
        e.ename, d.dname, d.deptno
    from emp e, dept d
 where e.deptno = d.deptno;
 
select
        e.ename, d.dname, d.deptno
    from emp e, dept d
 where e.deptno = d.deptno;
 
 -- 부서집합에서는 40번이 있는데 사원집합에는 40번이 없다.
 -- 그래도 보여줘 한다면
 -- 없는쪽에 조건절 컬럼명 뒤에 괄호를 쓰고 +를 적는다.
 
select
        e.ename, d.dname, d.deptno
    from emp e, dept d
 where e.deptno (+) = d.deptno;
 

-- Natural 조인(바뀐문법), equal조인 (옛날 표현식)

-- 부서이름은 없지만 부서 번호가 있다.

-- UID바 (Unique Identifier Bar)
-- 테이블 각 엔티티에 대한 고유 식별자를 표시
-- 그 대상은 주로 pk를 시각적으로 나타낸다.
-- 각 엔티티가 특정  속성을 통해서 고유하게 식별될 수 있도록 한다.
-- empno, deptno : 고유 식별자(UID) 데이터가 중복되지 않게 무결성을 유지해준다.
-- 1. PK는 인덱스가 제공된다. 2.  UNIQUE유니크하다. 3. Not Null
-- FK는 중복된다. 인데스가 없다. 속도가 느리다.
-- emp에서 empno는 pk이다. 그러나 deptno는 fk이다. 그래서 중복이 허락 된다.