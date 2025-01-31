select n_no, n_title, n_content from notice1030;

--테이블에는 커서가 따라 붙는다. 커서를 조작하는 메서드가 필요했다.
--메서드를 다지려면 클래스가 되어야 했다. - 그런데 기능은 사용처에 따라 달라야 한다.
--그러면 인터페이스(디바이스마다 달라서 결정할 수 없으면 추상메서드로 정의할 것) - 다형성 실현

--ResultSet은 커서를 움직이는데 필요한 next(), previous(), isFirst(), isLast() : boolean
--그래서 if문이나 while문이나 for문 괄호안에 쓸 수 있다.
--PreparedStatement - 동적쿼리 <-> 정적쿼리 - Statement
--select -> pstmt.executeQuery ("select문") : resultSet(인터페이스)
--insert, update, delete -> commit, rollback
-- pstmt.exceuteUpdate ("insert문\ update문 \ delete문") : int

-- Restful API - CRUD수업 (입력, 수정, 삭제, 조회) - Model 계층 (데이터 처리 + 비지니스 로직)


--javado문법 (자바에서 사용하는 문법)
insert into dept (deptno, dname, loc) values (50, '총무부', '인천');

commit; 

select * from dept where deptno = 50;


--executeUpdate() : int

update dept
    set dname = '개발부'
     , loc = '제주'
where deptno = 50;

 --executeUpdate (update문 - 처리) : 리턴 타입은 int -> 1개의 로우가 업데이트 되었습니다. (1row updated)

--if (result == 1) 수정에 성공하였습니다. else수정에 실패하였습니다. - 응답

delete from dept where deptno =: x;

select *from dept;


select * from book152;

insert into book152 values (1, '혼자공부하는 파이썬', '윤인성', '한빛미디어', '혼자 해도 충분하다! 1:1 과외하듯 배우는 파이썬 프로그래밍 자습서(파이썬 최신 버전 반영) 이 책은 독학으로 프로그래밍 언어를 처음 배우려는 입문자가, 혹은 파이썬을 배우려는 입문자가 "꼭 필요한 내용을 제대로" 학습할 수 있도록 구성했다. "무엇을", "어떻게" 학습해야 할지조차 모르는 입문자의 막연한 마음을 살펴, 과외 선생님이 알려주듯 친절하게, 그러나 핵심적인 내용만 콕콕 집어준다. 책의 첫 페이지를 펼쳐서 마지막 페이지를 덮을 때까지, 혼자서도 충분히 파이썬을 배울 수 있다는 자신감과 확신이 계속될 것이다!', '1.jpg');

INSERT INTO book152 VALUES(3,'파이썬 머신러닝 완벽가이드','권철민','위키북스','《파이썬 머신러닝 완벽 가이드》는 이론 위주의 머신러닝 책에서 탈피해 다양한 실전 예제를 직접 구현해 보면서 머신러닝을 체득할 수 있도록 만들었습니다. 캐글과 UCI 머신러닝 리포지토리에서 난이도가 있는 실습 데이터를 기반으로 실전 예제를 구성했고, XGBoost, LightGBM, 스태킹 기법 등 캐글의 많은 데이터 사이언스에서 애용하는 최신 알고리즘과 기법에 대해 매우 상세하게 설명했습니다. 이번 개정판에서는 사이킷런 및 기타 라이브러리의 업데이트에 따른 전반적인 내용 및 소스코드 업데이트와 함께 질의 사항이 많은 부분들에 대한 상세한 설명을 추가했습니다.','3.jpg');

INSERT INTO book152 VALUES(4,'책제목','강감찬','정철사','책내용','4.jpg');

INSERT INTO book152 VALUES(5,'책제목5','이순신','정철사','책내용5','5.jpg');

commit;