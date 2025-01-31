-- dual:오라클에서 제공하는 로우 1개 컬럼 1개를 갖는 가상 테이블 이름 입니다.

SELECT sysdate FROM dual;

SELECT to_char(sysdate, 'YYYY-MM-DD')
      ,to_char(sysdate, 'YYYY-MM-DD HH:MI:SS AM')
  FROM dual;
  
SELECT 1, 2, 3 FROM dual;

SELECT 1 FROM dual
UNION ALL
SELECT 2 FROM dual
UNION ALL
SELECT 3 FROM dual;

SELECT seq_notice1030.nextval FROM dual;

INSERT INTO notice1030(n_title, n_writer, n_content, n_date)
VALUES('공지제목1','치타','공지제목1내용',to_char(sysdate, 'YYYY-MM-DD'));
