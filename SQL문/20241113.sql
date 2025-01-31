-- ���������� �����ͺ��̽�
-- ���տ� ���� ���ǿ� ���� �������� ������ ����
-- ���̺��� ���� ��������.
-- ���������� ����
-- 1:1, 1:n,  n:n(�������� ���ǰ� �� �� ���)
-- �� �̻��� ���� ���̿��� ������ �������´� 1:1, 1:n
--  n:n�� �� ����� �ƴѰ�? - ������ ���� �����Ѵ�. ���� �� �ִ� ����� ��(���ɼ�) (�ǹ̰� ���ų� �ʿ���� ����) 

select empno, ename
    from emp;
    
select deptno, dname
    from dept;

select empno, ename, dname
    from emp;
    
-- �� �μ��̸��� ��������? �� ����� �μ��̸��� �˰� �ʹ�.
-- ��ȸ����� 14�� ����� ���� �μ��̸��� ����Ѵ�.
-- 14*4 = 56���� ����� �ֳ���? ������� 14���ε�.. - īŸ�þȰ��̴�. - �ٹ��� �� �ִ� �μ��� ������ ��� ��µǾ���.
-- �� ������ �ذ� ����� join(����)�̴�. 
    
select empno, ename, dname
    from emp,dept;
    
-- RED (Entity Relation Diagram) ���̺� ���踦 ����ȭ�ؼ� ���� ���� ���Ѵ�. �̰� �����ϰ� �ϴ� ���α׷��� ERWIN�̴�.

-- �ϳ��� �μ��� �ٹ��ϴ� ����� �� �� �ΰ���?

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
 
 -- �μ����տ����� 40���� �ִµ� ������տ��� 40���� ����.
 -- �׷��� ������ �Ѵٸ�
 -- �����ʿ� ������ �÷��� �ڿ� ��ȣ�� ���� +�� ���´�.
 
select
        e.ename, d.dname, d.deptno
    from emp e, dept d
 where e.deptno (+) = d.deptno;
 

-- Natural ����(�ٲ﹮��), equal���� (���� ǥ����)

-- �μ��̸��� ������ �μ� ��ȣ�� �ִ�.

-- UID�� (Unique Identifier Bar)
-- ���̺� �� ��ƼƼ�� ���� ���� �ĺ��ڸ� ǥ��
-- �� ����� �ַ� pk�� �ð������� ��Ÿ����.
-- �� ��ƼƼ�� Ư��  �Ӽ��� ���ؼ� �����ϰ� �ĺ��� �� �ֵ��� �Ѵ�.
-- empno, deptno : ���� �ĺ���(UID) �����Ͱ� �ߺ����� �ʰ� ���Ἲ�� �������ش�.
-- 1. PK�� �ε����� �����ȴ�. 2.  UNIQUE����ũ�ϴ�. 3. Not Null
-- FK�� �ߺ��ȴ�. �ε����� ����. �ӵ��� ������.
-- emp���� empno�� pk�̴�. �׷��� deptno�� fk�̴�. �׷��� �ߺ��� ��� �ȴ�.