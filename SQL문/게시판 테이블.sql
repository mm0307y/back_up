 /*상태관리
 쿠키 / 세션
 인증 / 인가
 권한이 있어야 글쓰기를 할 수 있어요.
 회원가입을  하란말이야  -  이름, 아이디대신 이메일, 전화번호
 작성자는 입력받는 값이 아니다.
 로그인을 하면 세션이나 쿠키에 이름, 닉네임, uid, id 을 세션이나 쿠키에서 관리해야 한다. - 보안 사항
 시간동안 유지 된다. 즉, 안써도 된다. 입력받지 않아도 괜찮다.
 작성자는 로그인시에 저장해둔 이름으로 자동처리할 것 - 요구 사항
*/

create table react_member(
    email varchar2(30) constraints react_member_email primary key,
    mem_pw varchar2(10) not null,
    nickname varchar2(30),
    zonecode varchar2(10),
    mem_addr varchar2(100),
    mem_addr2 varchar2(30),
    reg_date varchar2(30)
);

create table react_board(
    b_no number(5) constraints react_board_no primary key,
    b_title varchar2(100) not null,
    email varchar2(30) not null,
    b_content varchar2(4000),
    b_hit number(5) default 0,
    b_date varchar2(20),
    b_file varchar2(200)
);

create table react_board_comment(
    bc_no number(5) constraints react_board_comment_no primary key,
    email varchar2(30),
    bc_comment varchar2(4000),
    bc_date varchar2(20),
    b_no number(5)
);

drop table react_board;

drop table react_board_comment;