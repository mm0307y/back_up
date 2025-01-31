select MEM_EMAIL
    from member250120
    where mem_name =:x
        and mem_tel =: y;
        
select * from member250120;

edit member250120;

select * from react_member;

-- 질문 1 : 사용자가 입력한 이메일이 몇개 있어?  - 전체범위 처리  - 속도가 느리다.
-- 부분범위 처리하기
-- 전체 범위 처리를 하는 함수는 뭐가 있나요? -max,

select max(sal) from emp;

select max(sal), ename from emp;

select max(sal), min(sal), avg(sal) from emp;


-- : 삼성전자에 직원이 50만명인데 그 중 반(25만명)이 김씨 이다. - 빠르다 운반단위 먼저 채워진다.
-- 그 중 2명만 해시 이다.

select count(email) from react_member;

select count(nickname) from react_member;

select nickname
    from react_member
   where email =:x;

-- 질문 2 : 사용자가 입력한 이메일이 존재하니?

-- 사원이 50만명인데 이메일 중복검사를 시행한다면
-- 만일 500번째에 같은 이메일이 존재하는 것이 발견되었다.
-- 500번째에서 같은 이메일이 발견되엇다면 501번째는 비교할 필요가 없는건 아닌가?
-- 발견되었다면 그 이메일은 사용 불가하다. - 판정이 끝

select 1
  from dual
 where exists (
                 select nickname
                   from react_member
                  where email =:x
            );
            
select * from member250120;