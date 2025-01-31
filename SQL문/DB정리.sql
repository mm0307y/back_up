select *from  notice1030;

create table notice(
    n_no number(13) constraints notice_no_pk primary key,
    n_title varchar(50),
    n_writer varchar(30),
    n_content varchar(500)
);

-- DDL (����) : create(���̺� ����), alter(���̺� ����), drop(���̺����) - ���׸�Ʈ �̻�� - �ӵ��� ������.
-- DML (���������۾�) : select(GET, POST), insert(PUT), update(PUT), delete (Restful API - Delete �Լ�)
-- 1) commit, rollback - insert, update, delete
-- 2) �ش���� - select
-- DCL(����) : grant, reboke - ������ �߰��ϱ� 

insert into notice(n_no, n_title, n_writer, n_content)
values(seq_notice.nextval ,'����1', '�ۼ���1', '����1');

insert into notice(n_no,n_title, n_writer, n_content)
values(seq_notice.nextval ,'����2', '�ۼ���2', '����2');

insert into notice(n_no,n_title, n_writer, n_content)
values(seq_notice.nextval ,'����3', '�ۼ���3', '����3');

commit;

-- �������� ��� ���� (NoticeList.jsx, NoticeItem.jsx)
-- �������� �ۼ��ϸ� �Ķ���͸� �ľ��� �� �ְ� ���� 

select n_no, n_title, n_writer, n_content
from notice; 

--[{n_no:1, ntitle: '����1', n_writer:'�ۼ���', n_content:'����' }, {}, {}....]

-- ��� ������ ���� �������� ��� �������� �����Ѵ�. -> select
-- ������������� �۾��� ��ư�� �ִ�. -> insert
-- ��Ͽ��� ������ Ŭ���ϸ� ���������� ����. -> select ... where n_no=:x
-- ���������� ������ư�� �ִ�. -> delete ... where n_no=:x

-- ���� �˻��ϱ� - SQLException�� ���ؼ��� ������� �ʾƵ� �ȴ�. - �ð� ����
select n_no, n_title, n_writer, n_content
from notice
where n_title like '%'||?||'%';

select n_no, n_title, n_writer, n_content
from notice
where n_writer like '%'||?||'%';

select n_no, n_title, n_writer, n_content
from notice
where n_content like '%'||?||'%';

-- �������� �󼼺���(NoticeDetail.jsx)

select n_no, n_title, n_writer, n_content
from notice
where n_no =:n;
