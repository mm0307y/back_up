-- MVC기반 게피산 구현하기
-- 구현할 때 화면붙터 시작해서 백엔드로 마무리하기
-- 백엔드로 시작해서 화면은 나중에 마무리하기
-- 1. 클래스 설계
-- 2. 메서드 설계 (파라미터의 갯수, 리턴타입 결정)
-- DML 구문을 먼저 작성해 보세요.

-- 전체보기
-- 아래는 n건 조회되는 경우 이다. - 리턴타입  결정
-- 메서드 명 : getBoardList() : List<Map> or List<BoardVO> or BoardVO[ ] (배열문은 배제하는 게 맞다 배열은 고정적이기 때문에  사용하기가 힘들다.)
select b_no, b_title, b_writer, b_content, b_hit, b_date
     from mvc_board;

-- 상세보기    
-- 메서드명 : getBoardDetail(b_no), getBoardList(int b_no) 
-- 1. 전체조회 메서드 하나로 두 경우를 모두 처리한다.
-- 2. 전체조회와 상세조회는 불리해야 한다.
-- 두 경우 응답 페이지의 이름이 서로 다르다.
-- 1번을 선택한 사람 : if문 추가 - 한 메서드에 한가지 책임만 진다.
-- 2번을 선택한 사람 : 한가지 책임만 갖는다.

-- 리턴타입은 Map(키값은 중복이 불가하다, 차례가 맞지 않다.) or BoardVO(getter / setter - 캡슐화)를 한다.
select b_no, b_title, b_writer, b_content, b_hit, b_date
    from mvc_board
   where b_no =: u_no;
   
--입력
--하나 더 : select는 커밋이나 롤백의 대상이 아니다.
-- 글쓰기 구현  (입력  - insert문)
-- 컬럼명이 자바에서 변수와 비슷하다. - 하나의 컬럼명에 대해 값이 각기 다르다.
-- 컬럼은 타입이 같지만 값을 서로 다르다. (물론 같을 때도 있다.)
-- @param - Board() or Map
-- @return - int
-- boardInsert (BoardVO od Map) : int
insert into mvc_borad values (seq_mvc_board_no.nextval, '글제목', '작성자', '내용', 0, '2024-11-20'); --1 row inserted

insert into mvc_board values (seq_mvc_board_no.nextval, '글제목1', '작성자1', '내용1', 15, '2024-11-17') ;

insert into mvc_board values (seq_mvc_board_no.nextval, '글제목2', '작성자2', '내용2', 28, '2024-11-18') ;

insert into mvc_board values (seq_mvc_board_no.nextval, '새글제목3', '작성자3', '내용3', 32, '2024-11-19') ;

insert into mvc_board values (seq_mvc_board_no.nextval, '헌글제목4', '작성자4', '내용4', 46, '2024-11-21') ;

insert into mvc_board values (seq_mvc_board_no.nextval, '글제목5', '작성자5', '내용5', 56, '2024-11-22') ;

select *from mvc_board;

commit;

-- 글수정 구현  (수정,  있는 정보중 특정 컬럼을 변경하는 것 - update문)
-- @param - Board() or Map
-- @return - int
-- boardUpdate (BoardVO or Map) : int

-- 전체 주석 처리 : Ctrl + B
-- 전체 주석 해제 : Ctrl + shift + B
update mvc_board
     set b_title =: title
         ,b_content =: content 
         ,b_date = to_char(sysdate, 'YYYY-MM-DD')
     where b_no =: no;
     
select * from mvc_board where b_no = 2;

rollback;

-- 성공이면  1 row updated or 실패하면 0 row updated
-- 이런 리턴값을 초기화 할 때는 1이나 0을 쓰지 않는다.


-- 글삭제 구현  (삭제,  있는 정보 중 특정 컬럼을 삭제하는 것 - delete문)
-- @param - int
-- @return - int
-- boardDelete (BoardVO or Map) : int

delete from mvc_board
     where b_no =: no;
     
select * from mvc_board where b_no = 4;

-- 성공이면 1row deleted or 실패하면 0 row deleted
-- 이런 리턴값을 초기화 할 대는 1이나 0을 쓰지 않는다.
