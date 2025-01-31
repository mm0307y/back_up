package day4_10_11.variable;

import javax.swing.*;

public class JFrame1_10_11 {
    //선언부
    JFrame frame = null;

    //생성자
    public  JFrame1_10_11(){
        // 디폴트 생성자 입니다. - 파라미터가 없는 생성자를 말한다.
        frame = new JFrame();
    }

    // 화면 처리부
    public void initDisplay(){
        frame.setTitle("윈도우가 제공하는 창");
        frame.setSize(500,300);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(frame.DISPOSE_ON_CLOSE);
    }

    // 메인메소드
    public static void main(String[] args) {
        JFrame1_10_11 jf1 = new JFrame1_10_11();
        jf1.initDisplay();
    }
}
