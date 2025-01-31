CREATE database webdb character set utf8 default collate utf8mb3_general_ci;

use webdb; #(데이터베이스 이름)

# int타입은 최대 10자리까지만 담을 수 있다.
# n_no: Date.now() -> 13자리 값 -> bigint로 사용할 것

# 테이블을 삭제할 때 DDL()
drop table notice;

create table notice(
    n_no bigint auto_increment primary key,
    n_title varchar(50),
    n_writer varchar(30),
    n_content varchar(500)
);

insert into notice(n_title, n_writer, n_content)
values('제목1', '작성자1', '내용1');

insert into notice(n_title, n_writer, n_content)
values('제목12', '작성자12', '내용12');

insert into notice(n_title, n_writer, n_content)
values('제목3', '작성자3', '내용3');

commit;

select n_no, n_title, n_writer, n_content
  from notice;

select n_no, n_title, n_writer, n_content
  from notice
where n_title like '%52%';

delete from notice 
where n_no = 2100;
  
delete from notice;

update notice
	set n_title = ?
	   ,n_writer = ?
	   ,n_content = ?
where n_no = ?;

rollback;

commit;

create table react_board(
	b_no int auto_increment primary key,
	b_title varchar(100),
	b_writer varchar(30),
	n_content text,
	b_hit int default 0,
	b_date varchar(20)
)

select * from react_board;

insert into react_board(b_title, b_writer, b_content, b_date)
values('제목1', '작성자1', '내용1', curdate());

insert into react_board(b_title, b_writer, b_content, b_date)
values('제목2', '작성자2', '내용2', curdate());

insert into react_board(b_title, b_writer, b_content, b_date)
values('제목3', '작성자3', '내용3', curdate());

commit;




