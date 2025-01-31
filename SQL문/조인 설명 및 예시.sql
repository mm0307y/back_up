/*�� ���־� ������ ���� �ۼ��� ����� �г����� �������� ����ϴ� sql���� �ۼ��Ͻÿ�.

b_title -react_board

�ۼ��� ����� �г����� �𸣰ڰ� �̸����� �˰� �ִ�.
sungsim4@example.com - react_board, react_member

�� �߿� ��� ���̺� �г��� �÷��� �ֳ���? - react_member
*/

SELECT nickname FROM react_member
where email =:x;

SELECT nickname FROM react_board;

/*
 �޼ҵ带 �����ϴµ� �����ؾ��� 2������ �ִ�.
 ù°�� ����Ÿ�԰� �� °�� �Ķ���� Ÿ���� �����ؾ� �մϴ�.
 �������� �ۼ��� ���� ����Ÿ�԰� �Ķ���͸� �� ���� �ֽ��ϴ�.

�� ���־� - 
*/
SELECT * FROM react_board
WHERE b_title = '�� ���־�';

SELECT * FROM react_board
WHERE b_title = '�����־�';

SELECT * FROM emp WHERE ename= 'SMITH';

SELECT * FROM emp WHERE ename= 'smith';


SELECT nickname FROM react_member
 WHERE email = 'sungsim4@example.com';
 
SELECT email FROM react_board
 WHERE b_title = '�� ���־�';
 
 
SELECT nickname FROM react_member
 WHERE email = (
                SELECT email FROM react_board
                 WHERE b_title = '�� ���־�' 
               );
 

SELECT nickname FROM react_member
 WHERE email = (
                SELECT email FROM react_board
                 WHERE b_title =:x
               );
 
/*              
2. �Խñ� ����� �������� sql���� �ۼ��Ͻÿ�.
ȭ�� ���Ǽ��� Ȯ���ϴ�
�۹�ȣ, ������, �г���, ��ȸ�������� ����ϴ� ������ �׷��� �ִ�.
b_no, b_title, email�ȵ�, nickname(react_member)
���⿡ �´� �������� �ۼ��Ͻÿ�.
���� ���̺� ���(react_member, react_board) �����ϴ� �͸� ������
*/

SELECT * 
  FROM react_member, react_board;

SELECT * 
  FROM react_member rm, react_board rb
 WHERE rm.email =rb.email;

SELECT rm.nickname, rb.email
  FROM react_member rm, react_board rb
 WHERE rm.email =rb.email
   AND rb.b_title = '�� ���־�';

SELECT rb.B_NO as "�۹�ȣ"
      ,rb.b_title as "����"
      ,rm.nickname as "�ۼ���"
      ,rb.b_hit as "��ȸ��"
  FROM react_member rm, react_board rb
 WHERE rm.email =rb.email
 
   AND rb.b_title = '�� ���־�';