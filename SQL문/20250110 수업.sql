SELECT * FROM react_board;

SELECT * FROM react_board_comment;

-- 게시글 테이블과 댓글 테이블은 1:n관계이다.
-- 게시판 테이블의 b_no가 댓글 테이블에 외래키가 되었다.

SELECT b_no, b_title, b_content, b_hit, b_date, email
  FROM react_board;
  
SELECT rb.b_no, rb.b_title, rb.b_content, rb.b_hit, rb.b_date, rm.nickname
  FROM react_board rb, react_member rm  
 WHERE rb.email = rm.email;

SELECT rb.b_no, rb.b_title, rb.b_content, rb.b_hit, rb.b_date, rm.nickname
  FROM react_board rb, react_member rm  
 WHERE rb.email = rm.email
 
   AND b_title LIKE '%'||'맛있어'||'%';
   
SELECT rb.b_no, rb.b_title, rb.b_content, rb.b_hit, rb.b_date, rm.nickname
  FROM react_board rb, react_member rm  
 WHERE rb.email = rm.email
   AND b_content LIKE '%'||'맛있어'||'%';   

SELECT rb.b_no, rb.b_title, rb.b_content, rb.b_hit, rb.b_date, rm.nickname
  FROM react_board rb, react_member rm  
 WHERE rb.email = rm.email
   AND rm.nickname LIKE '%'||'맛있어'||'%'; 

SELECT bc_no, bc_comment FROM react_board_comment
 WHERE b_no = 1;
 
SELECT count(*), count(b_no) FROM react_board_comment
 WHERE b_no = 1; 
 
-- count는 그룹함수 이다.
-- count 파라미터에 *사용하면 전체 로우를 세어준다. 
-- count 파라미터에 컬럼명이 오는 경우 null인 경우에 널값은 배제된다. 

SELECT count(*), count(comm) FROM emp; 

SELECT comm FROM emp;

SELECT comm FROM emp WHERE comm >= 0;

SELECT deptno, count(*) FROM emp;
 
SELECT deptno, count(*) FROM emp
GROUP BY deptno;

 
SELECT bc_no, bc_comment FROM react_board_comment
 WHERE b_no = 2;
 
SELECT bc_no, bc_comment FROM react_board_comment
 WHERE b_no = 3; 
 
SELECT bc_no, bc_comment FROM react_board_comment
 WHERE b_no = 4;  
 
SELECT bc_no, bc_comment FROM react_board_comment
 WHERE b_no = 5; 
 
select '2025-01-10', sysdate, 
    sysdate + 1, sysdate - 1
    from dual;
    
-- 오라클에서는 형전환 함수가 제공된다.

select 1000000, to_char(1000000, '999,999,999')
    from dual;
    
select 1+1, 100-20, 5*3, 10/2 from dual;

select to_char(sysdate, 'YYYY-MM-DD') 
        ,to_char(sysdate, 'YYYY-MM-DD HH:MI:SS AM')
from dual;