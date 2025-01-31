package com_10_28.util_10_28;

import java.sql.*;

/*공통코드 적성해 보기 - 공통팀(브레인), 품질관리팀(QC), 형상관리팀(git버전관리, 개발 가이드문서, 개발환경설정)
반복되는 코드는 줄이기.
메서드는 슬림(양이 적게)하게 하나의 책임만 진다. - 재사용성이 좋다.
DB서버는 하나이고 하나의 서버를 여러 개발자들이 바라본다.
하나의 객체를 가지고 공유하자(싱글톤패턴 - Spring지원- 프레임워크)
클래스 선언에 static 붙인다. - 얕은 복사 - 원본이 하나다.
이것이 가능한가? - 스레드(싱글 스레드, 멀티 스레드)*/

public class DBConnectionMgr_10_28 {
    /*서버(정보제공측) - 클라이언트(제공된 정보를 활용한다) - 2-tier
    서버 - 미들웨어서버 - 클라이언트 - 3-tier, 4개 이상은 multi-tier 이다.
    java.sql.* 혹은 javax.sql* 참조해야 한다.
    모두 인터페이스 이다. (Connection, PrepareStatement, ResultSet) - 결정할 수 없다.
    왜요? 디바이스 마다 각각 다르게 동작해야 한다. - 결정할 수 없다. - 구현체 클래스가 한다.
    아래 인터페이스는 모두 메서드로 객체를 생성한다.*/
    static DBConnectionMgr_10_28 dbMgr = null;
    Connection con;
    PreparedStatement pstmt; //동적퀴리 같은 쿼리문을 묶는 코드이다.
    ResultSet rs; //Cursor를 조작하는 API를 제공한다. 누가 - 자바

    public final static String _DRIVER = "oracle.jdbc.driver.OracleDriver";
    public final static String _URL = "jdbc:oracle:thin:@localhost:1521:orcl11";
    public final static String _USER = "scott";
    public final static String _PW = "tiger";

    public DBConnectionMgr_10_28(){}
    //메서드를 활용하여 객체를 생성하기 - 세련된 코드
    //선택(if문 - 조건문)적으로 객체를 생성한다.
    public static DBConnectionMgr_10_28 getInstance(){
        if (dbMgr == null){ //if문의 조건절에서 null을 체크 할 수 있다.
            dbMgr = new DBConnectionMgr_10_28();
        }
        return dbMgr;
    }
    public Connection getConnection(){
        try{
            Class.forName(_DRIVER);
            con = DriverManager.getConnection(_URL, _USER, _PW);
        } catch (Exception e) {

        }
        return con;
    }

    /*사용한 자원 반납하기 - 이종간에 연계하는 코드 작성
    사용한 자원을 받을때는 생성된 역순으로 닫는다.
    생략하면 JVM의 가비지컬렉터가 대신 해준다. - 그러나 명시적으로 구현하는 것을 권장한다.
    JDBC API - 순수한 코드를 -> MyBatis사용 -> Hibernate
    Insert, update, delete -> Connection, PreparedStatement
    select -> Connection, PreparedStatement, ResultSet*/
    public void freeConnection(Connection con, PreparedStatement pstmt, ResultSet rs){
        try{
            if (rs != null){rs.close();}
            if (pstmt != null){pstmt.close();}
            if (con != null){con.close();}
        }
        catch (SQLException e) {

        }
    }

    public void freeConnection(Connection con, PreparedStatement pstm){
        try{
            if (pstmt != null){pstmt.close();}
            if (con != null){con.close();}
        }
        catch (SQLException e) {

        }
    }
}
