-- member250120�� react_board�� 1�� ���� �����̴�.
-- Natural Join, equal join

select
    rb.b_no, rb.b_title, mem.mem_name, rb.b_date, mem.mem_nickname
    from member250120 mem, react_board rb
    where mem.mem_email = rb.email;
    
SELECT rb.b_no, rb.b_title, rb.b_content, rb.b_hit, rb.b_date, mem.mem_name
    FROM react_board rb, member250120 mem 
    WHERE rb.email = mem.mem_email;

delete from member250120 where mem_no=1;

commit;

select *from member250120;