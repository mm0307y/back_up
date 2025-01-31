package classes_10_17.day3_10_22;

import javax.swing.*;
import java.awt.*;

public class JFrameArray3_10_22 extends JFrame {
    JButton[] btns = new JButton[3];
    String[] btn_labels = {"Button 1", "Button 2", "Button 3"};

    public void initDisplay(){
        this.setLayout(new GridLayout(3,1));
        //같은 주소번지에 새로운 버튼을 생성했으니깐 덮어쓰기 된 것과 동일하다.
        btns[0] = new JButton(btn_labels[0]);
        btns[0] = new JButton("첫번째 1");
        btns[1] = new JButton(btn_labels[1]);
        btns[1] = new JButton("두번째 2");
        btns[2] = new JButton(btn_labels[2]);
        btns[2] = new JButton("세번째 3");
        this.setSize(500, 300);
        this.setVisible(true);
        this.add(btns[0]);
        this.add(btns[1]);
        this.add(btns[2]);
    }

    public static void main(String[] args) {
        JFrameArray3_10_22 frame = new JFrameArray3_10_22();
        frame.initDisplay();
    }
}
