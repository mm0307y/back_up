select 
            b_no, b_name, b_author, b_publish
from book152
 where b_name like '%' || '박' ||'%';
 
 -- 검색결과가 없을 때  NullPointerException 조심하기
 
 select 
            b_no, b_name, b_author, b_publish
from book152
 where b_name like '%' || '파' ||'%';
 
 select 
            b_no, b_name, b_author, b_publish
from book152
 where b_author like '%' || '박' ||'%';
 
 select 
            b_no, b_name, b_author, b_publish
from book152
 where b_author like '%' || :keyword ||'%';
 
 select 
            b_no, b_name, b_author, b_publish
from book152
 where b_publish like '%' || :keyword ||'%';