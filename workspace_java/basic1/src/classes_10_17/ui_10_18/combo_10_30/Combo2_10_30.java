package classes_10_17.ui_10_18.combo_10_30;

import classes_10_17.ui_10_18.refresh.JPanel1_10_18;
import com_10_28.util_10_28.DBConnectionMgr_10_28;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;
/*클래스의 구성요소는 변수화 메서드이다.
생성자의 파라미터 자리도 사용자가 결정한다.
JComboBox 객체 생성하기 - 초기화(객체의 특성)을 해야 할 때
JFrame if = new JFrame(); jf.setTitle("타이틀 제목");
JFrame if = new JFrame("타이틀 제목")
생성자를 활용하여 초기화 하는 값이 오라클 서버를 경유한 뒤에 결정되어야 한다면..
시간, 타임라인 - 기초가 아니다.
선언부와 생성부를 분리하여 처리하는 코딩 연습을 많이 해야한다.
화면처리(렌더링) 시점과 객체가 생성되는 그 시점 사이에 간격이 있다는 것
JComboBox에 생성자 자리에 들어갈 String[]을 결정하고, 결정된 값이 실제 콤보박스에 출력되도록 처리하기.
생성자로 처리하기, addItemAt()으로 처리하기.
클래스와 클래스 관계 처리하기(기초) -> 생성자 활용 능력 키우기. -> OOP 프로그래밍(객체지향 프로그램)*/
/*테스트 시나리오 작성해 보기
1) 처음화면이 그려질 때(렌더링) 그때 초기화하기
2) 이벤트가 발생할 때 그 때 초기화하기
*/

public class Combo2_10_30 extends JFrame implements ItemListener, ActionListener {
    JComboBox<String> combo = null;
    JMenuBar jmb = new JMenuBar();
    JMenu jm = new JMenu("Edit");
    JMenuItem jmi_db = new JMenuItem("DB테스트");
    JMenuItem jmi_ins = new JMenuItem("입력");
    JMenuItem jmi_upd = new JMenuItem("수정");
    JMenuItem jmi_det = new JMenuItem("상세보기");
    JMenuItem jmi_del = new JMenuItem("삭제");
    JSeparator jsep = new JSeparator();
    JMenuItem jmi_exit = new JMenuItem("종료");

    public Combo2_10_30() {
        initDisplay();
    }

    public void initDisplay(){
        //ActionListener안에 선언된 actionPerformed() 오버라이딩이 되었다면
        //괄호 안에 this를 사용 한다. - Combo2가 이벤트 처리를 담당하는 클래스이다.
        jmi_db.addActionListener(this);
        jm.add(jmi_db);
        jm.add(jmi_ins);
        jm.add(jmi_upd);
        jm.add(jmi_det);
        jm.add(jmi_del);
        jm.add(jsep);
        jm.add(jmi_exit);
        jmb.add(jm);
        this.setJMenuBar(jmb);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        if (combo == null) {
            combo = new JComboBox();
        }
        this.add("North", combo);
        this.setSize(500, 300);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        JFrame.setDefaultLookAndFeelDecorated(true);
        new Combo2_10_30();
    }

    @Override
    public void itemStateChanged(ItemEvent e) {

    }

    public JComboBox<String> dbTest(){
        DBConnectionMgr_10_28 dbMgr = DBConnectionMgr_10_28.getInstance(); //싱글턴 패턴
        Connection con = null;
        PreparedStatement pstme = null;
        ResultSet rs = null;
        StringBuilder sql = new StringBuilder();
        sql.append("select distinct (zdo) from zipcode_t");
        sql.append(" order by zdo asc");
        String zdos[] = null;
        Vector<String> v = new Vector<>();
        try {
            con = dbMgr.getConnection();
            pstme = con.prepareStatement(sql.toString());
            rs = pstme.executeQuery();
            while(rs.next()){
                System.out.println(rs.getString("zdo"));
                v.add(rs.getString("zdo")); //v.size() = 16
            }
            zdos = new String[v.size()];
            v.toArray(zdos);
            combo = new JComboBox(zdos);
        }
        catch (Exception e1) {
            e1.printStackTrace();
        }
        return combo;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //이벤트 소스를 찾는 코드 - 누가 클릭되었나? 값이 바뀌었나?
        Object obj = e.getSource();
        if (obj == jmi_db){
            System.out.println("DB연결");
            Container cont = this.getContentPane();
            if(combo != null){
                cont.remove(combo);
            }
            combo = dbTest();
            this.add("North", combo );
            cont.revalidate();
        }
    }
}

