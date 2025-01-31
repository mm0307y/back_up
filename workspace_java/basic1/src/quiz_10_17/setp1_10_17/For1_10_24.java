package quiz_10_17.setp1_10_17;

import javax.swing.*;

public class For1_10_24 {
    public static void main(String[] args) {
        int is[] = {1, 2,3};
        for (int i:is){
            System.out.println(i); //1 2 3
        }
        String []names={"홍길동", "김유신", "강감찬"};
        for (String s:names){
            System.out.println(s);
        }
        JButton[] btns = new JButton[3];
        for (JButton b:btns){
            System.out.println(b);
        }
        //insert here

    }
}
