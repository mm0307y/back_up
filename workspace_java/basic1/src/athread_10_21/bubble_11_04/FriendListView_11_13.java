package athread_10_21.bubble_11_04;

import com_10_28.util_10_28.DBConnectionMgr_10_28;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FriendListView_11_13 extends JFrame implements ActionListener {
    DBConnectionMgr_10_28 dbMgr = new DBConnectionMgr_10_28();
    Connection conn = dbMgr.getConnection();
    PreparedStatement pstmt = null;
    ResultSet rs = null;

    JPanel jp_center = new JPanel(); //색상, 정렬, 버튼, JLabel
    JScrollPane jsp_center = new JScrollPane(jp_center, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
    JPanel jp_south = new JPanel();
    JTextField jtf_msg = new JTextField(20);
    JButton jb_msg = new JButton("send");
    //홀수이면 초록, 짝수이면 오렌지
    int i = 1; //멤버변수

    public FriendListView_11_13() {
        initDisplay();
    } ////end of MessageRoom

    public List<Map<String, Object>> friendList(String mem_id){
        List<Map<String, Object>> list = new ArrayList<>();
        StringBuilder sql = new StringBuilder();
        sql.append("select mem.mem_id, fri.f_id, fri.relationship, mem.status_msg");
        sql.append(", mem1.status_msg, mem.mem_name, mem1.mem_name");
        sql.append(" from talk_member mem, talk_friend fri, talk_member mem1");
        sql.append(" where mem.mem_id = fri.mem_id");
        sql.append(" and fri.f_id = mem1.mem_id");
        sql.append(" and mem.mem_id = ?");

        try{
            conn = dbMgr.getConnection();
            pstmt = conn.prepareStatement(sql.toString());
            pstmt.setString(1, mem_id);
            rs = pstmt.executeQuery();
            Map<String, Object> map = null;
            while(rs.next()){
                map = new HashMap<>();
                map.put("mem_id", rs.getString("mem_id"));
                map.put("f_id", rs.getString("f_id"));
                map.put("relationship", rs.getString("relationship"));
                map.put("status_msg", rs.getString("status_msg"));
                map.put("mem_name", rs.getString("mem_name"));
                list.add(map);

            }
        }
        catch(SQLException se){
            System.out.println(se.getMessage());
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            dbMgr.freeConnection(conn, pstmt, rs);
        }

        return list;
    }

    public void initDisplay(){
        jtf_msg.addActionListener(this);
        jb_msg.addActionListener(this);

        jp_center.setLayout(new GridLayout(0,1));
        jp_south.setLayout(new BorderLayout());
        jp_south.add("Center", jtf_msg);
        jp_south.add("East", jb_msg);
        this.add("Center", jsp_center);
        this.add("South", jp_south);
        this.setSize(400,700);
        this.setVisible(true);
    } ////end of initDisplay

    public static void main(String[] args) {
        new FriendListView_11_13();
    } ////end of main

    @Override
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();

        if (obj == jb_msg || obj == jtf_msg) {
            JPanel jp_msg1 = new JPanel(new BorderLayout());
            JButton jbtn_img = new JButton("사진");
            JLabel jlb_status = new JLabel("1일 1커밋", JLabel.LEFT);
            JLabel jlb_id = new JLabel("apple",JLabel.CENTER);
            jp_msg1.add("West", jbtn_img);
            jp_msg1.add("Center", jlb_status);
            jp_msg1.add("East", jlb_id);
            JPanel jp_msg2 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
            if (i%2 ==1){
                jp_msg1.setBackground(Color.green);
                //jp_msg1.add(new JLabel("Message : " + i +  "->" + jtf_msg.getText()));
                jp_center.add(jp_msg1);
                i++;
            }
            else {
                jp_msg2.setBackground(Color.orange);
                jp_msg2.add(new JLabel("Message : " + i +  "->" + jtf_msg.getText()));
                jp_center.add(jp_msg2);
                i++;
            }
            jp_center.revalidate();
            jp_center.repaint();
            jtf_msg.setText("");
            //스크롤바 아래로 자동이동
            SwingUtilities.invokeLater(() -> jsp_center.getVerticalScrollBar().setValue(jsp_center.getVerticalScrollBar().getMaximum()));
        } ////end of if(JTextField에 엔터 치거나 전송 버튼 누르면)

    }
} ////end of MessageRoom_11_04
