select *from talk_member;

-- 앞단(프로트앤드)에서 뒷단(백앤드)으로
-- 뒷단에서 앞단으로 - 화면은 혼자서 가능하다. 뒷단은 물어봐야한다.

select
            mem_id
    from talk_member
    where mem_name =: n
       and mem_hp =: h; 
       
       
select
            mem_pw
    from talk_member
    where mem_id =: u
       and mem_name =: n; 