select MEM_EMAIL
    from member250120
    where mem_name =:x
        and mem_tel =: y;
        
select * from member250120;

edit member250120;

select * from react_member;

-- ���� 1 : ����ڰ� �Է��� �̸����� � �־�?  - ��ü���� ó��  - �ӵ��� ������.
-- �κй��� ó���ϱ�
-- ��ü ���� ó���� �ϴ� �Լ��� ���� �ֳ���? -max,

select max(sal) from emp;

select max(sal), ename from emp;

select max(sal), min(sal), avg(sal) from emp;


-- : �Ｚ���ڿ� ������ 50�����ε� �� �� ��(25����)�� �达 �̴�. - ������ ��ݴ��� ���� ä������.
-- �� �� 2�� �ؽ� �̴�.

select count(email) from react_member;

select count(nickname) from react_member;

select nickname
    from react_member
   where email =:x;

-- ���� 2 : ����ڰ� �Է��� �̸����� �����ϴ�?

-- ����� 50�����ε� �̸��� �ߺ��˻縦 �����Ѵٸ�
-- ���� 500��°�� ���� �̸����� �����ϴ� ���� �߰ߵǾ���.
-- 500��°���� ���� �̸����� �߰ߵǾ��ٸ� 501��°�� ���� �ʿ䰡 ���°� �ƴѰ�?
-- �߰ߵǾ��ٸ� �� �̸����� ��� �Ұ��ϴ�. - ������ ��

select 1
  from dual
 where exists (
                 select nickname
                   from react_member
                  where email =:x
            );
            
select * from member250120;