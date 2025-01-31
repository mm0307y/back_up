package talk_10_16.step1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BorderLayout1_10_16 extends JFrame implements ActionListener {
    JButton jbtn_north = new JButton("North");
    JButton jbtn_south = new JButton("South");
    JButton jbtn_west = new JButton("West");
    JButton jbtn_east = new JButton("East");
    JButton jbtn_center = new JButton("Center");
    JPanel jp = new JPanel();
    // 화면을 그리는 메소드 선언하기
    // 메소드 중심의 코딩을 전개하는 연습하기
    
    public void initDisplay(){
        System.out.println("initDisplay 호출 성공");

        // 아래 문장이 있어야 actionPerformed메소드를
        // JVM이 이벤트가 감지되었을 때 호출한다.
        jbtn_north.addActionListener(this);
        jbtn_south.addActionListener(this);
        jbtn_west.addActionListener(this);
        jbtn_east.addActionListener(this);
        jbtn_center.addActionListener(this);

        // JFrame을 상속받아서 JFrame을 따로 인스턴스화를 하지 않아도 된다.
        // 코드 한줄이 줄었다.
        jp.setBackground(Color.GREEN);
        this.add("Center", jp);
        this.setSize(400,300);
        this.setVisible(true);
        this.setBackground(Color.GREEN);
        jp.setLayout(new BorderLayout());
        jp.add("North", jbtn_north);
        jp.add("South", jbtn_south);
        jp.add("West", jbtn_west);
        jp.add("East", jbtn_east);
        jp.add("Center", jbtn_center);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public static void main(String[] args) {
        BorderLayout1_10_16 bl = new BorderLayout1_10_16();
        bl.initDisplay();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();
        JButton btn = (JButton)obj;

        // if문 조건을 만족하면 else if 문에 있는 다른 조건들은 따지지 않습니다.
        // 왜냐면 첫번째 조건을 만족했고 실행문이 실행되고 나면 조건문 블록을
        // 빠져나가기 때문에 그렇습니다.
        if(jbtn_north == btn){
            System.out.println("북쪽버튼 눌렸다." + jbtn_north);
        }
        else if(jbtn_south == btn){
            System.out.println("남쪽버튼 눌렸다." + jbtn_south);
        }
        else if(jbtn_west == btn){
            System.out.println("서쪽버튼 눌렸다." + jbtn_west);
        }
        else if(jbtn_east == btn){
            System.out.println("동쪽버튼 눌렸다." + jbtn_east);
        }
        else if(jbtn_center == btn){
            System.out.println("중앙버튼 눌렸다."  + jbtn_center);
        }

    }
}
