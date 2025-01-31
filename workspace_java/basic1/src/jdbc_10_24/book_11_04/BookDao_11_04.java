package jdbc_10_24.book_11_04;
//MVC패턴 - 데이터관련된 것은 Model 계층 입니다. - CRUD 작업입니다.
//select, insert, update, delete

import com_10_28.util_10_28.DBConnectionMgr_10_28;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookDao_11_04 {
    //Spring 프레임 워크가 기본적으로 객체 라이프사이클 관리하는 메커니즘
    DBConnectionMgr_10_28 dbMgr = DBConnectionMgr_10_28.getInstance();
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    /**************************************************************************
     * 도서 목록 조회 및 상세조회 구현
     * 조건문
     *  select b_no, b_name, b_author, b_publish, b_info, b_img
     *     from book152
     *     where b_no = ? //1건 조회하기
     *
     * select b_no, b_name, b_author, b_publish, b_info, b_img
     *   from book152 //전체 조회
     *
     * @param pbvo
     * @return List<BookVO> : BookVo가 한건만 담을 수 있다.
     * 한 건이면 bList.size() = 1이면 한 건이다.
     * bList.size() > 1이면 여러건이다.
    **************************************************************************/

    public List<BookVO_11_04> getBookList(BookVO_11_04 pbvo){
//        System.out.println("getBookList 호출 성공 : " + pbvo.getB_no());
        List<BookVO_11_04> bList = new ArrayList<>();
        System.out.println(bList.size()); //0
        StringBuilder sql = new StringBuilder();
        sql.append("select b_no, b_name, b_author, b_publish, b_info, b_img");
        sql.append(" from book152");

        if (pbvo.getB_no() > 0){
            sql.append(" where b_no = ?");
        }
        //gubun null이 아니고 그리고 동시에 "b_name".equals(gubun)
        else if (pbvo !=null && "b_name".equals(pbvo.getGubun())){
            sql.append(" where b_name like '%'||?||'%'");
        }
        else if (pbvo !=null && "b_author".equals(pbvo.getGubun())){
            sql.append(" where b_author like '%'||?||'%'");
        }
        else if (pbvo !=null && "b_publish".equals(pbvo.getGubun())){
            sql.append(" where b_publish like '%'||?||'%'");
        }
        else {
            sql.append(" order by b_no desc");
        }

        try {
            conn = dbMgr.getConnection();
            pstmt = conn.prepareStatement(sql.toString());

            if (pbvo.getB_no() > 0) {
                pstmt.setInt(1, pbvo.getB_no());
            }

            else if (pbvo !=null && "b_name".equals(pbvo.getGubun())) {
                pstmt.setString(1, pbvo.getKeyword());
            }
            else if (pbvo !=null && "b_author".equals(pbvo.getGubun())) {
                pstmt.setString(1, pbvo.getKeyword());
            }
            else if (pbvo !=null && "b_publish".equals(pbvo.getGubun())) {
                pstmt.setString(1, pbvo.getKeyword());
            }
            rs = pstmt.executeQuery();
            BookVO_11_04 bvo = null;
            while(rs.next()){
                bvo = new BookVO_11_04();
                bvo.setB_no(rs.getInt("b_no"));//도서일련변호
                bvo.setB_name(rs.getString("b_name"));//도서명
                bvo.setB_author(rs.getString("b_author"));//저자
                bvo.setB_publish(rs.getString("b_publish"));//출판사
                bvo.setB_info(rs.getString("b_info"));//도서소개
                bvo.setB_img(rs.getString("b_img"));//도서이미지
                bList.add(bvo);
            }
        }
        catch (SQLException se) {
            System.out.println(sql.toString());
        }
        catch (Exception e){
            e.printStackTrace();
        }finally { //예외가 발생하더라도 무조건 실행된다.
            //사용한 자원 반납하기 - 생선된 역순으로 해준다.
            //생략하면 처리는 되지만 명시적으로 처리하는 것이다.
            dbMgr.freeConnection(conn, pstmt, rs);
        }
        return bList;
    }

    /**************************************************************************
     * 도서삭제 구현하기
     * Delete from book152 where b_no = ? //쿼리문을 보고 리턴값과 파라미터 값을 정한다.
     * @param b_no
     * @return int -1이면 삭제성공, 0이면 실패
    ****************************************************************************/
    
    public int bookDelete(int b_no){
        int result = -1; //1이면 삭제 성공, 0이면 삭제 실패, 그래서 초기값을 -1로 한다.
        StringBuilder sql = new StringBuilder();
        sql.append("delete from book152 where b_no = ?");
        try{
            conn = dbMgr.getConnection();
            pstmt = conn.prepareStatement(sql.toString());
            pstmt.setInt(1, b_no);
            result = pstmt.executeUpdate();
        }
        catch (SQLException e) {
            //쿼리문에 부적합한 식별자(컬러명 오타), 테이블이나 뷰(오브젝트 - select문 - 금융) 이름이 없습니다.
            System.out.println(sql.toString());
        }
        catch (Exception e){
            e.printStackTrace();//에러메시지도 stack에 히스토리를 가진다. 출력한다.
        }
        finally {
            dbMgr.freeConnection(conn, pstmt);
        }

        return result; //성공이면 1, 실패하면 0
    }
    /*****************************************************************************
     * 도서 정보 수정하기
     * UPDATE book152
     *  set b_name = ?
     *     ,b_author = ?
     *     ,b_publish = ?
     * @param bvo
     * @return 1이면 수정 성공, 0이면 수정 실패
     * 하나의 클래스에 여러개의 변수를 넘길 수 있다.
     ****************************************************************************/

    public int bookUpdate(BookVO_11_04 bvo){
        int result = -1;//1이면 수정 성공, 0이면 수정 실패, 그래서 초기값을 -1로 함
        StringBuilder sql = new StringBuilder();
        sql.append("UPDATE book152");
        sql.append("       SET b_name = ?");
        sql.append("            , b_author = ?");
        sql.append("            , b_publish = ?");
        sql.append("  WHERE b_no = ?");
        try {
            conn = dbMgr.getConnection();
            //update, insert, delete 등 하자마자 즉시 커밋이 발동한다.
            //conn.setAutoCommit(false); //생략할 수 있다. true가 디폴트 값 이다.
            pstmt = conn.prepareStatement(sql.toString());
            pstmt.setString(1, bvo.getB_name());
            pstmt.setString(2, bvo.getB_author());
            pstmt.setString(3, bvo.getB_publish());
            pstmt.setInt(4, bvo.getB_no());
            result = pstmt.executeUpdate();
        }
        catch (Exception e) {
            System.out.println(sql.toString());
        }
        finally { //사용한 자원을 회수하는 코드
            dbMgr.freeConnection(conn, pstmt);
        }


        return result;
    }

    public int bookUpdate(int b_no, String b_name, String b_author, String b_publish){
        return 1;
    }

    /*****************************************************************************
     * 도서 정보 찾기
     * Insert book152
     * select b_no = ?
     *       ,b_name = ?
     *
     * @param bvo
     * @return
     ****************************************************************************/

    public int bookInsert(BookVO_11_04 bvo){
        System.out.println("bookInsert 호출 성공");
        int result = -1; //1이면 입력 성공, 0이면 입력 실패, 그래서 초기값을 -1로 한다.
        StringBuilder sql = new StringBuilder();
        sql.append("insert into book152 values(seq_book152_no.nextval,?,?,?,?,?)");
        int i = 1;
        try{
            conn = dbMgr.getConnection();
            pstmt = conn.prepareStatement(sql.toString());
            //? 자리를 채우는 값을 설정할 때는 1번 부터 입니다.
            //컬럼이 추가되거나 컬럼의 순서가 바뀌면 숫자를 일일이 바꿔어야 하니까
            //번호 대신에 변수로 처리 합니다. - 후위 연산자 - 먼저 대입 나중에 증가
            //변수 i의 초기값이 0이면 ++i가 맞고 초기값을 1로 하면 i++이 맞다.
            pstmt.setString(i++, bvo.getB_name()); //책 제목
            pstmt.setString(i++, bvo.getB_author()); //저자
            pstmt.setString(i++, bvo.getB_publish()); //출판사
            pstmt.setString(i++, bvo.getB_info()); //책 소개
            pstmt.setString(i++, bvo.getB_img()); //책 이미지
            result = pstmt.executeUpdate();
        }
        catch (SQLException se){
            System.out.println(sql.toString());
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }
        return result;
    }
}