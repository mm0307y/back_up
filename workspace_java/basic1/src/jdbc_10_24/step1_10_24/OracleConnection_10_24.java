package jdbc_10_24.step1_10_24;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class OracleConnection_10_24 {
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

    public OracleConnection_10_24() {

    }

    public DeptDTO_10_25[] getDeptList() {
        DeptDTO_10_25[] depts = null;
        DeptDTO_10_25 dto = null;

        try {
            Class.forName(_DRIVER);
            con = DriverManager.getConnection(_URL, _USER, _PW);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        System.out.println(con);
        String sql = "SELECT deptno, dname, loc FROM dept"; // 부적합 식별자면 이쪽을 확인 하면된다.
        try {
            stmt = con.createStatement();
            rs = stmt.executeQuery(sql);
            depts = new DeptDTO_10_25[4];
            int i = 0;
            while (rs.next()) {
                dto = new DeptDTO_10_25(rs.getInt("deptno"), rs.getString("dname"), rs.getString("loc")); //주소번지가 4번 바뀐다.
                depts[i] = dto; // 바뀔때마다 배열에 치환을 한다.
                i = i + i;
                System.out.println(dto);
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return depts; //depts.length=4
    }

    public DeptDTO_10_25[] getDeptList3() {
        DeptDTO_10_25[] depts = null;
        DeptDTO_10_25 dto = null;

        try {
            Class.forName(_DRIVER);
            con = DriverManager.getConnection(_URL, _USER, _PW);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        System.out.println(con);
        String sql = "SELECT deptno, dname, loc FROM dept"; // 부적합 식별자면 이쪽을 확인 하면된다.
        try {
            stmt = con.createStatement();
            rs = stmt.executeQuery(sql);
            System.out.println(rs.next());
            rs.next();
            while (rs.next()){
                System.out.println(rs.getInt("deptno") + " " + rs.getString("dname") + " " + rs.getString("loc"));
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return depts; //depts.length=4
    }

    //메소드 오버로딩 : 같은 이름의 메서드를 정의 할 때 반스딧 파라미터의 갯수 이거나 타입이 달라야 한다.
    public List<DeptDTO_10_25> getDeptList2() {
        List<DeptDTO_10_25> deptList = new ArrayList<>();
        DeptDTO_10_25 dto = null;

        try {
            Class.forName(_DRIVER);
            con = DriverManager.getConnection(_URL, _USER, _PW);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        System.out.println(con);
        String sql = "SELECT deptno, dname, loc FROM dept"; // 부적합 식별자면 이쪽을 확인 하면된다.
        try {
            stmt = con.createStatement();
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                System.out.println(rs.getInt("deptno") + " " + rs.getString("dname") + " " + rs.getString("loc"));
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return deptList; //deeptList.size() = 4
    }


    public static void main(String[] args) {
        OracleConnection_10_24 oc = new OracleConnection_10_24();
//        DeptDTO_10_25[] dto = oc.getDeptList();
//        DeptDTO_10_25[] dto = oc.getDeptList3();
        List<DeptDTO_10_25> list = oc.getDeptList2();
        System.out.println(list.get(0) instanceof DeptDTO_10_25); //true
        for (int i = 0; i < list.size(); i++) {
            DeptDTO_10_25 dto = list.get(i);
            System.out.println(dto.deptno + " " + dto.dname + " " + dto.loc);
        }
        /*
        System.out.println(dto); //null 출력
        for (DeptDTO_10_25 d : dto) {
            System.out.println(d.deptno + " " + d.dname + " " + d.loc);
        }
        */
    }
}
/*
Java API를 활용하여 오라클 서버에 접속하는 코드를 작성해 봅니다.
1. 오라클 회사가 제공하는 드라이버 클래스(ojdbc6.jar)를 로딩한다.
2.
3.
4.
*/