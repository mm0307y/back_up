package classes_10_17.day3_10_22;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class TimerView_10_22 extends JFrame {
    JLabel jlb_timer = new JLabel("현재시간 : ", JLabel.CENTER);
    Font f = new Font("굴림체", Font.BOLD, 40);

    public TimerView_10_22() {
        initDisplay();
    }

    public void initDisplay(){
        jlb_timer.setFont(f);
        this.add("Center", jlb_timer);
        this.setSize(600,200);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //아래 코드에 대해서 리뷰하기
        //생성자 파라미터에 this를 사용하는 경우와 다른 크랠스를 사용하는 경우
        //구분할 수 있어야 한다.
        TimeClient1_10_22 tc = new TimeClient1_10_22(jlb_timer);
        tc.start();
    }

    public static void main(String[] args) {
        new TimerView_10_22();
    }
}
