 /*���°���
 ��Ű / ����
 ���� / �ΰ�
 ������ �־�� �۾��⸦ �� �� �־��.
 ȸ��������  �϶����̾�  -  �̸�, ���̵��� �̸���, ��ȭ��ȣ
 �ۼ��ڴ� �Է¹޴� ���� �ƴϴ�.
 �α����� �ϸ� �����̳� ��Ű�� �̸�, �г���, uid, id �� �����̳� ��Ű���� �����ؾ� �Ѵ�. - ���� ����
 �ð����� ���� �ȴ�. ��, �Ƚᵵ �ȴ�. �Է¹��� �ʾƵ� ������.
 �ۼ��ڴ� �α��νÿ� �����ص� �̸����� �ڵ�ó���� �� - �䱸 ����
*/

create table react_member(
    email varchar2(30) constraints react_member_email primary key,
    mem_pw varchar2(10) not null,
    nickname varchar2(30),
    zonecode varchar2(10),
    mem_addr varchar2(100),
    mem_addr2 varchar2(30),
    reg_date varchar2(30)
);

create table react_board(
    b_no number(5) constraints react_board_no primary key,
    b_title varchar2(100) not null,
    email varchar2(30) not null,
    b_content varchar2(4000),
    b_hit number(5) default 0,
    b_date varchar2(20),
    b_file varchar2(200)
);

create table react_board_comment(
    bc_no number(5) constraints react_board_comment_no primary key,
    email varchar2(30),
    bc_comment varchar2(4000),
    bc_date varchar2(20),
    b_no number(5)
);

drop table react_board;

drop table react_board_comment;