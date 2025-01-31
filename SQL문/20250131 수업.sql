SELECT * FROM react_board
ORDER BY b_no desc;

SELECT * FROM react_board_comment;


SELECT * FROM member250120;

delete from member250120 where mem_no=14;

commit;

INSERT INTO react_board(b_no, b_title, email, b_content, b_hit, b_date)
 VALUES(seq_reactboard_no.nextval, #{b_title}, #{email}
      , #{b_content}, 0, to_char(sysdate, 'YYYY-MM-DD')); 
      
INSERT INTO react_board(b_no, b_title, email, b_content, b_hit, b_date)
 VALUES(seq_reactboard_no.nextval, '������ ����', 'happy@hot.com'
      , '�۳��� ����', 0, to_char(sysdate, 'YYYY-MM-DD'));     
      
SELECT * FROM react_board;      
      
UPDATE react_board
       SET b_title = '������ ����21'
          ,email = 'apple@hot.com'
          ,b_content = '�۳��� ����21' 
WHERE b_no = 7;      
        



SELECT rb.b_no, rb.b_title, rb.b_content, rb.b_hit, rb.b_date, rm.mem_nickname
FROM react_board rb, member250120 rm
WHERE rb.email = rm.mem_email;

SELECT rb.b_no, rb.b_title, rb.email ,rb.b_content, rb.b_hit, rb.b_date
     , rm.mem_nickname
FROM react_board rb, member250120 rm
WHERE rb.email = rm.mem_email;

SELECT bcom.bc_no, bcom.email, bcom.bc_comment, bcom.bc_date
     ,  bcom.b_no, me.mem_nickname
FROM react_board_comment bcom, member250120 me
WHERE bcom.email =  me.mem_email
  AND bcom.b_no = 1;


commit;

SELECT bcom.bc_no, bcom.email, bcom.bc_comment, bcom.bc_date
     ,  bcom.b_no, me.mem_nickname
FROM react_board_comment bcom, member250120 me
WHERE bcom.email =  me.mem_email
  AND bcom.b_no = #{b_no};

--�󼼺��Ⱑ ��ȸ�Ǹ� - 1���� ��ȸ�Ǹ� - bList.size()==1
--����Ʈ�� ũ�Ⱑ 1�̸� �󼼺��Ⱑ �Ǿ���. - b_hit = b_hit + 1

UPDATE react_board
   SET b_hit = b_hit + 1
 WHERE b_no = #{b_no}; 
 
UPDATE react_board
   SET b_hit = b_hit + 1
 WHERE b_no =:x;
 
DELETE FROM react_board
 WHERE b_no = :x; 
 
rollback;
 
 
commit;   

SELECT * FROM react_board WHERE b_no=7;

--Back-End : SELECT , INSERT, UPDATE, DELETE
-- ����: REST API����
--Front-End : �Ķ���� �ѱ��({},[]), ���ϰ� �޾ƿ���(string, json, []) 

-- �鿣�� : �Ѱ���ȸ(select - 1�� ����) + �ѰǾ�����Ʈ(update - b_hit+1)
-- �鿣���������� �ϳ��� ������ ó���ϴµ� �� ���� DML�� �䱸�Ǵ� ��찡 �ִ�.
-- �ϳ��� ������ ó���ϴµ� �������� insert, update, delete�� ��Ƽ�� �ʿ��� ���
-- commit�̳� rollbackó���䱸��Ȳ - Ʈ�����ó��
-- �ϳ��� XXXLogicŬ������ �޼ҵ峻���� XXXDaoŬ������ ���� �޼ҵ带 ȣ���ϴ� ��찡 �ִ�.
-- Ʈ�����ó�� ��� �ĺ�