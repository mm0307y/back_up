SELECT deptno, dname, loc FROM dept;

INSERT INTO dept(deptno, dname, loc) values(50,'���ߺ�','����');

INSERT INTO tomato_member(mem_id,mem_pw,mem_nick,mem_name)
VALUES('apple','123','���','������');

commit;

SELECT mem_nick, mem_name
  FROM tomato_member
 WHERE mem_id ='tomato'
   AND mem_pw ='123';

SELECT mem_nick, mem_name
  FROM tomato_member
 WHERE mem_id =: user_id
   AND mem_pw =: user_pw;


rollback;

commit;

UPDATE dept SET loc='����' WHERE deptno=50;

DELETE FROM dept;

DELETE FROM dept WHERE deptno = 50;

SELECT empno, ename, sal, hiredate FROM emp;

SELECT count(empno) FROM emp
WHERE deptno = 10;

SELECT count(empno) FROM emp
WHERE deptno = 20;

SELECT count(empno) FROM emp
WHERE deptno = 30;

SELECT count(empno) FROM emp
WHERE deptno = 40;

SELECT count(empno) FROM emp
WHERE deptno = 50;