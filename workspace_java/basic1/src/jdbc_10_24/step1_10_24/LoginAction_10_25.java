package jdbc_10_24.step1_10_24;

import oracle.jdbc.OracleConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/*
select mem_nick, mem_name
        from tomato_member
        where mem_id =: user  - 파라미터 String - varchar2(10)
            and mem_pu =: user; - 파라미터 String - varchar2(10)
*/
public class LoginAction_10_25 {
    Connection con; //물리적으로 떨어져 있는 오라클 서버와 연결통로를 확보하는 코드
    Statement stmt; //위에서 연결된 경로를 쿼리문을 전달하기와 처리 요청하기에 대한 메서드가 있다.
    ResultSet rs; //오라클에 작동되는 커서를 구현한 인터페이스 이다.
    //파라미터의 갯수와 타입, 그리고 리턴 타입까지 선택할 수 있어야
    //나는 메서드를 결계할 수 있다..
    public void login(String user_id, String user_pw) {
        StringBuilder sql = new StringBuilder();
        sql.append("select mem_nick, mem_name");
        sql.append(" from tomato_member");
        sql.append(" where mem_id = '" + user_id +"' " );
        sql.append(" and mem_pw = '" + user_pw + "'");
        try{
            Class.forName(OracleConnection_10_24._DRIVER);
            con = DriverManager.getConnection(OracleConnection_10_24._URL, OracleConnection_10_24._USER, OracleConnection_10_24._PW);
            stmt = con.createStatement();
            rs = stmt.executeQuery(sql.toString());
            if (rs.next()){
                System.out.println(rs.getString(1) + ", " + rs.getString(2));
            }
            else {
                System.out.println("입력하신 아이디나 혹은 비밀번호가 맞지 않습니다.");
            }
        } catch (Exception e) {
            System.out.println(sql.toString());
            System.out.println(e.toString());
            throw new RuntimeException(e);
        }

    }
    public static void main(String[] args) {
        LoginAction_10_25 login = new LoginAction_10_25();
        login.login("apple", "123");
    }

}
