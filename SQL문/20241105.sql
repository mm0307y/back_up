select b_no, b_name, b_author, b_publish, b_info, b_img
from book152;

select b_no, b_name, b_author, b_publish, b_info, b_img from book152;

-- ������ ���� �ٸ��⸸ �ϸ� ������ �÷��� 

-- 1 row �̸�  bookVO�� ���� �� �ִ�. �н���ǥ
-- n row �̸� List(ArrayList, Vector)

-- ���� �˻��ϱ�

select b_no, b_name, b_author, b_publish, b_info, b_img
from book152
where b_no =:x; 


INSERT INTO book152 VALUES(3,'���̽� �ӽŷ��� �Ϻ����̵�','��ö��','��Ű�Ͻ�','�����̽� �ӽŷ��� �Ϻ� ���̵塷�� �̷� ������ �ӽŷ��� å���� Ż���� �پ��� ���� ������ ���� ������ ���鼭 �ӽŷ����� ü���� �� �ֵ��� ��������ϴ�. ĳ�۰� UCI �ӽŷ��� �������丮���� ���̵��� �ִ� �ǽ� �����͸� ������� ���� ������ �����߰�, XGBoost, LightGBM, ����ŷ ��� �� ĳ���� ���� ������ ���̾𽺿��� �ֿ��ϴ� �ֽ� �˰���� ����� ���� �ſ� ���ϰ� �����߽��ϴ�. �̹� �����ǿ����� ����Ŷ�� �� ��Ÿ ���̺귯���� ������Ʈ�� ���� �������� ���� �� �ҽ��ڵ� ������Ʈ�� �Բ� ���� ������ ���� �κе鿡 ���� ���� ������ �߰��߽��ϴ�.','3.jpg');

INSERT INTO book152 VALUES(4,'å����','������','��ö��','å����','4.jpg');


commit;

select seq_book152_no.nextval from dual;

select seq_book152_no.currval from dual;

-- BookVO pbvo -> if(pbvo.getB_no() > 0), if (bvo.getB_no() > 0)�� �ƴ϶� �տ� �ִ� pbvo�� �;��Ѵ�.
-- bvo�� select�� ����� ��� Ŭ�����̰� pbvo�� ȭ�鿡�� ����ڰ� �Է��� ���� ��� Ŭ���� �̴�.
-- �޼����� �Ķ���� �ڸ��� ����ڰ� �Է��ϴ� �ڸ��̴�. - ��������� �׽�Ʈ �� �� �ִٸ�
-- �����׽�Ʈ�� �������� ���ϴ��� ������

select comm, nvl (comm, 0) from emp;

select ename, comm from emp
where comm is null;

select ename, comm from emp
where comm is not null;

select ename, comm from emp
order by comm asc;

select ename, comm from emp
order by comm desc;

select * from book152
where b_no in(5,6);