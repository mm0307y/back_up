package athread_10_21.talk3_10_28;

import com_10_28.util_10_28.DBConnectionMgr_10_28;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class TalkDao_10_31 {
    DBConnectionMgr_10_28 dbMgr = DBConnectionMgr_10_28.getInstance();
    Connection conn = dbMgr.getConnection();
    PreparedStatement pstmt1 = null;
    PreparedStatement pstmt2 = null;
    ResultSet rs = null;

    public String login(String user_id, String user_pw) {
        String mem_nick = null; //닉네임을 왜 지변으로 하죠? - 기초가 아니다.
        StringBuilder idCheck = new StringBuilder();
        StringBuilder sql_login = new StringBuilder();
        int status = 2; //1이면 아이디가 있다. -1이면 없다. mem_nick이 없다면 비번이 틀린거다.
        try{
           idCheck.append("select");
           idCheck.append(" nvl ((select 1 from dual");
           idCheck.append("         where exists (select mem_name from tomato_member");
           idCheck.append("                 where mem_id =: user_id)");
           idCheck.append("         ), -1) isID");
           idCheck.append(" from dual");
           conn = dbMgr.getConnection();
           pstmt1 = conn.prepareStatement(idCheck.toString());
           pstmt1.setString(1, user_id);
           rs = pstmt1.executeQuery();
           if (rs.next()) {
               status = rs.getInt("isID");
           }
           if (status == 1) { //아이디가 존해하면 비번을 비교한다.
               sql_login.append("select mem_nick from tomato_member");
               sql_login.append(" where mem_id=?");
               sql_login.append(" and mem_pw=?");
               pstmt2 = conn.prepareStatement(sql_login.toString());
               pstmt2.setString(1, user_id);
               pstmt2.setString(2, user_pw);
               rs = pstmt2.executeQuery();
               if (rs.next()) {
                   mem_nick = rs.getString("mem_nick");
               }
               else {
                   mem_nick = "비밀번호가 맞지 않습니다.";
               }
           }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return mem_nick;
    }

}