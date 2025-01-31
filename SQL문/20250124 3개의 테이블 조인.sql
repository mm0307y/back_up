SELECT MEM_EMAIL
  FROM member250120
 WHERE MEM_NAME =:x
   AND MEM_TEL =:y;
   
SELECT * FROM member250120;

EDIT member250120;   


SELECT * FROM react_member;

--질문1 : 사용자가 입력한 이메일이 몇개있어? - 전체범위 처리 - 속도 느리다.

--부분범위 처리하기
--
--전체 범위 처리를 하는 함수는 뭐가 있나요?

SELECT MAX(sal) FROM emp;

SELECT MAX(sal),ename FROM emp;

SELECT MAX(sal), MIN(sal), AVG(sal) FROM emp;

--:삼성전자에 직원이 50만명인데 그 중에 반이 김씨 25만명이다. - 빠르다.운반단위 먼저 채워진다.
--그 중 2명만 해씨 이다. 

SELECT count(email) FROM react_member;

SELECT count(nickname) FROM react_member;

SELECT nickname 
 FROM react_member
WHERE email =:x;


--질문2 : 사용자가 입력한 이메일이 존재하니?

SELECT 1
  FROM dual; 
  
-- 사원이 50만명인데 이메일 중복검사 시행한다면
-- 만일 500번째에 같은 이메일이 존재하는 것이 발견되었다.
-- 500번째에서 같은 이메일이 발견되었다면 501번째는 비교할 필요가 없는거 아닌가?
-- 발견되었다면 그 이메일은 사용 불가함.- 판정이 끝  
  
SELECT 1
  FROM dual
 WHERE EXISTS (
                SELECT nickname 
                 FROM react_member
                WHERE email =:x
             );  
             
             
SELECT * FROM member250120;

-- 우리는 반복되는 코드를 피하기 위해서 while(rs.next()){
-- 이 반복문을 resultType 정해주믄 myBatis가 알아서 담는다.
-- 그런데 조회결과가 없다. - 객체를 생성하지 않는다. - NullPoniterException

select * from member250120
       where mem_uid = 'google1';
       
select * from member250120
where mem_uid = 'googlel123123';

select *from member250120
       where mem_uid = 'mm0307a@gmail.com';
-- NullPointerException
       
-- select문에 대한 조회결과가 없다면 과연 myBatis에서는
-- 이런 상황에 대해서도 객체 생성을 할까? 해주나?
-- 생성은 해주지만 빈 깡통이다. list.size()는 0일 것이다.
-- 아니다. 조회결과가 없다면 myBatis에서는 인스턴스화를 해주지 않는다.

delete from member250120;

commit;

select * from member250120;

select * from react_board;

edit react_board;

select * from react_board_comment;

select * from member250120;

-- A집합에도 있고 B집합에도 있는 데이터만 조회 하세요.
-- Natural JOIN, equal join
-- JPA를 사용하면 쿼리문을 개발자가 직접 작성하지 않는다. - 쿼리문이 없다?
-- JPA가 쿼리문을 대시 작성해준다.
-- 쿼리문을 작성하지 않지만 대신 클래스 설계를 해야 한다.(잘 못하면 무한루프에 빠진다.)
-- 업무적인 depth가 깊은 처리를 할 때는 조인에 대한 이해가 절대적으로 필요하다.
-- 즉, 결론 : 클래스와 클래스 사이의 관계형태를 정의할 수 있다. -ERD를 그려본다. - 조인
-- 인덱스 제공, 클러스터 속도 향상의 원리 - 빅데이터, 대용량데이터 솔루션
-- 신입개발자는 잘 안 뽑는다. - 개발자는 늘어난다.
-- Natural JOIN, Self JOIN, Outer JOIN, 카타시안곱(무한루프)

select rb.b_no, rb.b_title, mem.mem_name
    from react_board rb, member250120 mem
   where rb.email = mem.mem_email;
