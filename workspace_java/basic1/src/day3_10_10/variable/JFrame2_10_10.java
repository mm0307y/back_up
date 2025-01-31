package day3_10_10.variable;

import javax.swing.*;
import java.awt.*;

public class JFrame2_10_10 {
    public static void main(String[] args) {
        JFrame frame = new JFrame(); // 인스턴스화 하였다.
        Font f = new Font("궁서체", Font.BOLD, 35);
        JLabel label = new JLabel("로그인");
        label.setForeground(Color.RED);
        label.setFont(f);
        // 인스턴스화를 하면 heap메모리에 상주한다.
        // setSize(), setVisible() 호출할 수 있다.
        frame.setSize(300,300);
        frame.add("North", label);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
}
