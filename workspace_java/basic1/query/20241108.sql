select 
            b_no, b_name, b_author, b_publish
from book152
 where b_name like '%' || '��' ||'%';
 
 -- �˻������ ���� ��  NullPointerException �����ϱ�
 
 select 
            b_no, b_name, b_author, b_publish
from book152
 where b_name like '%' || '��' ||'%';
 
 select 
            b_no, b_name, b_author, b_publish
from book152
 where b_author like '%' || '��' ||'%';
 
 select 
            b_no, b_name, b_author, b_publish
from book152
 where b_author like '%' || :keyword ||'%';
 
 select 
            b_no, b_name, b_author, b_publish
from book152
 where b_publish like '%' || :keyword ||'%';