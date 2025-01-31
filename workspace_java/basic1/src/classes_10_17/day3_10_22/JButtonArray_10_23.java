package classes_10_17.day3_10_22;

import javax.swing.*;

public class JButtonArray_10_23 {
    public static void main(String[] args) {
        JButton[] btn = new JButton[3];
        btn[0] = new JButton("Button 1");
        btn[1] = new JButton();
        btn[1].setText("Button 2");
        btn[2] = new JButton("Button 3");
        for (int i=0; i<btn.length; i++) {
            System.out.println(btn[i].getText()); // Button1, null, Button3
        }
    }
}
