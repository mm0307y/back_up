INSERT INTO notice1030(n_no,n_title, n_writer, n_content, n_date)
VALUES(seq_notice1030.nextval,'��������1','ġŸ','��������1����',to_char(sysdate, 'YYYY-MM-DD'));

INSERT INTO notice1030(n_no,n_title, n_writer, n_content, n_date)
VALUES(seq_notice1030.nextval, '��������2','ȣ����','��������2����',to_char(sysdate, 'YYYY-MM-DD'));

INSERT INTO notice1030(n_no,n_title, n_writer, n_content, n_date)
VALUES(seq_notice1030.nextval,'��������3','ǥ��','��������3����',to_char(sysdate, 'YYYY-MM-DD'));

SELECT * FROM notice1030;

commit;