create table talk_friend(
        f_no number(5) constraints friend_no_pk primary key,
        f_id varchar2(10),
        mem_id varchar2(10),
        replationship varchar2(100),
        f_date varchar2(20),
        f_yn varchar2(1)
)

edit talk_member;

edit talk_friend;

select
        mem.mem_id, fri.f_id, fri.relationship
    from talk_member mem, talk_friend fri
    where mem.mem_id = fri.mem_id;
    
select
        mem.mem_id, fri.f_id, fri.relationship, mem.mem_name
    from talk_member mem, talk_friend fri
    where mem.mem_id = fri.mem_id
    and mem.mem_id = 'kiwi';

select
        mem.mem_id, fri.f_id, fri.relationship, mem.mem_name
    from talk_member mem, talk_friend fri
    where mem.mem_id = fri.mem_id
    and mem.mem_id = 'kiwi';
    
select
        mem.mem_id, fri.f_id, fri.relationship
        , mem.mem_name as "내이름" ,  '친구이름' as "친구이름"
    from talk_member mem, talk_friend fri
    where mem.mem_id = fri.mem_id
    and mem.mem_id = 'kiwi';
    
select
        mem.mem_id, fri.f_id, fri.relationship
        , mem.mem_name as "내이름" ,  mem.mem_nam as "친구이름"
    from talk_member mem, talk_friend fri
    where mem.mem_id = fri.mem_id
    and mem.mem_id = 'kiwi';
    
select
        mem.mem_id, fri.f_id, fri.relationship
        , mem.mem_name as "내이름" ,  mem1.mem_name as "친구이름"
    from talk_member mem, talk_friend fri, talk_member mem1
    where mem.mem_id = fri.mem_id
    and fri.f_id = mem1. mem_id
    and mem.mem_id = 'kiwi';
    
select
        mem.mem_id, fri.f_id, fri.relationship, mem.status_msg
        , mem.mem_name as "내이름" ,  mem1.mem_name as "친구이름"
    from talk_member mem, talk_friend fri, talk_member mem1
    where mem.mem_id = fri.mem_id
    and fri.f_id = mem1. mem_id
    and mem.mem_id = 'kiwi';

select
        mem.mem_id, fri.f_id, fri.relationship, mem.status_msg as "내상태메시지"
        , mem1.status_msg as "친구의 상태메시지"
        , mem.mem_name as "내이름" ,  mem1.mem_name as "친구이름"
    from talk_member mem, talk_friend fri, talk_member mem1
    where mem.mem_id = fri.mem_id
    and fri.f_id = mem1. mem_id
    and mem.mem_id = 'kiwi';
    
select
        mem.mem_id, fri.f_id, fri.relationship, mem.status_msg as "내상태메시지"
        , mem1.status_msg as "친구의 상태메시지"
        , mem.mem_name as "내이름" ,  mem1.mem_name as "친구이름"
    from talk_member mem, talk_friend fri, talk_member mem1
    where mem.mem_id = fri.mem_id
    and fri.f_id = mem1. mem_id
    and mem.mem_id = 'tiger';
    
select
        mem.mem_id, fri.f_id, fri.relationship, mem.status_msg as "내상태메시지"
        , mem1.status_msg as "친구의 상태메시지"
        , mem.mem_name as "내이름" ,  mem1.mem_name as "친구이름"
    from talk_member mem, talk_friend fri, talk_member mem1
    where mem.mem_id = fri.mem_id
    and fri.f_id = mem1. mem_id;