INSERT INTO notice1030(n_no,n_title, n_writer, n_content, n_date)
VALUES(seq_notice1030.nextval,'공지제목1','치타','공지제목1내용',to_char(sysdate, 'YYYY-MM-DD'));

INSERT INTO notice1030(n_no,n_title, n_writer, n_content, n_date)
VALUES(seq_notice1030.nextval, '공지제목2','호랑이','공지제목2내용',to_char(sysdate, 'YYYY-MM-DD'));

INSERT INTO notice1030(n_no,n_title, n_writer, n_content, n_date)
VALUES(seq_notice1030.nextval,'공지제목3','표범','공지제목3내용',to_char(sysdate, 'YYYY-MM-DD'));

SELECT * FROM notice1030;

commit;