-- react_member 테이블
INSERT INTO react_member (email, mem_pw, nickname, zonecode, mem_addr, mem_addr2, reg_date)
VALUES ('kosmo@example.com', 'pwd1', '코스모', '12345', '서울 금천구', '가산디지털2로 101', '2025-01-01');

INSERT INTO react_member (email, mem_pw, nickname, zonecode, mem_addr, mem_addr2, reg_date)
VALUES ('egane@example.com', 'pwd2', '떡볶이', '67890', '부산시 중구', '부평1길 48', '2025-01-02');

INSERT INTO react_member (email, mem_pw, nickname, zonecode, mem_addr, mem_addr2, reg_date)
VALUES ('kintex@example.com', 'pwd3', '킨텍스', '11223', '경기도 고양시 일산서구', '킨텍스로 217-60', '2025-01-03');

INSERT INTO react_member (email, mem_pw, nickname, zonecode, mem_addr, mem_addr2, reg_date)
VALUES ('sungsim4@example.com', 'pwd4', '성심당', '44556', '대전시 중구', '대종로480번길 15', '2025-01-04');

INSERT INTO react_member (email, mem_pw, nickname, zonecode, mem_addr, mem_addr2, reg_date)
VALUES ('mansuk@example.com', 'pwd5', '닭강정', '77889', '강원 속초시', '청초호반로 72', '2025-01-05');

-- react_board 테이블
INSERT INTO react_board (b_no, b_title, email, b_content, b_hit, b_date, b_file)
VALUES (SEQ_REACTBOARD_NO.NEXTVAL, '성심당 맛있어', 'sungsim4@example.com', '명란바게트 맛있어요!', 0, '2025-01-01', 'file1.jpg');

INSERT INTO react_board (b_no, b_title, email, b_content, b_hit, b_date, b_file)
VALUES (SEQ_REACTBOARD_NO.NEXTVAL, '빵 맛있어', 'sungsim4@example.com', '빵 가성비가 좋아요', 0, '2025-01-02', 'file2.jpg');

INSERT INTO react_board (b_no, b_title, email, b_content, b_hit, b_date, b_file)
VALUES (SEQ_REACTBOARD_NO.NEXTVAL, '컨퍼런스', 'kintex@example.com', '성공적인 세미나', 0, '2025-01-03', 'file3.jpg');

INSERT INTO react_board (b_no, b_title, email, b_content, b_hit, b_date, b_file)
VALUES (SEQ_REACTBOARD_NO.NEXTVAL, '닭강정 맛있어', 'mansuk@example.com', '속초는 닭강정?', 0, '2025-01-04', 'file4.jpg');

INSERT INTO react_board (b_no, b_title, email, b_content, b_hit, b_date, b_file)
VALUES (SEQ_REACTBOARD_NO.NEXTVAL, '코딩 잘하는 법', 'kosmo@example.com', 'GPT를 사용해볼까?', 0, '2025-01-05', 'file5.jpg');

-- react_board_comment 테이블
INSERT INTO react_board_comment (bc_no, email, bc_comment, bc_date, b_no)
VALUES (SEQ_REACTBOARDCOMMENT.NEXTVAL, 'sungsim4@example.com', '좋은 글 감사합니다.', '2025-01-01', 1);

INSERT INTO react_board_comment (bc_no, email, bc_comment, bc_date, b_no)
VALUES (SEQ_REACTBOARDCOMMENT.NEXTVAL, 'sungsim4@example.com', '공유 감사해요', '2025-01-02', 1);

INSERT INTO react_board_comment (bc_no, email, bc_comment, bc_date, b_no)
VALUES (SEQ_REACTBOARDCOMMENT.NEXTVAL, 'sungsim4@example.com', '흥미롭네요', '2025-01-03', 2);

INSERT INTO react_board_comment (bc_no, email, bc_comment, bc_date, b_no)
VALUES (SEQ_REACTBOARDCOMMENT.NEXTVAL, 'kosmo@example.com', '열심히 해야죠!', '2025-01-04', 5);

INSERT INTO react_board_comment (bc_no, email, bc_comment, bc_date, b_no)
VALUES (SEQ_REACTBOARDCOMMENT.NEXTVAL, 'kintex@example.com', '세미나 내용 좋아요', '2025-01-05', 3);

select * from react_member;
select * from react_board;
select * from react_board_comment;