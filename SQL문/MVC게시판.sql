-- MVC��� ���ǻ� �����ϱ�
-- ������ �� ȭ����� �����ؼ� �鿣��� �������ϱ�
-- �鿣��� �����ؼ� ȭ���� ���߿� �������ϱ�
-- 1. Ŭ���� ����
-- 2. �޼��� ���� (�Ķ������ ����, ����Ÿ�� ����)
-- DML ������ ���� �ۼ��� ������.

-- ��ü����
-- �Ʒ��� n�� ��ȸ�Ǵ� ��� �̴�. - ����Ÿ��  ����
-- �޼��� �� : getBoardList() : List<Map> or List<BoardVO> or BoardVO[ ] (�迭���� �����ϴ� �� �´� �迭�� �������̱� ������  ����ϱⰡ �����.)
select b_no, b_title, b_writer, b_content, b_hit, b_date
     from mvc_board;

-- �󼼺���    
-- �޼���� : getBoardDetail(b_no), getBoardList(int b_no) 
-- 1. ��ü��ȸ �޼��� �ϳ��� �� ��츦 ��� ó���Ѵ�.
-- 2. ��ü��ȸ�� ����ȸ�� �Ҹ��ؾ� �Ѵ�.
-- �� ��� ���� �������� �̸��� ���� �ٸ���.
-- 1���� ������ ��� : if�� �߰� - �� �޼��忡 �Ѱ��� å�Ӹ� ����.
-- 2���� ������ ��� : �Ѱ��� å�Ӹ� ���´�.

-- ����Ÿ���� Map(Ű���� �ߺ��� �Ұ��ϴ�, ���ʰ� ���� �ʴ�.) or BoardVO(getter / setter - ĸ��ȭ)�� �Ѵ�.
select b_no, b_title, b_writer, b_content, b_hit, b_date
    from mvc_board
   where b_no =: u_no;
   
--�Է�
--�ϳ� �� : select�� Ŀ���̳� �ѹ��� ����� �ƴϴ�.
-- �۾��� ����  (�Է�  - insert��)
-- �÷����� �ڹٿ��� ������ ����ϴ�. - �ϳ��� �÷��� ���� ���� ���� �ٸ���.
-- �÷��� Ÿ���� ������ ���� ���� �ٸ���. (���� ���� ���� �ִ�.)
-- @param - Board() or Map
-- @return - int
-- boardInsert (BoardVO od Map) : int
insert into mvc_borad values (seq_mvc_board_no.nextval, '������', '�ۼ���', '����', 0, '2024-11-20'); --1 row inserted

insert into mvc_board values (seq_mvc_board_no.nextval, '������1', '�ۼ���1', '����1', 15, '2024-11-17') ;

insert into mvc_board values (seq_mvc_board_no.nextval, '������2', '�ۼ���2', '����2', 28, '2024-11-18') ;

insert into mvc_board values (seq_mvc_board_no.nextval, '��������3', '�ۼ���3', '����3', 32, '2024-11-19') ;

insert into mvc_board values (seq_mvc_board_no.nextval, '�������4', '�ۼ���4', '����4', 46, '2024-11-21') ;

insert into mvc_board values (seq_mvc_board_no.nextval, '������5', '�ۼ���5', '����5', 56, '2024-11-22') ;

select *from mvc_board;

commit;

-- �ۼ��� ����  (����,  �ִ� ������ Ư�� �÷��� �����ϴ� �� - update��)
-- @param - Board() or Map
-- @return - int
-- boardUpdate (BoardVO or Map) : int

-- ��ü �ּ� ó�� : Ctrl + B
-- ��ü �ּ� ���� : Ctrl + shift + B
update mvc_board
     set b_title =: title
         ,b_content =: content 
         ,b_date = to_char(sysdate, 'YYYY-MM-DD')
     where b_no =: no;
     
select * from mvc_board where b_no = 2;

rollback;

-- �����̸�  1 row updated or �����ϸ� 0 row updated
-- �̷� ���ϰ��� �ʱ�ȭ �� ���� 1�̳� 0�� ���� �ʴ´�.


-- �ۻ��� ����  (����,  �ִ� ���� �� Ư�� �÷��� �����ϴ� �� - delete��)
-- @param - int
-- @return - int
-- boardDelete (BoardVO or Map) : int

delete from mvc_board
     where b_no =: no;
     
select * from mvc_board where b_no = 4;

-- �����̸� 1row deleted or �����ϸ� 0 row deleted
-- �̷� ���ϰ��� �ʱ�ȭ �� ��� 1�̳� 0�� ���� �ʴ´�.
