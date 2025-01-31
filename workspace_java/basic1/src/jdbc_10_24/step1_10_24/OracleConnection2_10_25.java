package jdbc_10_24.step1_10_24;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class OracleConnection2_10_25 {
    //드라이버 클래스를 메모리에 올린다. - 제조사로 부터 제공되는 클래스다.
    public static final String _DRIVER = "oracle.jdbc.driver.OracleDriver";
    //물리적으로 떨어져 있는 오라클 서버읭 드라이버 이름과 IP주소, 포트번호, SID이름
    //thin방식 - 멀티티어에서 사용한다, 동시에 많은 사람이 접속할 때 사용한다, oic방식
    public static final String _URL = "jdbc:oracle:thin:@192.168.0.13:1521:orcl11"; //192.168.0.13 내꺼, 127.0.0.1 오라클꺼
    //계정 이름
    public static final String _USER = "scott";
    //비번
    public static final String _PW = "tiger";
    Connection con = null;
    Statement stmt = null;
    ResultSet rs = null;

    public OracleConnection2_10_25(){
        try{
            Class.forName(_DRIVER);
            con = DriverManager.getConnection(_URL, _USER,_PW);
        }
        catch (Exception e) {

        }
        System.out.println(con);
        String sql = "SELECT empno, ename, deptno FROM emp"; // 부적합 식별자면 이쪽을 확인 하면된다.
        try {
            stmt = con.createStatement();
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                System.out.println(rs.getInt("empno") + " " + rs.getString("ename") + " " + rs.getInt("deptno"));
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }

    }
    public static void main(String[] args) {
        new OracleConnection2_10_25();
    }
}
/*
Java API를 활용하여 오라클 서버에 접속하는 코드를 작성해 봅니다.
1. 오라클 회사가 제공하는 드라이버 클래스(ojdbc6.jar)를 로딩한다.
2.
3.
4.
*/