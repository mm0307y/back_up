SELECT MEM_EMAIL
  FROM member250120
 WHERE MEM_NAME =:x
   AND MEM_TEL =:y;
   
SELECT * FROM member250120;

EDIT member250120;   


SELECT * FROM react_member;

--����1 : ����ڰ� �Է��� �̸����� ��־�? - ��ü���� ó�� - �ӵ� ������.

--�κй��� ó���ϱ�
--
--��ü ���� ó���� �ϴ� �Լ��� ���� �ֳ���?

SELECT MAX(sal) FROM emp;

SELECT MAX(sal),ename FROM emp;

SELECT MAX(sal), MIN(sal), AVG(sal) FROM emp;

--:�Ｚ���ڿ� ������ 50�����ε� �� �߿� ���� �达 25�����̴�. - ������.��ݴ��� ���� ä������.
--�� �� 2�� �ؾ� �̴�. 

SELECT count(email) FROM react_member;

SELECT count(nickname) FROM react_member;

SELECT nickname 
 FROM react_member
WHERE email =:x;


--����2 : ����ڰ� �Է��� �̸����� �����ϴ�?

SELECT 1
  FROM dual; 
  
-- ����� 50�����ε� �̸��� �ߺ��˻� �����Ѵٸ�
-- ���� 500��°�� ���� �̸����� �����ϴ� ���� �߰ߵǾ���.
-- 500��°���� ���� �̸����� �߰ߵǾ��ٸ� 501��°�� ���� �ʿ䰡 ���°� �ƴѰ�?
-- �߰ߵǾ��ٸ� �� �̸����� ��� �Ұ���.- ������ ��  
  
SELECT 1
  FROM dual
 WHERE EXISTS (
                SELECT nickname 
                 FROM react_member
                WHERE email =:x
             );  
             
             
SELECT * FROM member250120;

-- �츮�� �ݺ��Ǵ� �ڵ带 ���ϱ� ���ؼ� while(rs.next()){
-- �� �ݺ����� resultType �����ֹ� myBatis�� �˾Ƽ� ��´�.
-- �׷��� ��ȸ����� ����. - ��ü�� �������� �ʴ´�. - NullPoniterException

select * from member250120
       where mem_uid = 'google1';
       
select * from member250120
where mem_uid = 'googlel123123';

select *from member250120
       where mem_uid = 'mm0307a@gmail.com';
-- NullPointerException
       
-- select���� ���� ��ȸ����� ���ٸ� ���� myBatis������
-- �̷� ��Ȳ�� ���ؼ��� ��ü ������ �ұ�? ���ֳ�?
-- ������ �������� �� �����̴�. list.size()�� 0�� ���̴�.
-- �ƴϴ�. ��ȸ����� ���ٸ� myBatis������ �ν��Ͻ�ȭ�� ������ �ʴ´�.

delete from member250120;

commit;

select * from member250120;

select * from react_board;

edit react_board;

select * from react_board_comment;

select * from member250120;

-- A���տ��� �ְ� B���տ��� �ִ� �����͸� ��ȸ �ϼ���.
-- Natural JOIN, equal join
-- JPA�� ����ϸ� �������� �����ڰ� ���� �ۼ����� �ʴ´�. - �������� ����?
-- JPA�� �������� ��� �ۼ����ش�.
-- �������� �ۼ����� ������ ��� Ŭ���� ���踦 �ؾ� �Ѵ�.(�� ���ϸ� ���ѷ����� ������.)
-- �������� depth�� ���� ó���� �� ���� ���ο� ���� ���ذ� ���������� �ʿ��ϴ�.
-- ��, ��� : Ŭ������ Ŭ���� ������ �������¸� ������ �� �ִ�. -ERD�� �׷�����. - ����
-- �ε��� ����, Ŭ������ �ӵ� ����� ���� - ������, ��뷮������ �ַ��
-- ���԰����ڴ� �� �� �̴´�. - �����ڴ� �þ��.
-- Natural JOIN, Self JOIN, Outer JOIN, īŸ�þȰ�(���ѷ���)

select rb.b_no, rb.b_title, mem.mem_name
    from react_board rb, member250120 mem
   where rb.email = mem.mem_email;
