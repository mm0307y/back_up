SELECT deptno, dname, loc FROM dept;

SELECT empno as "�����ȣ", ename as "�����", deptno as "�μ���ȣ"
  FROM emp;
  
SELECT empno, ename, deptno
  FROM emp;
  
SELECT 1,2,3 FROM dual;

SELECT 1 FROM dual
UNION ALL
SELECT 2 FROM dual
UNION ALL
SELECT 3 FROM dual;

SELECT empno FROM emp;

-- �ε����� �ִ� �÷��� order by ���� �ʾƵ� ���������� ����Ʈ��.
-- �ε��� ���� �� ����Ʈ�� asc�־��ش�.

SELECT empno FROM emp;

1. parsing-�Ľ� -���������� ������ �ִ��� üũ
2. DBMS�� �����ȹ�� �����.
3. ��Ƽ���������� �ѱ��.
4. open..cursor..fetch..close

�μ����� - 4�� - �ε��� - ���� - ������� - �ε���(empno) - deptno(�ܷ�Ű)
�μ������� �μ���ȣ ��������� �μ���ȣ�� ���� ��.
���� ���̺� ��� �����ϴ� ��츸 ��ȸ�ȴ�.

SELECT
       d.deptno, e.ename, d.dname
  FROM emp e, dept d
 WHERE e.deptno = d.deptno;
 
SELECT distinct(deptno) FROM emp;

SELECT deptno FROM dept
MINUS
SELECT deptno FROM emp;

DELETE FROM dept WHERE deptno=40; 

rollback;


--hint��

SELECT /*+ index_desc(emp pk_emp) */ empno FROM emp;


SELECT ename FROM emp
ORDER BY ename asc;

SELECT rowid rid FROM emp;

SELECT ename
  FROM emp
 WHERE rowid = 'AAARE8AAEAAAACTAAB';
  
SELECT ename FROM emp;
  