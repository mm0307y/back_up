-- react_member ���̺�
INSERT INTO react_member (email, mem_pw, nickname, zonecode, mem_addr, mem_addr2, reg_date)
VALUES ('kosmo@example.com', 'pwd1', '�ڽ���', '12345', '���� ��õ��', '���������2�� 101', '2025-01-01');

INSERT INTO react_member (email, mem_pw, nickname, zonecode, mem_addr, mem_addr2, reg_date)
VALUES ('egane@example.com', 'pwd2', '������', '67890', '�λ�� �߱�', '����1�� 48', '2025-01-02');

INSERT INTO react_member (email, mem_pw, nickname, zonecode, mem_addr, mem_addr2, reg_date)
VALUES ('kintex@example.com', 'pwd3', 'Ų�ؽ�', '11223', '��⵵ ���� �ϻ꼭��', 'Ų�ؽ��� 217-60', '2025-01-03');

INSERT INTO react_member (email, mem_pw, nickname, zonecode, mem_addr, mem_addr2, reg_date)
VALUES ('sungsim4@example.com', 'pwd4', '���ɴ�', '44556', '������ �߱�', '������480���� 15', '2025-01-04');

INSERT INTO react_member (email, mem_pw, nickname, zonecode, mem_addr, mem_addr2, reg_date)
VALUES ('mansuk@example.com', 'pwd5', '�߰���', '77889', '���� ���ʽ�', 'û��ȣ�ݷ� 72', '2025-01-05');

-- react_board ���̺�
INSERT INTO react_board (b_no, b_title, email, b_content, b_hit, b_date, b_file)
VALUES (SEQ_REACTBOARD_NO.NEXTVAL, '���ɴ� ���־�', 'sungsim4@example.com', '����ٰ�Ʈ ���־��!', 0, '2025-01-01', 'file1.jpg');

INSERT INTO react_board (b_no, b_title, email, b_content, b_hit, b_date, b_file)
VALUES (SEQ_REACTBOARD_NO.NEXTVAL, '�� ���־�', 'sungsim4@example.com', '�� ������ ���ƿ�', 0, '2025-01-02', 'file2.jpg');

INSERT INTO react_board (b_no, b_title, email, b_content, b_hit, b_date, b_file)
VALUES (SEQ_REACTBOARD_NO.NEXTVAL, '���۷���', 'kintex@example.com', '�������� ���̳�', 0, '2025-01-03', 'file3.jpg');

INSERT INTO react_board (b_no, b_title, email, b_content, b_hit, b_date, b_file)
VALUES (SEQ_REACTBOARD_NO.NEXTVAL, '�߰��� ���־�', 'mansuk@example.com', '���ʴ� �߰���?', 0, '2025-01-04', 'file4.jpg');

INSERT INTO react_board (b_no, b_title, email, b_content, b_hit, b_date, b_file)
VALUES (SEQ_REACTBOARD_NO.NEXTVAL, '�ڵ� ���ϴ� ��', 'kosmo@example.com', 'GPT�� ����غ���?', 0, '2025-01-05', 'file5.jpg');

-- react_board_comment ���̺�
INSERT INTO react_board_comment (bc_no, email, bc_comment, bc_date, b_no)
VALUES (SEQ_REACTBOARDCOMMENT.NEXTVAL, 'sungsim4@example.com', '���� �� �����մϴ�.', '2025-01-01', 1);

INSERT INTO react_board_comment (bc_no, email, bc_comment, bc_date, b_no)
VALUES (SEQ_REACTBOARDCOMMENT.NEXTVAL, 'sungsim4@example.com', '���� �����ؿ�', '2025-01-02', 1);

INSERT INTO react_board_comment (bc_no, email, bc_comment, bc_date, b_no)
VALUES (SEQ_REACTBOARDCOMMENT.NEXTVAL, 'sungsim4@example.com', '��̷ӳ׿�', '2025-01-03', 2);

INSERT INTO react_board_comment (bc_no, email, bc_comment, bc_date, b_no)
VALUES (SEQ_REACTBOARDCOMMENT.NEXTVAL, 'kosmo@example.com', '������ �ؾ���!', '2025-01-04', 5);

INSERT INTO react_board_comment (bc_no, email, bc_comment, bc_date, b_no)
VALUES (SEQ_REACTBOARDCOMMENT.NEXTVAL, 'kintex@example.com', '���̳� ���� ���ƿ�', '2025-01-05', 3);

select * from react_member;
select * from react_board;
select * from react_board_comment;