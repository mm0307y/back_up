select *from  notice1030;

create table notice(
    n_no number(13) constraints notice_no_pk primary key,
    n_title varchar(50),
    n_writer varchar(30),
    n_content varchar(500)
);

-- DDL (구조) : create(테이블 생성), alter(테이블 수정), drop(테이블삭제) - 새그먼트 미사용 - 속도가 빠르다.
-- DML (데이터조작어) : select(GET, POST), insert(PUT), update(PUT), delete (Restful API - Delete 함수)
-- 1) commit, rollback - insert, update, delete
-- 2) 해당없음 - select
-- DCL(권한) : grant, reboke - 계정을 추가하기 

insert into notice(n_no, n_title, n_writer, n_content)
values(seq_notice.nextval ,'제목1', '작성자1', '내용1');

insert into notice(n_no,n_title, n_writer, n_content)
values(seq_notice.nextval ,'제목2', '작성자2', '내용2');

insert into notice(n_no,n_title, n_writer, n_content)
values(seq_notice.nextval ,'제목3', '작성자3', '내용3');

commit;

-- 공지사항 목록 보기 (NoticeList.jsx, NoticeItem.jsx)
-- 쿼리문을 작성하면 파라미터를 파악할 수 있고 또한 

select n_no, n_title, n_writer, n_content
from notice; 

--[{n_no:1, ntitle: '제목1', n_writer:'작성자', n_content:'내용' }, {}, {}....]

-- 모든 업무의 시작 페이지는 목록 페이지로 시작한다. -> select
-- 목록페이지에는 글쓰기 버튼이 있다. -> insert
-- 목록에서 제목을 클릭하면 상세페이지로 간다. -> select ... where n_no=:x
-- 상세페이지의 삭제버튼이 있다. -> delete ... where n_no=:x

-- 조건 검색하기 - SQLException에 대해서는 고려하지 않아도 된다. - 시간 절약
select n_no, n_title, n_writer, n_content
from notice
where n_title like '%'||?||'%';

select n_no, n_title, n_writer, n_content
from notice
where n_writer like '%'||?||'%';

select n_no, n_title, n_writer, n_content
from notice
where n_content like '%'||?||'%';

-- 공지사항 상세보기(NoticeDetail.jsx)

select n_no, n_title, n_writer, n_content
from notice
where n_no =:n;
