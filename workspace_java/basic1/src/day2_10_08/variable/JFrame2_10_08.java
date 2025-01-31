package day2_10_08.variable;

import javax.swing.*;

public class JFrame2_10_08 {
    public static void main(String[] args) {
        JFrame jFrame = new JFrame();
        jFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        JFrame jFrame2 = new JFrame();
        jFrame2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        String title = "카카오톡"; // 재정의
        jFrame.setTitle(title);
        int width = 600;
        int height = 500;
        jFrame.setSize(width, height);
        jFrame.setVisible(true);
        jFrame2.setSize(300, 500);
        jFrame2.setVisible(true);
    }
}
