select *from talk_member;

-- �մ�(����Ʈ�ص�)���� �޴�(��ص�)����
-- �޴ܿ��� �մ����� - ȭ���� ȥ�ڼ� �����ϴ�. �޴��� ��������Ѵ�.

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