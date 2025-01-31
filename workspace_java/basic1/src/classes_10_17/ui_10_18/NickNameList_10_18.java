package classes_10_17.ui_10_18;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class NickNameList_10_18 extends JFrame {
    //선언부
    String [] cols = {"대화명"};
    DefaultTableModel dtm = new DefaultTableModel(cols, 3);
    JTable jtb = new JTable(dtm);
    JScrollPane jsp = new JScrollPane(jtb
            ,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS
            ,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
    JPanel jp_south = new JPanel();
    JButton btn_one = new JButton("1 : 1");
    JButton btn_many = new JButton("n : n");
    JButton btn_emo = new JButton("이모티콘");
    JButton btn_exit = new JButton("종료");

    // 생성자
    public NickNameList_10_18() {
        initDisplay();
    }

    //화면그리기
    public void initDisplay(){
        System.out.println("initDisplay");
        //FlowLayout에서 Gridlayout으로 변경함 ~
        jp_south.setLayout(new GridLayout(2,2));
        jp_south.add(btn_one);
        jp_south.add(btn_many);
        jp_south.add(btn_emo);
        jp_south.add(btn_exit);

        this.add("Center",jsp);
        this.add("South",jp_south);
        this.setSize(400,500);
        this.setVisible(true);


    }
    //메인메서드
    public static void main(String[] args) {
        new NickNameList_10_18(); //생성자 호출하는 문장
    }
    
}
