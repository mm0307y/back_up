select b_no, b_name, b_author, b_publish, b_info, b_img
from book152;

select b_no, b_name, b_author, b_publish, b_info, b_img from book152;

-- 시퀀스 값이 다르기만 하면 나머지 컬럼은 

-- 1 row 이면  bookVO로 받을 수 있다. 학습목표
-- n row 이면 List(ArrayList, Vector)

-- 조건 검색하기

select b_no, b_name, b_author, b_publish, b_info, b_img
from book152
where b_no =:x; 


INSERT INTO book152 VALUES(3,'파이썬 머신러닝 완벽가이드','권철민','위키북스','《파이썬 머신러닝 완벽 가이드》는 이론 위주의 머신러닝 책에서 탈피해 다양한 실전 예제를 직접 구현해 보면서 머신러닝을 체득할 수 있도록 만들었습니다. 캐글과 UCI 머신러닝 리포지토리에서 난이도가 있는 실습 데이터를 기반으로 실전 예제를 구성했고, XGBoost, LightGBM, 스태킹 기법 등 캐글의 많은 데이터 사이언스에서 애용하는 최신 알고리즘과 기법에 대해 매우 상세하게 설명했습니다. 이번 개정판에서는 사이킷런 및 기타 라이브러리의 업데이트에 따른 전반적인 내용 및 소스코드 업데이트와 함께 질의 사항이 많은 부분들에 대한 상세한 설명을 추가했습니다.','3.jpg');

INSERT INTO book152 VALUES(4,'책제목','강감찬','정철사','책내용','4.jpg');


commit;

select seq_book152_no.nextval from dual;

select seq_book152_no.currval from dual;

-- BookVO pbvo -> if(pbvo.getB_no() > 0), if (bvo.getB_no() > 0)가 아니라 앞에 있는 pbvo가 와야한다.
-- bvo는 select한 결과를 담는 클래스이고 pbvo는 화면에서 사용자가 입력한 값을 담는 클래스 이다.
-- 메서드의 파라미터 자리는 사용자가 입력하는 자리이다. - 상수값으로 테스트 할 수 있다면
-- 통합테스트에 참여하지 못하더라도 괜찮아

select comm, nvl (comm, 0) from emp;

select ename, comm from emp
where comm is null;

select ename, comm from emp
where comm is not null;

select ename, comm from emp
order by comm asc;

select ename, comm from emp
order by comm desc;

select * from book152
where b_no in(5,6);