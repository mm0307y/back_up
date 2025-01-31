package day3_10_10.variable;

import javax.swing.*;

public class JFrame1_10_10 {
    public static void main(String[] args) {
        // JFrame은 UI를 담당하는 클래스라서 UI엥 대한 디폴트(기본) 값을
        // JVM이 정의한 내용을 가지고있다.
        JFrame frame = new JFrame();
        // 원시형 변수는 호출하면 값이 출력됩니다.
        // 참조형 변수는 호출하면 주소번지가 출력됩니다.
        System.out.println(frame);// frame변수는 참조형 변수입니다.
        System.out.println(frame.toString());
        String s = new String("이순신");
        s = "강감찬";
    }
}
