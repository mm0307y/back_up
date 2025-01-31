select * from react_board;

select * from react_board_comment;

-- �Խñ� ���̺�� ��� ���̺��� 1:n �����̴�.
-- �Խ��� ���̺� b_no�� ��� ���̺� �ܷ�Ű�� �Ǿ���. �� ���踦  PK, FK �����. �����̼�

SELECT b_no, b_title, b_content, b_hit, b_date, email
  FROM react_board;
  
SELECT rb.b_no, rb.b_title, rb.b_content, rb.b_hit, rb.b_date, rm.nickname
  FROM react_board rb, react_member rm  
 WHERE rb.email = rm.email;

SELECT rb.b_no, rb.b_title, rb.b_content, rb.b_hit, rb.b_date, rm.nickname
  FROM react_board rb, react_member rm  
 WHERE rb.email = rm.email
   AND b_title LIKE '%'||'���־�'||'%';
   
SELECT rb.b_no, rb.b_title, rb.b_content, rb.b_hit, rb.b_date, rm.nickname
  FROM react_board rb, react_member rm  
 WHERE rb.email = rm.email
   AND b_content LIKE '%'||'���־�'||'%';   

SELECT rb.b_no, rb.b_title, rb.b_content, rb.b_hit, rb.b_date, rm.nickname
  FROM react_board rb, react_member rm  
 WHERE rb.email = rm.email
   AND rm.nickname LIKE '%'||'���־�'||'%'; 

SELECT bc_no, bc_comment FROM react_board_comment
 WHERE b_no = 1;
 
SELECT count(*), count(b_no) FROM react_board_comment
 WHERE b_no = 1; 
 
-- count�� �׷��Լ� �̴�.
-- count �Ķ���Ϳ� *����ϸ� ��ü �ο츦 �����ش�. 
-- count �Ķ���Ϳ� �÷����� ���� ��� null�� ��쿡 �ΰ��� �����ȴ�. 

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