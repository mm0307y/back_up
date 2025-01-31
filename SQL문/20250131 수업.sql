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
 VALUES(seq_reactboard_no.nextval, '글제목 연습', 'happy@hot.com'
      , '글내용 연습', 0, to_char(sysdate, 'YYYY-MM-DD'));     
      
SELECT * FROM react_board;      
      
UPDATE react_board
       SET b_title = '글제목 연습21'
          ,email = 'apple@hot.com'
          ,b_content = '글내용 연습21' 
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

--상세보기가 조회되면 - 1건이 조회되면 - bList.size()==1
--리스트의 크기가 1이면 상세보기가 되었음. - b_hit = b_hit + 1

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
-- 공통: REST API이해
--Front-End : 파라미터 넘기기({},[]), 리턴값 받아오기(string, json, []) 

-- 백엔드 : 한건조회(select - 1건 성공) + 한건업데이트(update - b_hit+1)
-- 백엔드측에서는 하나의 업무를 처리하는데 두 개의 DML이 요구되는 경우가 있다.
-- 하나의 업무를 처리하는데 여러개의 insert, update, delete가 멀티로 필요한 경우
-- commit이나 rollback처리요구상황 - 트랜잭션처리
-- 하나의 XXXLogic클래스의 메소드내에서 XXXDao클래스의 여러 메소드를 호출하는 경우가 있다.
-- 트랜잭션처리 대상 후보