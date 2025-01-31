package classes_10_17.day1_10_17;
// 대주제 - 인스턴스화 설득
/* 생성자를 활용해 보기
생성자에서 사용자 정의 메소드 호출하기
main 메서드에서 사용자 정의 메서드 호출하기
뭐가 다르지? 뭐가 더 좋은거야?*/
import javax.swing.*;

public class Frame1_10_17 {
    // 멤버변수, 생성자, initDisplay
    JFrame frame; // 선언과 생성을 분리해 본다.(굳이)

    public Frame1_10_17() {
        // insert here
//        intiDisplay(true);
        /* setTitle 메서드로 하는 일을  생성자의 파라미터의 String을
        넣어주는 방법으로 해결이 가능하다. */
        frame = new JFrame("Frame 1"); // setTitle 호출하지 않아도 확인이 가능하다.
        // insert here
        intiDisplay(true);
    }

    public void intiDisplay(boolean isView) {
        frame.setSize(500,500);
        frame.setVisible(isView);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        Frame1_10_17 frame1 = new Frame1_10_17();
    }
}
