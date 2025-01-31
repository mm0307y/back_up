package athread_10_21.talk3_10_28;

import com_10_28.util_10_28.DBConnectionMgr_10_28;
import jdbc_10_24.step1_10_24.DeptDTO_10_25;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DBUnitTest_10_28 {
    DBConnectionMgr_10_28 dbMgr = null;
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;

    public DBUnitTest_10_28() {
        dbMgr = DBConnectionMgr_10_28.getInstance();
        conn = dbMgr.getConnection();
        dbTest();
    }

    public void dbTest() {
        System.out.println(conn);
        //select count(deptno) from dept ->4
        String query = "SELECT deptno, dname, loc FROM dept";
        List<DeptDTO_10_25> list = new ArrayList<>();
        try{
            pstmt = conn.prepareStatement(query);
            //executeQuery()는 select일때 사용한다. 리턴아입이 ResultSet
            //조히ㅗ결과를 읽어온다. - 커서가 필요하다.
            //open...cursor,,,fetch..close
            rs = pstmt.executeQuery(); //executeUpdate():int - INSERT, UPDATE, DELETE
            DeptDTO_10_25 dto = null;
            while (rs.next()){ //4바퀴 반복한다.
                //생성자 파라미터 자리로 초기화를 처리하는 것 - 권장한다.
                dto = new DeptDTO_10_25(rs.getInt("deptno"), rs.getString("dname"), rs.getString("loc"));
                list.add(dto);
            }
            System.out.println(list.size());
            for (DeptDTO_10_25 ddto:list){
                System.out.println(ddto.getDeptno()); //4개의 주소번지를 출력한다.
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public static void main(String[] args) {
        new DBUnitTest_10_28();
    }
}
