package classes_10_17.day3_10_22;

import javax.swing.*;
import java.awt.*;

public class JFrameArray2_10_22 extends JFrame {
    JButton[] btns = new JButton[3];
    String[] btn_labels = {"Button 1", "Button 2", "Button 3"};

    public void initDisplay(){
        this.setLayout(new GridLayout(3,1));
        //btns.length == btn_labels.length -> true일때만 아래와 같이 개선이 가능하다.
        for(int i=0; i<btns.length; i++){
            btns[i] = new JButton(btn_labels[i]);
            this.add(btns[i]);
        }
        this.setSize(500, 300);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        JFrameArray2_10_22 frame = new JFrameArray2_10_22();
        frame.initDisplay();
    }
}
