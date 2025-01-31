SELECT n_no, n_title, n_content FROM notice1030;

--���̺��� Ŀ���� ���� �ٴ´�. Ŀ���� �����ϴ� �޼ҵ尡 �ʿ��ߴ�.
-- �޼ҵ带 �������� Ŭ������ �Ǿ�� �ߴ�. - �׷��� ����� ���ó�� ���� �޶���Ѵ�.???
--�׷��� �������̽�(����̽����� �޶� ������ �� ������ �߻�޼ҵ�� �����Ұ�) - ������ ����
--  ResultSet�� Ŀ���� �����̴µ� �ʿ��� next(), previous(), isFirst(), isLast(): boolean
-- �׷��� if���̳� while���̳� for�� ��ȣ�ȿ� �� �� �ִ�.
-- PreparedStatement - �������� <-> �������� -Statement
-- SELECT -> pstmt.executeQuery("SELECT��"):ResultSet(�������̽�)
-- INSERT, UPDATE, DELETE -> commit, rollback
-- pstmt.executeUpdate("INSERT��|UPDATE��\DELETE��"):int
-- javadoc����

Restful API - CRUD����(�Է�,����,����,��ȸ) - Model����(������ ó�� + ����Ͻ� ����)


INSERT INTO dept(deptno, dname, loc) VALUES(50,'�ѹ���','��õ');

commit;

SELECT deptno FROM dept
INTERSECT
SELECT deptno FROM emp;

SELECT empno FROM emp;--pk-> unique index(���Ϲ�����-��������,  not null)
--�׷��� ���̺��� access���� �ʰ� index�� �а� ����� ����Ѵ�.

--index - ���� �����ǰ� �ִ�. - �ε����� �����ϴ� ������ ������ �ִ�.- �ε������� ����

1)�Ľ�
2)RDBMS�� �����ȹ�� �����
3)��Ƽ�������� �����ȹ�� �޾Ƽ� ó���Ѵ�.(INSERT, UPDATE, DELETE)
4)OPEN.. CURSOR(��ġ�� �����Ͱ� �����ϸ� true, false��ȯ-�ñ׳�)- Fetch ...CLOSE

SELECT ename FROM emp;--������ �ȵǾ� �ִ�. �ֳĸ� �ε����� ����.�ֿ�? �� PK�� �ƴϴ�.

SELECT ename FROM emp
ORDER BY ename asc;

--hint���� ���ؼ� ��Ƽ���������� �������� �����ȹ�� ������ ��  �ִ�.
--���� ��Ÿ������ ���õȴ�.- ������ �ȴ�.- �����ȹ�� �ݿ����� �ʾҴ�.

SELECT /*+index_desc(emp pk_emp) */ empno
  FROM emp;

SELECT /*+index_desc(emp222222 pk_emp) */ empno
  FROM emp;


--FK �ܷ�Ű, �ε����� �������� ����, �ߺ� �ȴ�.

--��������� deptno�� �μ����հ� 1:n����� �߰��� �÷��ε� �̰��� �ܷ�Ű��� �Ѵ�.

SELECT count(deptno) FROM emp WHERE deptno = 30;

SELECT count(deptno) FROM emp WHERE deptno = 10;

SELECT distinct(deptno) FROM emp;

SELECT emp.ename, emp.sal, emp.hiredate, dept.dname
  FROM dept, emp
 WHERE dept.deptno = emp.deptno;
 
SELECT emp.ename, emp.sal, emp.hiredate, deptno
  FROM emp;



SELECT deptno FROM dept
MINUS
SELECT deptno FROM emp;

DELETE FROM dept WHERE deptno =:x;

SELECT * FROM dept WHERE deptno=50;

--executeUpdate():int

UPDATE dept
  SET dname='���ߺ�'
     ,loc='����'
WHERE deptno = 50; -- executeUpdate(update��-ó��):int -> 1row updated

-- if(result ==1) ������ �����Ͽ����ϴ�. else ������ �����Ͽ����ϴ�. - ����

DELETE FROM dept WHERE deptno=:x;

commit;

--���̵� �ִ��� ���ϱ�

SELECT 1 FROM dual;

SELECT NVL(comm, 0), comm FROM emp;

SELECT
       NVL((SELECT 1 FROM dual
             WHERE EXISTS (SELECT mem_name FROM tomato_member
                            WHERE mem_id=:user_id)
            ),-1) isID
  FROM dual;

--���̵� ������ ��� ���ϱ�

SELECT mem_nick FROM tomato_member
 WHERE mem_id =:x
   AND mem_pw =:y;