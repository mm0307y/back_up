package athread_10_21.setp1_11_08;

import com_10_28.util_10_28.DBConnectionMgr_10_28;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TalkDao_11_11 {
    DBConnectionMgr_10_28 dbMgr = DBConnectionMgr_10_28.getInstance(); //싱글톤패턴
    Connection con = null;
    PreparedStatement pstmt= null;
    ResultSet rs = null;
    public String idFind(String mem_name, String mem_hp){
        String find_id = null;
        StringBuilder sql = new StringBuilder();
        sql.append("select mem_id from talk_member where mem_name=? and mem_hp=?");
        try{
            con = dbMgr.getConnection();
            pstmt = con.prepareStatement(sql.toString());
            pstmt.setString(1, mem_name);
            pstmt.setString(2, mem_hp);
            rs = pstmt.executeQuery();
            if(rs.next()){
                find_id = rs.getString("mem_id");
            }

        }
        catch (SQLException se){
            System.out.println(sql.toString());
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally { //사용한 자원 반납하기 - 자바튜닝팀 권장 - 명시적으로 상요한 자원을 반납하시오.
            dbMgr.freeConnection(con, pstmt, rs);
        }


        return find_id;
    }

    public String pwFind(String mem_id, String mem_name){
        String find_pw = null;
        StringBuilder sql = new StringBuilder();
        sql.append("select mem_pw from talk_member where mem_id=? and mem_name=?");
        try{
            con = dbMgr.getConnection();
            pstmt = con.prepareStatement(sql.toString());
            pstmt.setString(1, mem_id);
            pstmt.setString(2, mem_name);
            rs = pstmt.executeQuery();
            if(rs.next()){
                find_pw = rs.getString("mem_pw");
            }

        }
        catch (SQLException se){
            System.out.println(sql.toString());
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally { //사용한 자원 반납하기 - 자바튜닝팀 권장 - 명시적으로 상요한 자원을 반납하시오.
            dbMgr.freeConnection(con, pstmt, rs);
        }


        return find_pw;
    }

    public int memberInsert(String mem_id, String mem_pw, String nickname, String mem_name, String birthday, String mem_hp){
        int result = -1;
        StringBuilder sql = new StringBuilder();
        sql.append("insert into talk_member(mem_id, mem_pw, nickname, mem_name ,birthday, mem_hp) values(?,?,?,?,?,?)");
        try {
            con = dbMgr.getConnection();
            pstmt = con.prepareStatement(sql.toString());
            pstmt.setString(1, mem_id);
            pstmt.setString(2, mem_pw);
            pstmt.setString(3, nickname);
            pstmt.setString(4, mem_name);
            pstmt.setString(5, birthday);
            pstmt.setString(6, mem_hp);
            result = pstmt.executeUpdate();
            if (result == 1){
                System.out.println("정상적으로 처리 되었습니다.");
            }
            else {
                System.out.println("회원가입이 실패 하였습니다.");
            }

        } catch (SQLException se) { //부적합한 식별자, 테이블 또는 뷰가 존재하지 않습니다.
            //쿼리문의 디버깅은 토드와 같은 오라클 전용 프로그램을 사용한다.
            System.out.println(sql.toString());

        }catch (Exception e){
            System.out.println(e.toString());
        }
        return result;
    } ////end of memberInsert

    //메서드 설계하기 - 리턴 타입과 파라미터 타입을 결정할 수 있다.
    public boolean memIdCheck(String p_id){
        StringBuilder sql = new StringBuilder();
        sql.append("select mem_id from talk_member where mem_id=?");

        try{
            con = dbMgr.getConnection();
            pstmt = con.prepareStatement(sql.toString());
            pstmt.setString(1, p_id);
            rs = pstmt.executeQuery();
            if (rs.next()) { //rs.next()가 참이면 입력한 아이디가 존재한다.
                if (rs.getString("mem_id") != null) {
                    return true; //입력 받은 아이디가 존재합니다.
                }
                else {
                    return false; //입력 받은 아이디가 존재하지 않습니다.
                }
            }

        }catch (SQLException se){

        }
        catch (Exception e){
            throw new RuntimeException(e);
        }
        return false;
    }

    public static void main(String[] args) {
        TalkDao_11_11 dao = new TalkDao_11_11();
        //System.out.println(dao.memIdCheck("kiwi"));
    }
}
