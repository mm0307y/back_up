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


commit;