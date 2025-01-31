package day6_10_15.variable;

import javax.swing.*;

public class NullPointer1_10_15 {
    public static void main(String[] args) {
        String s = null;
        System.out.println(s); // null 출련된다.
//        System.out.println(s.toString()); // NullPointerException 발생한다.

        /*
        JVM이 자동으로 찾을 수 있는 패키지는 java.lang 폴더 뿐이다.
        javax.swing.JFrame은 못 찾습니다. -> import javax.swing*;
        import javax.swing.JFrame
        */

        javax.swing.JFrame jf = null;
//        System.out.println(jf); // null
        System.out.println(jf.toString()); // NullPointerException
    }
}
