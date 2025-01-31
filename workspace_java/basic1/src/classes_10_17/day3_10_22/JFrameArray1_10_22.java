package classes_10_17.day3_10_22;

import javax.swing.*;

public class JFrameArray1_10_22 extends JFrame {
    JButton[] btns = new JButton[3];

    public void initDisplay(){
//        btns[0] = new JButton("Button 1");
//        btns[1] = new JButton("Button 2");
//        btns[2] = new JButton("Button 3");
        for(int i=0; i<btns.length; i++){
            System.out.println(btns[i]); //null, null, null
        }
//        this.add("North", btns[0]);
//        this.add("South", btns[1]);
//        this.add("West", btns[2]);
        this.setSize(500, 300);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        JFrameArray1_10_22 frame = new JFrameArray1_10_22();
        frame.initDisplay();
    }
}
