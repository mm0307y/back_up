/*빵 맛있어 제목의 글을 작성한 사람의 닉네임은 무엇인지 출력하는 sql문을 작성하시오.

b_title -react_board

작성한 사람의 닉네임은 모르겠고 이메일은 알고 있다.
sungsim4@example.com - react_board, react_member

둘 중에 어느 테이블에 닉네임 컬럼이 있나요? - react_member
*/

SELECT nickname FROM react_member
where email =:x;

SELECT nickname FROM react_board;

/*
 메소드를 설계하는데 결정해야할 2가지가 있다.
 첫째는 리턴타입과 둘 째는 파라미터 타입을 결정해야 합니다.
 쿼리문을 작성해 보면 리턴타입과 파라미터를 알 수가 있습니다.

빵 맛있어 - 
*/
SELECT * FROM react_board
WHERE b_title = '빵 맛있어';

SELECT * FROM react_board
WHERE b_title = '빵맛있어';

SELECT * FROM emp WHERE ename= 'SMITH';

SELECT * FROM emp WHERE ename= 'smith';


SELECT nickname FROM react_member
 WHERE email = 'sungsim4@example.com';
 
SELECT email FROM react_board
 WHERE b_title = '빵 맛있어';
 
 
SELECT nickname FROM react_member
 WHERE email = (
                SELECT email FROM react_board
                 WHERE b_title = '빵 맛있어' 
               );
 

SELECT nickname FROM react_member
 WHERE email = (
                SELECT email FROM react_board
                 WHERE b_title =:x
               );
 
/*              
2. 게시글 목록을 가져오는 sql문을 작성하시오.
화면 정의서를 확인하니
글번호, 글제목, 닉네임, 조회수까지만 출력하는 것으로 그려져 있다.
b_no, b_title, email안됨, nickname(react_member)
여기에 맞는 쿼리문을 작성하시오.
양쪽 테이블에 모두(react_member, react_board) 존재하는 것만 보여줘
*/

SELECT * 
  FROM react_member, react_board;

SELECT * 
  FROM react_member rm, react_board rb
 WHERE rm.email =rb.email;

SELECT rm.nickname, rb.email
  FROM react_member rm, react_board rb
 WHERE rm.email =rb.email
   AND rb.b_title = '빵 맛있어';

SELECT rb.B_NO as "글번호"
      ,rb.b_title as "제목"
      ,rm.nickname as "작성자"
      ,rb.b_hit as "조회수"
  FROM react_member rm, react_board rb
 WHERE rm.email =rb.email
 
   AND rb.b_title = '빵 맛있어';