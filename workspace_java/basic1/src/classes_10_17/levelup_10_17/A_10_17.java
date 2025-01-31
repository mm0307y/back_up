package classes_10_17.levelup_10_17;

import javax.swing.*;

public class A_10_17 {
    public void methodA(JFrame frame) {
        System.out.println("methodA");
        System.out.println(frame); // null 출력 되도록 12라인을 수정하시오.
    }

    public static void main(String[] args) {
        A_10_17 a = new A_10_17();
        a.methodA(null);
    }
}
